package tw.suzume.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.suzume.util.Printer;

public class TestJDBCConnEx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Printer out;
	private Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}
	
	private void createConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlStr = "jdbc:sqlserver://localhost:1433;databaseName=SuzuPower;user=watcher;password=P@ssw0rd;"
				+ " encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlStr);
	}
	
	private void createConn2() throws NamingException, SQLException{
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/connectSqlServer/OrderService");
		conn = ds.getConnection();
		
	}

	private void closeConn() throws SQLException {
		if (conn!=null) {
			conn.close();
			out.write("conn status:"+"conn is Closed"+"<br/>");
		}
		
	}
	
	private void queryInfo() throws SQLException {
		Statement stat = conn.createStatement();
		String qString = "SELECT * FROM Truck";
		ResultSet rs = stat.executeQuery(qString);
		while (rs.next()) {
			out.write(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+"<br/>");
		}
		rs.close();
		stat.close();
	}
	
	private void insert() throws SQLException {
		Statement stat = conn.createStatement();
		String qString = "insert into Truck(brand, size, price) values('subaru','L',140);";
		out.write("Insert "+stat.executeUpdate(qString)+"row Successfully!");
		stat.close();
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			createConn2();
			out = new Printer(response);
			out.write("conn status:"+!conn.isClosed()+"<br/>");
			queryInfo();
			out.write("<hr/>");
			insert();
			queryInfo();
			out.write("<hr/>");
			
			closeConn();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
