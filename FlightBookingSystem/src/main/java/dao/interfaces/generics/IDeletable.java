package dao.interfaces.generics;

import model.IStorable;

public interface IDeletable<T extends IStorable> {

	boolean delete(T t);
}
