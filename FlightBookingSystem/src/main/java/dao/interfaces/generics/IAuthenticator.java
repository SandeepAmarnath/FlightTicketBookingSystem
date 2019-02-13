package dao.interfaces.generics;

import model.User;

public interface IAuthenticator<T extends User> {
	
	User login(String username, String password);
	boolean register(T t);
	boolean changePassword(String username, String oldPassword, String newPassword);

}
