package co.za.tangent.service;

import static com.shazam.shazamcrest.matcher.Matchers.sameBeanAs;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.SortedMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.Employee;
import co.za.tangent.domain.Position;
import co.za.tangent.domain.Stats;
import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.util.LocalDateTI;


public class ServiceTest {
	
	private List<Employee> employees0;
	
	private List<Employee> employees1;
	
	@InjectMocks
	private EmployeeService employeeService;
	 
	@Mock
	private TangentClient tangentClient;
	
	@Spy 
	PositionService positionService;
	
	@Mock
	StatsService statsService;
	
	@Mock
	LocalDateTI dateNow;
    
	
	@Before
    public void setup() throws JsonParseException, JsonMappingException, IOException {
		MockitoAnnotations.initMocks(this);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		employees0 =  mapper.readValue(ServiceTest.class.getResource("employees0.json")
				, new TypeReference<List<Employee>>(){});
		employees1  =  mapper.readValue(ServiceTest.class.getResource("employees0.json")
				, new TypeReference<List<Employee>>(){});
		
		Mockito.when(dateNow.now()).thenReturn(LocalDate.now());
        
        Mockito.when(tangentClient.getEmployees(null, null, null, null, null, null, null, null))
        	.thenReturn( employees0 );
        
        statsService = new StatsService(dateNow);
        employeeService = new EmployeeService(positionService,tangentClient,statsService, dateNow);
	}

	@Test
	public void testGetEmployees(){
		List<Employee> employees = employeeService.getEmployees(null, null, null, null);
		assertThat(employees0, sameBeanAs(employees));
	}
	
	@Test
	public void testGetEmployeesCache(){
		List<Employee> employees = employeeService.getEmployees(null, null, null, null);
		
		//checking that cached employees are returned
		Mockito.when(tangentClient.getEmployees(null, null, null, null, null, null, null, null))
        	.thenReturn( employees1 );
		employees = employeeService.getEmployees(null, null, null, null);
		assertThat(employees0, sameBeanAs(employees));
		
		//checking that new server employees are returned
		Mockito.when(tangentClient.getEmployees(null, Race.B, null, null, null, null, null, null))
    	.thenReturn( employees1 );
		employees = employeeService.getEmployees(Race.B, null, null, null);
		assertThat(employees1, sameBeanAs(employees));
		
		//cache is old new employees should be loaded
		Mockito.when(tangentClient.getEmployees(null, null, null, null, null, null, null, null))
		.thenReturn( employees0 );
		employees = employeeService.getEmployees(null, null, null, null);
		assertThat(employees1, sameBeanAs(employees));
		Mockito.when(dateNow.now()).thenReturn(LocalDate.now().plus(Period.ofDays(1)));
		employees = employeeService.getEmployees(null, null, null, null);
		assertThat(employees0, sameBeanAs(employees));
	}
	
	@Test
	public void testPositions(){
		List<Employee> employees = employeeService.getEmployees(null, null, null, null);
		SortedMap<Long, Position> positions = positionService.getPositions();
		assertEquals(1, positions.size());
		assertThat(employees.get(0).getPosition(), sameBeanAs(positions.values().iterator().next()));
	}
	
	@Test
	public void testStats(){
		Mockito.when(dateNow.now()).thenReturn(LocalDate.of(2010, 07, 1));
		employeeService.getEmployees(null, null, null, null);
		Stats stats = statsService.getStats();
		assertEquals(new Integer(1), stats.getCountAll());
		//"gender": "M",
		assertEquals(new Long(1), stats.getCountByGender().get(Gender.M));
		assertEquals(new Long(0), stats.getCountByGender().get(Gender.F));
		
        //"race": "B"*
		assertEquals(new Long(1), stats.getCountByRace().get(Race.B));
		assertEquals(new Long(0), stats.getCountByRace().get(Race.W));
		
		//"position": {"id": 1,
		assertEquals(new Long(1), stats.getCountByPosition().get(1L));
		
		//"birth_date": "1981-07-30",
		assertEquals(1, stats.getBirthDaysThisMonth().size());
		
		
	}
	
	
	
	
	
}
