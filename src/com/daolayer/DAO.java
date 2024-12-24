package com.daolayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.pojo.Patient;

public class DAO {
private static final String url="jdbc:mysql://localhost:3307/hospitalmanagement";
private static final String username="root";
private static final String password="root";
public static Connection con=null;
public static PreparedStatement pstmt=null;
public static Connection getDbConnection()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection(url,username,password);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return con;
}
public static void insertPatientD(Patient p)
{
	String SQL="Insert into patient values(?,?,?,?)";
	try {
		
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1,p.getPid());
		pstmt.setString(2,p.getName());
		pstmt.setInt(3,p.getAge());
		pstmt.setString(4,p.getGender());
		pstmt.executeUpdate();
		System.out.println("Data inserted Successfully");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
}
public static boolean checkId(int pid)
{
	String SQL="select *from patient where pid=?";
	boolean status=false;
	try {
		pstmt=getDbConnection().prepareStatement(SQL);
		pstmt.setInt(1, pid);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			status= true;
		}
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	return status;
}
}
