package anil.it.binding;


public class RegistrationForm {
	
    private String name;
	
	private String email;
	
	private String password;
	
	private Long phoneNum;
	
	private String country;
	
	private String state;
	
	private String city;
	
	private String passwordUpdated;
	

	public RegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegistrationForm(String name, String email, String password, Long phoneNum, String country, String state,
			String city, String passwordUpdated) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.country = country;
		this.state = state;
		this.city = city;
		this.passwordUpdated = passwordUpdated;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPasswordUpdated() {
		return passwordUpdated;
	}


	public void setPasswordUpdated(String passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}


	@Override
	public String toString() {
		return "RegistrationForm [name=" + name + ", email=" + email + ", password=" + password + ", phoneNum="
				+ phoneNum + ", country=" + country + ", state=" + state + ", city=" + city + ", passwordUpdated="
				+ passwordUpdated + "]";
	}

}
