package com.commerce.gestion.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.commerce.gestion.utils.DBConnection;
import  com.commerce.gestion.dao.entity.Users;
public class LoginDao {
public String authenticateUser(Users user)
{
String username = user.getUsername();
String password = user.getPassword();
Connection con = null;
Statement statement = null;
ResultSet resultSet = null;
String userNameDB = "";
String passwordDB = "";
String roleDB = "";
try
{
con = DBConnection.createConnection();
statement = con.createStatement();
resultSet = statement.executeQuery("select username,password,role from users");
while(resultSet.next())
{
userNameDB = resultSet.getString("username");
passwordDB = resultSet.getString("password");
roleDB = resultSet.getString("role");
if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
return "Admin_Role";
else if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
return "Editor_Role";
else if(username.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
return "User_Role";
}
}
catch(SQLException e)
{
e.printStackTrace();
}
return "Invalid user credentials";
}
}