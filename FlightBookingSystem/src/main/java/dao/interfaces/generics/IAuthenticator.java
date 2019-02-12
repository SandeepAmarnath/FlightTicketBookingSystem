package dao.interfaces.generics;

import model.User;

public interface IAuthenticator {
	
	User login(String username, String password);
	User register(String username, String password, String phone, String address, String passport); //since admin need not be registered,
																									// passport is for passenger registration

}
