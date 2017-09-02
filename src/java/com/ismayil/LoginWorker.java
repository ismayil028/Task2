package com.ismayil;

import java.sql.ResultSet;
import java.sql.Statement;

import com.ismayil.database.DatabaseQosulma;

public class LoginWorker {
public boolean LoginYoxla(String username,String password) {
	boolean yoxla=false;
	try{Statement stmt = DatabaseQosulma.getStatement();
	String query = "select * from users where email='"+username+ "' and pass='"
	+ password +"' ;";
	ResultSet resultSet = stmt.executeQuery(query);
	while (resultSet.next()) {
		yoxla=true;
	}
	}catch (Exception e) {
		// TODO: handle exception
	}
	return yoxla;
}
}
