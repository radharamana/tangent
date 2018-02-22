package co.za.tangent.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	LocalDate refreshDate;
	
	private Map<User, Employee> employees = new HashMap<User, Employee>();
	
	public void setEmployee(List<Employee> employees){
		refreshDate = LocalDate.now();
		employees.stream().collect(Collectors.toMap(Employee::getUser, (e)->e));
		positionService.doPopulatePosition(employees);
	}

	public boolean isCurrent(){
		return employees.size() > 0 && LocalDate.now().equals(refreshDate);
	}

	public List<Employee> getEmployees(Race race, Long position, Gender gender, String email) {
		if(position == null && position == null && gender == null && email == null && isCurrent()){
			return employees.values().stream().collect(Collectors.toList());
		}else{
			List<Employee> filterEmployees = tangentClient.getEmployees(SecurityUtils.getRestToken()
					, race==null?null:race.getValue(), position==null?null:position.toString()
					, gender==null?null:gender.getValue(), email, null, null, null);
			if(position == null && position == null && gender == null && email == null)setEmployee(filterEmployees);
			return filterEmployees;
		}
	}
}
