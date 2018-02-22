package co.za.tangent.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;

public class Employee
{
	@JsonProperty("years_worked")
	private String yearsWorked;

    private Position position;

    private String phoneNumber;
    
    @JsonProperty("birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="CAT")
    private LocalDate birthDate;

    private String email;
    
    @JsonProperty("github_user")
    private String githubUser;

    private String age;

    @JsonProperty("days_to_birthday")
    private String daysToBirthday;

    private Gender gender;

    private Race race;

    private User user;

	public String getYearsWorked() {
		return yearsWorked;
	}

	public void setYearsWorked(String yearsWorked) {
		this.yearsWorked = yearsWorked;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithubUser() {
		return githubUser;
	}

	public void setGithubUser(String githubUser) {
		this.githubUser = githubUser;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDaysToBirthday() {
		return daysToBirthday;
	}

	public void setDaysToBirthday(String daysToBirthday) {
		this.daysToBirthday = daysToBirthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [yearsWorked=" + yearsWorked + ", position=" + position + ", phoneNumber=" + phoneNumber
				+ ", birthDate=" + birthDate + ", email=" + email + ", githubUser=" + githubUser + ", age=" + age
				+ ", daysToBirthday=" + daysToBirthday + ", gender=" + gender + ", race=" + race + ", user=" + user
				+ "]";
	}

    
}