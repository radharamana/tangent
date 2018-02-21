package co.za.tangent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.domain.User;
import co.za.tangent.security.SecurityUtils;
import co.za.tangent.security.jwt.TokenProvider;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class UserService {

	@Autowired
	TangentClient tangentClient;

	@Autowired
	TokenProvider tokenProvider;

    @Transactional(readOnly = true)
    public User getUserWithRoles() {
        String restToken = SecurityUtils.getRestToken();
        if(SecurityUtils.getRestToken()==null)return null;
    	User user = tangentClient.getUserProfile(restToken);
    	user.setAuthorities(SecurityUtils.getCurrentUserAuthorties());
    	return user;
    }


    
}
