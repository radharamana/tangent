package co.za.tangent.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.Employee;
import co.za.tangent.domain.User;
import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.security.SecurityUtils;

@Service
public class EmployeeService {
	@Autowired
	PositionService positionService;
	
	@Autowired
	TangentClient tangentClient;
	
	@Autowired
	StatsService statisticsService;
	
	LocalDate refreshDate;
	
	private Map<User, Employee> employees = new HashMap<User, Employee>();
	
	public void setEmployee(List<Employee> employees){
		if(employees == null)return;
		refreshDate = LocalDate.now();
		this.employees = employees.stream().collect(Collectors.toMap(Employee::getUser, Function.identity()));
		positionService.doPopulatePosition(employees);
		statisticsService.doPopulateStatistics(employees);
	}

	public boolean isCurrent(){
		return employees.size() > 0 && LocalDate.now().equals(refreshDate);
	}

	public List<Employee> getEmployees(Race race, Long positionId, Gender gender, String email) {
		if(race == null && positionId == null && gender == null && email == null && isCurrent()){
			return employees.values().stream().collect(Collectors.toList());
		}else{
			List<Employee> filterEmployees = tangentClient.getEmployees(SecurityUtils.getRestToken()
					, race, positionId, gender, email, null, null, null);
			if(positionId == null && race == null && gender == null && email == null)setEmployee(filterEmployees);
			return filterEmployees;
		}
	}
}
