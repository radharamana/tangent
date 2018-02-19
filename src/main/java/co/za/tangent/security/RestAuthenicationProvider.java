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

import co.za.tangent.client.rest.TangentClient;
import co.za.tangent.security.jwt.TokenProvider;

public class RestAuthenicationProvider implements AuthenticationProvider {
	private final Logger log = LoggerFactory.getLogger(RestAuthenicationProvider.class);
	
	@Autowired
	private TangentClient tangentClient;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
        try {
        	String username = auth.getName();
            String password = auth.getCredentials().toString();
            String token = tangentClient.getToken(username, password);
            tokenProvider.setTangentToken(token);
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
        } catch (Exception e) {
        	log.error("Error authenicating user, not found: " + e.getMessage(), e);
        	throw new BadCredentialsException("Invalid credentials");
        }
        
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
