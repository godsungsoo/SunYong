package common;

import java.util.Properties;

import burger.exception.BurgerException;

import java.sql.*;
import java.io.*;

public class JDBCTemplete {

	public Connection getConnection() throws BurgerException{
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("properties/driver.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("id"), prop.getProperty("pwd"));
			conn.setAutoCommit(false);
			
		} catch (Exception e) {
			throw new BurgerException(e.getMessage());
		}
		return conn;
	}
	
	public void commit(Connection conn) throws BurgerException{
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			throw new BurgerException(e.getMessage());
		}
	}
	
	public void rollback(Connection conn) throws BurgerException{
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			throw new BurgerException(e.getMessage());
		}
	}
	
	public void close(Connection conn) throws BurgerException{
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new BurgerException(e.getMessage());
		}
	}
	
	public void close(Statement stmt) throws BurgerException{
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new BurgerException(e.getMessage());
		}
	}
	
	public void close(ResultSet rset) throws BurgerException{
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			throw new BurgerException(e.getMessage());
		}
	}
	
}
