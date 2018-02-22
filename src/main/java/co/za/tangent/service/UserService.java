package co.za.tangent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.Employee;
import co.za.tangent.domain.User;
import co.za.tangent.security.SecurityUtils;

/**
 * Service class for managing users.
 */
@Service
public class UserService {

	@Autowired
	TangentClient tangentClient;

	@Autowired
	EmployeeService employeeService;

    public User getUserWithRoles() {
        String restToken = SecurityUtils.getRestToken();
        if(SecurityUtils.getRestToken()==null)return null;
    	User user = tangentClient.getUserProfile(restToken);
    	user.setAuthorities(SecurityUtils.getCurrentUserAuthorties());
    	if(!employeeService.isCurrent()){
    		List<Employee> employees = tangentClient.getEmployees(restToken, null, null, null, null, null, null, null);
    		employeeService.setEmployee(employees);
    	}
    	
    	return user;
    }


    
}
