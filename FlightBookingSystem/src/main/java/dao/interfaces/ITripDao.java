package dao.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import model.Plane;
import model.Trip;

public interface ITripDao extends ICreatable<Trip>,IReadable<Trip> {


	List<Trip> readBySourceCity(String cityName);

	List<Trip> readByPlane(Plane plane);

	List<Trip> readByStartDate(LocalDateTime startDate);
	
	Trip readByPlaneAndDepartDate(Plane plane, LocalDateTime departTime);
	
}
