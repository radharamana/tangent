package co.za.tangent.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.Employee;
import co.za.tangent.security.SecurityUtils;
import co.za.tangent.security.jwt.TokenProvider;

@RestController
@RequestMapping("/api")
public class EmployeeResource {
	@Autowired
	private TangentClient tangentClient;
	
	
	
	@Transactional(readOnly = true)
	@GetMapping("/employees")
	List<Employee> getEmployees( @RequestParam(value="race",required=false) String race
			, @RequestParam(value="position,",required=false) String position
			, @RequestParam(value="user",required=false) String user
			, @RequestParam(value="gender",required=false) String gender
			, @RequestParam(value="email",required=false) String email){
		return tangentClient.getEmployees(SecurityUtils.getRestToken(), race, position, user, gender, email, null, null);
	}
	
}
