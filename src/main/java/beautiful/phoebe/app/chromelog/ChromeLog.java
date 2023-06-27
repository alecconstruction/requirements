package beautiful.phoebe.app.chromelog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChromeLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String mainUrl;
	private String loginPageUrl;
	private String userName;
	private String decryptedPassword;
	private String dateOfCreation;
	private String lastUsage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMainUrl() {
		return mainUrl;
	}
	public void setMainUrl(String mainUrl) {
		this.mainUrl = mainUrl;
	}
	public String getLoginPageUrl() {
		return loginPageUrl;
	}
	public void setLoginPageUrl(String loginPageUrl) {
		this.loginPageUrl = loginPageUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDecryptedPassword() {
		return decryptedPassword;
	}
	public void setDecryptedPassword(String decryptedPassword) {
		this.decryptedPassword = decryptedPassword;
	}
	public String getDateOfCreation() {
		return dateOfCreation;
	}
	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public String getLastUsage() {
		return lastUsage;
	}
	public void setLastUsage(String lastUsage) {
		this.lastUsage = lastUsage;
	}
	
	
}
