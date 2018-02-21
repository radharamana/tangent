package co.za.tangent.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;

import co.za.tangent.security.AjaxLogoutSuccessHandler;
import co.za.tangent.security.Http401UnauthorizedEntryPoint;
import co.za.tangent.security.RestAuthenicationProvider;
import co.za.tangent.security.jwt.JWTConfigurer;
import co.za.tangent.security.jwt.TokenProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private RestAuthenicationProvider restAuthenicationProvider;
    
    @Autowired
    private TokenProvider tokenProvider;

   

    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                .authenticationProvider(restAuthenicationProvider);
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Bean
    public Http401UnauthorizedEntryPoint http401UnauthorizedEntryPoint() {
        return new Http401UnauthorizedEntryPoint();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/test/**")
            .antMatchers("/content/**");
            
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	
     http
     	.exceptionHandling()
     	.authenticationEntryPoint(http401UnauthorizedEntryPoint())
     .and()   
     	.csrf()
        .disable()
        .headers()
        .frameOptions()
        .disable()
    .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and()
        .authorizeRequests()
        .antMatchers("/api/authenticate").permitAll()
        .antMatchers("/api/products").permitAll()
        .antMatchers("/api/vend").permitAll()
        .antMatchers("/api/**").authenticated()
     .and()
        .apply(securityConfigurerAdapter());
    }
    
    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(tokenProvider);
    }
    
    
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}