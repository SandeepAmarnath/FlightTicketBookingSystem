package model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import businessLogic.CityBL;
import businessLogic.PassengerBL;
import dao.jpa.CityJpaDao;
import dao.jpa.PassengerJpaDao;
import dao.jpa.PlaneJpaDao;

public class ModelTestAPP {
	
	
	public static void main(String[] args) {
			
		
		//Testing PassengerBL
		PassengerBL passengerBL = new PassengerBL();
		passengerBL.register("Naveen", "Kumar", "NaveenKumar", "naveen@gmail.com", "123456", "12345678909", "L67TR34Y");
		passengerBL.register("Sandeep", "Kumar", "SandeepAmarnath", "naveen@gmail.com", "123456", "12345678909", "L67TX34Y");
		System.err.println("Passengers' List:\n "+passengerBL.readAll());
		System.err.println("Passenger with userId 2\n"+passengerBL.readById(2));
		System.err.println("Passenger readByUsername --> Passing username - SandeepAmarnath\n"+passengerBL.readByUserName("SandeepAmarnath"));
		System.err.println("Passengers with last name Kumar\n"+passengerBL.readByLastName("Kumar"));
		System.err.println("Passengers login test-->Testing NaveenKumar, 123456\n"+passengerBL.login("NaveenKumar", "123456"));
		System.err.println("Passenger readbyPassport -->Testing Naveen's Passport L67TR34Y\n"+passengerBL.readByPassport("L67TR34Y"));
		
		System.err.println("PASSENGER BUSINESS LOGIC TESTED SUCCESSFULLY");
		
		
	}

}
