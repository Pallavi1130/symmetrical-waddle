package com.um.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.um.model.User;

public class UserDao {
private static String url="jdbc:mysql://localhost:3306/pallavi";
private static String username="root";
private static String password="3011";
private static String insertQuery="insert into user(name,email,city)values(?,?,?)";
private static String displayQuery="select * from user";
private static String deleteQuery="delete from user where id=?";
private static String selectUserById="select * from user where id=?";
private static String updateQuery="update user set name=?, email=?, city=? where id=?"; 

private static Statement st=null ;
private static Connection cn=null;
private static PreparedStatement ps=null;
private static ResultSet rs=null;
//  insert data to database
  public static void insert(User u) {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn=DriverManager.getConnection(url, username, password);
		ps=cn.prepareStatement(insertQuery);
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getCity());
		ps.executeUpdate();
	} catch (ClassNotFoundException | SQLException e) {
	
		e.printStackTrace();
	}
	  finally {
		  try {
			ps.close();
			cn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	  }
  }
// display details
  public static ArrayList<User> display(){
	  ArrayList<User> al=new ArrayList<User>();
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			st=cn.createStatement();
			rs=st.executeQuery(displayQuery);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String city=rs.getString("city");
				User u=new User(id, name, email, city);
				   al.add(u);
			}
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		  finally {
			  try {
				  rs.close();
				st.close();
				cn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		  }
	  
	return al;
  }
//  delete user
  public static void delete(int id) {
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		  finally {
			  try {
				ps.close();
				cn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		  }
  }
  
//  select user by Id
 public static User selectUserById(int id1) {
	 User u=null;
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(selectUserById);
			ps.setInt(1, id1);
			rs=ps.executeQuery();
			rs.next();
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String email=rs.getString("email");
			String city=rs.getString("city");
			u=new User(id, name, email, city);
			
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		  finally {
			  try {
				  rs.close();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		  }
	return u;
 }
public static void updateUser(User u) {
	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url, username, password);
			ps=cn.prepareStatement(updateQuery);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getCity());
			ps.setInt(4, u.getId());
			ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		  finally {
			  try {
				ps.close();
				cn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		  }	
       } 
   }
