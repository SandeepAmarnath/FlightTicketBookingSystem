package dao.interfaces;

import dao.interfaces.generics.IAuthenticator;
import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Passenger;

public interface IPassengerDao
		extends IAuthenticator, ICreatable<Passenger>, IUpdatable<Passenger>, IReadable<Passenger> {

	Passenger readbyName(String passengerName);

	Passenger readByPassport(String passport);

}
