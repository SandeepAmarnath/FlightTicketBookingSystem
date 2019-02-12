package dao.interfaces;

import dao.interfaces.generics.IAuthenticator;
import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Admin;

public interface IAdminDao extends IAuthenticator, ICreatable<Admin>, IUpdatable<Admin>, IReadable<Admin> {

	Admin readByName(String adminName);

}
