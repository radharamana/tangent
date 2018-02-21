package co.za.tangent.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User
{
    private String id;

    @JsonProperty("first_name")
    private String firstName;

    private String username;

    @JsonProperty("is_staff")
    private String isStaff;

    @JsonProperty("is_active")
    private String isActive;

    private String email;

    @JsonProperty("last_name")
    private String lastName;
    
    private Set<Authority> authorities = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIsStaff() {
		return isStaff;
	}

	public void setIsStaff(String isStaff) {
		this.isStaff = isStaff;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", username=" + username + ", isStaff=" + isStaff
				+ ", isActive=" + isActive + ", email=" + email + ", lastName=" + lastName + "]";
	}

    
}