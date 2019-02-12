package model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Admin.All", query = "SELECT a FROM Admin a"), })
public class Admin extends User {

	public Admin(String username, String phone, String email, String password) {
		super(username, phone, email, password);
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
