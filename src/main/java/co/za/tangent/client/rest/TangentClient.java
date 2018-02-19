package co.za.tangent.client.rest;




import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.User;
import io.github.polysantiago.spring.rest.RestClient;

@RestClient("tangent")
public interface TangentClient {
	
	@RequestMapping(value="/api-token-auth", method=RequestMethod.POST)
	String getToken(@RequestParam("username")String username, @RequestParam("password")String password);
	
	@RequestMapping(value="/api/user/me")
	User getUserProfile(@RequestHeader("Authorization") String token);
	
	@RequestMapping(value="/api/employee")
	List<Employee> getEmployees(@RequestHeader("Authorization") String token, @RequestParam()Map<String, String> filter);
	
	@RequestMapping(value="/api/employee/me")
	Employee getProfile(@RequestHeader("Authorization") String token);
	
}
