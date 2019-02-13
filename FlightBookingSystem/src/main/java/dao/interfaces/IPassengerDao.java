package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.IAuthenticator;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Passenger;

public interface IPassengerDao
		extends IAuthenticator<Passenger>, IUpdatable<Passenger>, IReadable<Passenger> {

	List<Passenger> readbyName(String passengerName);

	Passenger readByPassport(String passport);

	Passenger readByUserName(String username);
}
