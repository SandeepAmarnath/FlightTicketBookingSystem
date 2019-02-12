package dao.interfaces.generics;

import java.util.List;

import model.IStorable;

public interface IReadable<T extends IStorable>{

	List<T> readAll();
	T readById(int id);
}
