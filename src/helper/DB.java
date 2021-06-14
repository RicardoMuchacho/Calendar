package helper;

import java.sql.*;
import helper.User;

public class DB {
	private static DB DB = new DB();
	private Statement stmt;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "Calendar";
	private String urlDB = "jdbc:postgresql://localhost:5433/" + this.dbName; 
	private String userDB = "postgres";
	private String passDB = "admin";
	public String result;
	
	private DB(){
		try {
		Class.forName(driverDB);
		this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
		System.out.println("Conexion establecida");
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		} 
	public static DB getInstances() {
		return DB;
		} 
	
	public ResultSet dbStatement(String query) {
		try {
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(query);
		while(rs.next()) {
		System.out.println(rs.getString("userid"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("password"));
		System.out.println(rs.getString("age"));
		System.out.print("\n");
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
		try {
		this.stmt.close();
		this.rs.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return rs;
	}
	
	public void dbPrepareStatement(String query, Object[] obj) {
		try {
		this.pstmt = this.conn.prepareStatement(query);
		this.pstmt.setString(1, (String) obj[0]);
		this.pstmt.setString(2, (String) obj[1]);
		this.pstmt.setInt(3, (int) obj[2]);
		this.pstmt.setString(4, (String) obj[3]);
		this.pstmt.setBoolean(5, (Boolean) obj[4]);
		this.pstmt.setString(6, (String) obj[5]);
		this.pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		} 
	
	public void registerUser(User user) {
		try {
		this.pstmt = this.conn.prepareStatement("INSERT INTO users(name, password, email) VALUES(?, ?, ?)");
		this.pstmt.setString(1, user.getName());
		this.pstmt.setString(2, user.getPassword() );
		this.pstmt.setString(3, user.getEmail());
		
		this.pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		} 
	
	public String updateUser(User user) {
		try {
		this.pstmt = this.conn.prepareStatement("update users set name = ?, email= ?, password=? where user_id =?");
		this.pstmt.setString(1, user.getName());
		this.pstmt.setString(2, user.getEmail());
		this.pstmt.setString(3, user.getPassword() );
		this.pstmt.setInt(4, user.getUserid() );
		
		this.pstmt.executeUpdate();
		} catch (SQLException e) {

		e.printStackTrace();
		return "Error";
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		return "Successful";
		} 
	
	public void createCalendar(int userid, String title) {
		try {
		this.pstmt = this.conn.prepareStatement("INSERT INTO calendars(user_id, name) VALUES(?,?)");
		this.pstmt.setInt(1, userid);
		this.pstmt.setString(2, title);
		
		this.pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		} 
	
	public void dbClose() {
		try {
		this.conn.close();
		System.out.println("Conexion cerrada");
		} catch (SQLException e) {
		e.printStackTrace();
		} 
	}

public User loginData(String name, String password) {
	User loggedUser = new User();
	try {
	this.stmt = this.conn.createStatement();
	this.rs = this.stmt.executeQuery("select *from users where name ="+"'"+name+"'"+" and password ="+"'"+password+"'");
	while(rs.next()) {

	loggedUser.setName(rs.getString("name"));
	loggedUser.setPassword(rs.getString("password"));
	loggedUser.setEmail(rs.getString("email"));
	loggedUser.setUserid(rs.getInt("user_id"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("user not found");
	}finally {
	try {
	this.stmt.close();
	this.rs.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return loggedUser;
}


 public User loggedData(String name) {
	User loggedUser = new User();
	try {
	this.stmt = this.conn.createStatement();
	this.rs = this.stmt.executeQuery("select *from users where name ="+"'"+name+"'");
	while(rs.next()) {

    loggedUser.setUserid(rs.getInt("user_id"));
	loggedUser.setName(rs.getString("name"));
	loggedUser.setPassword(rs.getString("password"));
	loggedUser.setEmail(rs.getString("email"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("user not found");
	}finally {
	try {
	this.stmt.close();
	this.rs.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return loggedUser;
 }
}
//register query
//INSERT INTO users(name, password, email) VALUES('Orange', 'erg', 'ferf');

//login query
//select password, name from users where name = 'h' and password = 'h'

//edit user query
//update users set name = 'rick', email='hh' where user_id = 3