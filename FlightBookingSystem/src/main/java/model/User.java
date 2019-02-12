package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "All_Users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements IStorable{

	@Id
	@Column(name = "userId")
	@SequenceGenerator(name = "userId", sequenceName = "userId", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "userId")
	private int userId;

	@Column(name = "username")
	private String username;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public User(String username, String phone, String email, String password) {

		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}

}
