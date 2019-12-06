package org.perscholas.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class StudentDAO {
	
	 public static void main(String[] args) {
	        /*
	         * StudentDAO s_dao=new StudentDAO(); s_dao.testConn();
	         */
	        MariadbConnection MariadbConnection = new MariadbConnection();
	        try {
	            // Test connection to mariaDB
	            Connection cn = MariadbConnection.getConnection();
	            System.out.println("connected to mariadb:)");
	            // create the java statement
	            Statement smt = (Statement) cn.createStatement();
	            String q = "Select * from students";
	            // to execute query
	            ResultSet rs = ((java.sql.Statement) smt).executeQuery(q);
	            // to print the resultset on console
	            if (rs.next()) {
	                do {
	                    System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + ","
	                            + rs.getString(4) + "," + rs.getString(5));
	                } while (rs.next());
	            } else {
	                System.out.println("Record Not Found...");
	            }
	            cn.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	}


