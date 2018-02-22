
package co.za.tangent.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "user",
    "position",
    "employee_next_of_kin",
    "employee_review",
    "id_number",
    "phone_number",
    "physical_address",
    "tax_number",
    "email",
    "personal_email",
    "github_user",
    "birth_date",
    "start_date",
    "end_date",
    "id_document",
    "visa_document",
    "is_employed",
    "is_foreigner",
    "gender",
    "race",
    "years_worked",
    "age",
    "next_review",
    "days_to_birthday",
    "leave_remaining"
})
public class Employee {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("position")
    private Position position;
    @JsonProperty("employee_next_of_kin")
    private List<EmployeeNextOfKin> employeeNextOfKin = null;
    @JsonProperty("employee_review")
    private List<EmployeeReview> employeeReview = null;
    @JsonProperty("id_number")
    private String idNumber;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("physical_address")
    private String physicalAddress;
    @JsonProperty("tax_number")
    private String taxNumber;
    @JsonProperty("email")
    private String email;
    @JsonProperty("personal_email")
    private String personalEmail;
    @JsonProperty("github_user")
    private String githubUser;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("id_document")
    private String idDocument;
    @JsonProperty("visa_document")
    private String visaDocument;
    @JsonProperty("is_employed")
    private Boolean isEmployed;
    @JsonProperty("is_foreigner")
    private Boolean isForeigner;
    @JsonProperty("gender")
    private Gender gender;
    @JsonProperty("race")
    private Race race;
    @JsonProperty("years_worked")
    private Integer yearsWorked;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("next_review")
    private String nextReview;
    @JsonProperty("days_to_birthday")
    private Integer daysToBirthday;
    @JsonProperty("leave_remaining")
    private String leaveRemaining;
    
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("position")
    public Position getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position position) {
        this.position = position;
    }

    @JsonProperty("employee_next_of_kin")
    public List<EmployeeNextOfKin> getEmployeeNextOfKin() {
        return employeeNextOfKin;
    }

    @JsonProperty("employee_next_of_kin")
    public void setEmployeeNextOfKin(List<EmployeeNextOfKin> employeeNextOfKin) {
        this.employeeNextOfKin = employeeNextOfKin;
    }

    @JsonProperty("employee_review")
    public List<EmployeeReview> getEmployeeReview() {
        return employeeReview;
    }

    @JsonProperty("employee_review")
    public void setEmployeeReview(List<EmployeeReview> employeeReview) {
        this.employeeReview = employeeReview;
    }

    @JsonProperty("id_number")
    public String getIdNumber() {
        return idNumber;
    }

    @JsonProperty("id_number")
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("physical_address")
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    @JsonProperty("physical_address")
    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    @JsonProperty("tax_number")
    public String getTaxNumber() {
        return taxNumber;
    }

    @JsonProperty("tax_number")
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("personal_email")
    public String getPersonalEmail() {
        return personalEmail;
    }

    @JsonProperty("personal_email")
    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    @JsonProperty("github_user")
    public String getGithubUser() {
        return githubUser;
    }

    @JsonProperty("github_user")
    public void setGithubUser(String githubUser) {
        this.githubUser = githubUser;
    }

    @JsonProperty("birth_date")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birth_date")
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("id_document")
    public String getIdDocument() {
        return idDocument;
    }

    @JsonProperty("id_document")
    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    @JsonProperty("visa_document")
    public String getVisaDocument() {
        return visaDocument;
    }

    @JsonProperty("visa_document")
    public void setVisaDocument(String visaDocument) {
        this.visaDocument = visaDocument;
    }

    @JsonProperty("is_employed")
    public Boolean getIsEmployed() {
        return isEmployed;
    }

    @JsonProperty("is_employed")
    public void setIsEmployed(Boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    @JsonProperty("is_foreigner")
    public Boolean getIsForeigner() {
        return isForeigner;
    }

    @JsonProperty("is_foreigner")
    public void setIsForeigner(Boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @JsonProperty("race")
    public Race getRace() {
        return race;
    }

    @JsonProperty("race")
    public void setRace(Race race) {
        this.race = race;
    }

    @JsonProperty("years_worked")
    public Integer getYearsWorked() {
        return yearsWorked;
    }

    @JsonProperty("years_worked")
    public void setYearsWorked(Integer yearsWorked) {
        this.yearsWorked = yearsWorked;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("next_review")
    public String getNextReview() {
        return nextReview;
    }

    @JsonProperty("next_review")
    public void setNextReview(String nextReview) {
        this.nextReview = nextReview;
    }

    @JsonProperty("days_to_birthday")
    public Integer getDaysToBirthday() {
        return daysToBirthday;
    }

    @JsonProperty("days_to_birthday")
    public void setDaysToBirthday(Integer daysToBirthday) {
        this.daysToBirthday = daysToBirthday;
    }

    @JsonProperty("leave_remaining")
    public String getLeaveRemaining() {
        return leaveRemaining;
    }

    @JsonProperty("leave_remaining")
    public void setLeaveRemaining(String leaveRemaining) {
        this.leaveRemaining = leaveRemaining;
    }

    

}
