package com.perscholas.maria.dao;

import java.sql.Connection;

public class TestDB {
public static void main(String a[]) throws Exception {
	MariadbConnection db = new MariadbConnection();
			Connection con = db.getConnection();
			System.out.println(con);
}
}
