package co.za.tangent.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.Employee;
import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
	@Autowired
	private TangentClient tangentClient;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	List<Employee> getEmployees( 
			@RequestParam(value="race",required=false) Race race
			, @RequestParam(value="position.name",required=false) Long position
			, @RequestParam(value="gender",required=false) Gender gender
			, @RequestParam(value="email",required=false) String email){
		
		return employeeService.getEmployees(race, position, gender, email);
				
	}
	
}
