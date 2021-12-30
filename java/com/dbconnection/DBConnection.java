package com.dbconnection;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.flyaway.*;

import java.io.*;

public class DBConnection {

	private final String URL = "jdbc:mysql://localhost:3306/flyaway";
	private final String USER = "root";
	private final String PASSWORD = "Test@123";
	private Connection connection = null;
	
	public DBConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection Established");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("DB Error");
		}				
	}
	
	// Get DB Connection 
	public Connection getConnection() {
		return this.connection;
	}
	
	//Insert into Table
	public boolean userRegistration(UserDetail user) {
		boolean flag = false;
		if(connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement("INSERT INTO users VALUES(?, ?, ?, ?)");
				ps.setString(1,user.getEmail());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getFirstName());
				ps.setString(4,user.getLastName());
				System.out.println("In statement");
				int row_added = ps.executeUpdate();
				System.out.println("In update");
				if(row_added > 0) {
					System.out.println("New record inserted!");
					flag = true;
				}else if(row_added == 0) {
					System.out.println("No new record inserted!");
				}
			}catch(SQLException e) {
				System.out.println("Problem in Data insertion");
				return false;
			}
		}
		return flag;
	}
	
	// User Login Check
	 public UserDetail userLoginCheck(String email,String password){
		UserDetail user = null;
		if(connection != null) {
			try {
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email=? and password=?");
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					user = new UserDetail();
					System.out.println("User Found!!");				
					user.setFirstName(rs.getString("firstname"));
				//	user.setEmail(email);
				//	user.setPassword(password);
					System.out.println();
				}else {
					System.out.println("User Not Found!!");
				}
			}catch(SQLException e) {
				System.out.println("Problem in User's Login Check");
				return user;
			}
		}
		return user;
	}
	// Get Route_id and Flight_no from DB
	 
	 public List<FlightDetails> getAvailableFlights(String source,String destination, String travelDate) {
		List <FlightDetails> flights = new ArrayList();
		 if(connection != null) {
			 try {
				// String query = "select flights.flight_no, flights.airline, flights.price, routes.duration from flights inner join routes on flights.flight_no=(select flight_route.flight_no from flight_route where flight_route.route_id=(select routes.route_id from routes where routes.source='"+source+"' and routes.destination='"+destination+"')) and routes.route_id=(select routes.route_id from routes where routes.source='"+source+"' and routes.destination='"+destination+"')";
				 String query = "select flights.flight_no, flights.airline, flights.price, routes.duration from flights,routes where flights.flight_no in(select flight_route.flight_no from flight_route where flight_route.route_id=(select routes.route_id from routes where routes.source='"+source+"' and routes.destination='"+destination+"')) and routes.route_id=(select routes.route_id from routes where routes.source='"+source+"' and routes.destination='"+destination+"')";
				 //PreparedStatement ps = connection.prepareStatement("select * from flights;");
				 Statement stm = connection.createStatement();
				 ResultSet rs = stm.executeQuery(query);
				 while(rs.next()) {
					FlightDetails flight = new FlightDetails();
					flight.setAirline(rs.getString("airline"));
					flight.setFlight_no(rs.getString("flight_no"));
					flight.setPrice(rs.getDouble("price"));
					flight.setDuration(rs.getTime("duration"));
					flights.add(flight);
				 }
			 }catch(SQLException e) {
				 System.out.println("Problem in fetching data");
				 return flights;
			 }			   
		 }
		 return flights;
	 }	 
	  
	// DB Connection close	
	public void closeConnection() {
		try {
			this.connection.close();
		}catch(SQLException e){
			System.out.println("Problem in closing Connection");
		}
	}
}
