package ptithcm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	private String Username;
	private String Password;
	private String Fullname;
	public Users() {
	}
	
	public Users(String username, String password, String fullname) {
		Username = username;
		Password = password;
		Fullname = fullname;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
}
