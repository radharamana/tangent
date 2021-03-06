package co.za.tangent.client.rest;




import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.User;
import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.dto.LoginDTO;
import io.github.polysantiago.spring.rest.RestClient;

@RestClient("tangent")
public interface TangentClient {
	
	@RequestMapping(value="/api-token-auth/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	TangentTokenDTO doAuth(@RequestBody LoginDTO login);
	
	@GetMapping("/api/user/me/")
	User getUserProfile(@RequestHeader("Authorization") String token);
	
	@GetMapping("/api/employee/")
	List<Employee> getEmployees(@RequestHeader("Authorization") String token
			, @RequestParam(value="race",required=false) Race race
			, @RequestParam(value="position",required=false) Long positionId
			, @RequestParam(value="gender",required=false) Gender gender
			, @RequestParam(value="email__contains",required=false) String email
			, @RequestParam(value="start_date_range",required=false) String start_date_range
			, @RequestParam(value="birth_date",required=false) String birthDate
			, @RequestParam(value="user",required=false) String user
			
			);
	
	@GetMapping("/api/employee/me/")
	Employee getMe(@RequestHeader("Authorization") String token);
	
}
