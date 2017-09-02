package com.ismayil;

import java.sql.PreparedStatement;

import com.ismayil.database.DatabaseQosulma;

public class RegisterWorker {

	public String RegisterMethod(String name, String email, String password) {
		try {
			String sql = "insert into users (name , email , pass )  values(?,?,?);";
			PreparedStatement ps = DatabaseQosulma.getPreparedStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			int inserted = ps.executeUpdate();
			if (inserted > 0) {
				return name;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "olmadi";
	}
}
