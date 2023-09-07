package com.jspiders.cardekho_case_study_jdbc.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study_jdbc.entity.Car;

public class CarOperation {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static int result; 
	private static String filePath = "D:\\WEJA2\\jdbc\\resources\\db_info.properties";
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String query;
	
	
	public void openConnection() {
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("drivePath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Scanner scanner = new Scanner(System.in);
	public void addCarDetails() {
		try {
			openConnection();
			query = "insert into car values (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("How many car details you want to add? ");
			int choice = scanner.nextInt();
			
			for (int i = 1; i <= choice; i++) {
	
				System.out.print("Enter car id : ");
				int car_id = scanner.nextInt();
				preparedStatement.setInt(1, car_id);
				System.out.print("Enter car name : ");
				String name = scanner.next();
				preparedStatement.setString(2, name);
				System.out.print("Enter car brand : ");
				String brand = scanner.next();
				preparedStatement.setString(3, brand);
				System.out.print("Enter car fuel type : ");
				String fuel_type = scanner.next();
				preparedStatement.setString(4, fuel_type);
				System.out.print("Enter car price : ");
				double price = scanner.nextDouble();
				preparedStatement.setDouble(5, price);
				result = preparedStatement.executeUpdate();
			}
			System.out.println("Query OK, "+result+" row(s) affected...");
			getAllCarDetails();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void removeCarDetails() {
		try {
			getAllCarDetails();
			openConnection();
			query = "delete from car where car_id=?";
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Enter the car id do you want to delete");
			int car_id = scanner.nextInt();
			
			preparedStatement.setInt(1, car_id);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println("Result Ok, "+result+ " row(s) affected...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void getAllCarDetails() {
		try {
			openConnection();
			query = "select * from car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Car car = new Car();
				
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByName() {
		try {
			openConnection();
			query = "select * from car where name=?";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the car name do you want to search");
			String name = scanner.next();
			preparedStatement.setString(1, name);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Car car = new Car();
				
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByBrand() {
		try {
			openConnection();
			query = "select * from car where brand=?";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the car name do you want to search");
			String brand = scanner.next();
			preparedStatement.setString(1, brand);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Car car = new Car();
				
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void searchByFuelType() {
		try {
			openConnection();
			query = "select * from car where fuel_type=?";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the car name do you want to search");
			String fuel_type = scanner.next();
			preparedStatement.setString(1, fuel_type);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Car car = new Car();
				
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	public void searchByprice() {
		try {
			openConnection();
			query = "select * from car where price=?";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the car name do you want to search");
			double price = scanner.nextDouble();
			preparedStatement.setDouble(1, price);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Car car = new Car();
				
				car.setCar_id(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				
				System.out.println(car);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	public void editCarDetails() {
		try {
			getAllCarDetails();
			openConnection();
			query = "update car set name=? where car_id = ?";
			preparedStatement = connection.prepareStatement(query);
			
			System.out.println("Enter the car name do you want to update");
			String name = scanner.next();
			System.out.println("Enter the car_id do you want to update the car name");
			int car_id = scanner.nextInt();
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, car_id);
			
			result = preparedStatement.executeUpdate();
			
			System.out.println("Result Ok, "+result+ " row(s) affected...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
