package com.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility implements IConstants {
	static Driver db;
	 static Connection con;
	 static Statement st;

	 /**
	  * connect to database
	  * @throws SQLException
	  */
	public void connectToDataBase() throws SQLException {
		db=new Driver();
	    DriverManager.registerDriver(db);
	    con = DriverManager.getConnection(IConstants.JDBC_url, IConstants.JDBC_username, IConstants.JDBC_password);
	    
	}
	/**
	 * execute DML(Insert,Update, delete), DQL(Select) statements
	 * @param Query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String Query) throws SQLException {
		 st = con.createStatement();
		ResultSet set = st.executeQuery(Query);
		return set;
	}
	/**
	 * execute DDL (Create, Drop, Alter, Truncate) statements 
	 * @param Query
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String Query) throws SQLException {
		st=con.createStatement();
		int result = st.executeUpdate(Query);
		return result;
	}
	
	/**
	 * close DB connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}
	
	/**
	 * reads data in database and validate
	 * @param expdata
	 * @param Query
	 * @param colindex
	 * @throws SQLException
	 */
	
	public void readDataFromDBandValidate(String expdata, String Query, int colindex) throws SQLException {
		boolean flag=false;
		st=con.createStatement();
		ResultSet res = st.executeQuery(Query);
		
		while(res.next()) {
			if(res.getString(colindex).equalsIgnoreCase(expdata)) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("project verified and present in database");
		}
		
		else {
			System.out.println("not verified");
		}
	
	}
}
