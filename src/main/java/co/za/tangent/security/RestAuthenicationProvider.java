package co.za.tangent.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.dto.LoginDTO;
import co.za.tangent.security.jwt.TokenProvider;

@Component
public class RestAuthenicationProvider implements AuthenticationProvider {
	private final Logger log = LoggerFactory.getLogger(RestAuthenicationProvider.class);
	
	@Autowired
	private TangentClient tangentClient;
	
	
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
        try {
        	LoginDTO login = new LoginDTO(auth.getName(),auth.getCredentials().toString());
            String token = tangentClient.doAuth(login).getToken();
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantedAuths.add(new SimpleGrantedAuthority("Token "+token));
            return new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword(), grantedAuths);
        } catch (ResourceAccessException e) {
        	log.error("ResourceAccessException: " + e.getMessage(), e);
        	throw e;
        } catch(Exception e){
        	log.error("Unable to authenticate: " + e.getMessage(), e);
        	throw new BadCredentialsException("Credentials are invalid");
        }
        
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
