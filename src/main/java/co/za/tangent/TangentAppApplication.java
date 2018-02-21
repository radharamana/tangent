package co.za.tangent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.polysantiago.spring.rest.EnableRestClients;

@EnableRestClients
@SpringBootApplication
public class TangentAppApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(TangentAppApplication.class, args);
	}
	
	
	
	
}
