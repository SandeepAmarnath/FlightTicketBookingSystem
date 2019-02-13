package dao.interfaces;

import java.time.LocalDate;
import java.util.List;
import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Plane;
import model.Trip;

public interface ITripDao extends ICreatable<Trip>,IReadable<Trip> {


	List<Trip> readBySourceCity(String cityName);

	List<Trip> readByStartDate(LocalDate startDate);

	List<Trip> readByPlane(Plane plane);

}
