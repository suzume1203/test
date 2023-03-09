package tw.suzume.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tw.suzume.javabean.Truck;

public class TruckDao implements ITruckDAO {

	private Connection conn;

	public TruckDao() {
	}

	public TruckDao(Connection conn) {
		this.conn = conn;
	}

	@Override
	public ArrayList<Truck> queryAll() throws SQLException {
		ArrayList<Truck> trucks = new ArrayList<Truck>();
		PreparedStatement prestat = conn.prepareStatement("SELECT * FROM Truck");
		ResultSet rs = prestat.executeQuery();
		while (rs.next()) {
			Truck truck = new Truck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			trucks.add(truck);
		}
		rs.close();
		prestat.close();
		return trucks;
	}

	@Override
	public Truck queryById(int id) throws SQLException {
		PreparedStatement prestat = conn.prepareStatement("SELECT * FROM Truck where id = ?");
		prestat.setInt(1, id);
		ResultSet rs = prestat.executeQuery();
		Truck truck = null;
		if (rs.next()) {
			truck = new Truck(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		rs.close();
		prestat.close();
		return truck;
	}

	@Override
	public void insert(Truck truck) throws SQLException {
		PreparedStatement prestat = conn.prepareStatement("insert into Truck(brand, size, price) values(?,?,?);");
		prestat.setString(1, truck.getBrand());
		prestat.setString(2, truck.getSize());
		prestat.setInt(3, truck.getPrice());
		prestat.executeUpdate();
		prestat.close();

	}

}