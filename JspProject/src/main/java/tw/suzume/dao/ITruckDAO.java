package tw.suzume.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import tw.suzume.javabean.Truck;

public interface ITruckDAO {
	
	public ArrayList<Truck> queryAll() throws SQLException;
	public Truck queryById(int id) throws SQLException;
	public void insert(Truck truck) throws SQLException;
}
