package dao.interfaces;

import java.util.List;

import dao.interfaces.generics.ICreatable;
import dao.interfaces.generics.IReadable;
import dao.interfaces.generics.IUpdatable;
import model.Plane;

public interface IPlaneDao extends ICreatable<Plane>, IUpdatable<Plane>, IReadable<Plane> {


	List<Plane> readByNameLike(String planeNameLike);

}
