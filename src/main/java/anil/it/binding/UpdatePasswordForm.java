package anil.it.binding;

public class UpdatePasswordForm {
	
	private Integer userId;
	
	private String newPassword;
	
	private String confirmPassword;

	public UpdatePasswordForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePasswordForm(Integer userId, String newPassword, String confirmPassword) {
		super();
		this.userId = userId;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UpdatePasswordForm [userId=" + userId + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}

	
	
	

}
