package co.za.tangent.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginDTO {
	@NotNull
	@Size(min = 1, max = 50)
	private String username;
	
	@NotNull
    @Size(min = 4, max = 100)
    private String password;
	
	
	
	public LoginDTO() {
		super();
		
	}

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
