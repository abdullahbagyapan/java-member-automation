package type;

import java.security.KeyStore.PasswordProtection;

public class MemberContract {
	private int id;
	private String name;
	private String surname;
	
	private String userName;
	private char[] password;
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		String pw = "";
		for (int i=0; i<this.password.length;i++) {
			pw+=this.password[i];
		}
		return pw;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setPassword(char[] password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return name+" "+surname;
	}
}
