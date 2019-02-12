package dao.interfaces;

import java.time.LocalDate;
import java.util.List;
import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Trip;

public interface ITripDao extends ICreatable<Trip>,IReadable<Trip> {

	List<Trip> readByPlane(String planeName);

	List<Trip> readBySourceCity(String cityName);

	List<Trip> readByDestination(String cityName);

	List<Trip> readByStartDate(LocalDate startDate);
}
