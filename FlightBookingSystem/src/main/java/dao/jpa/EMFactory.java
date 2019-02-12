package dao.jpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class EMFactory {
	
	private static EntityManagerFactory EMF;
	public EMFactory() {
		
	}
	public static EntityManager getEntityManager(){
		if (EMF==null || !EMF.isOpen()) {
			EMF = Persistence.createEntityManagerFactory("FlightBookingSystem");		
		}
		return EMF.createEntityManager();
		
	}
	
	public static void close(){
		EMF.close();
	}
	
}
