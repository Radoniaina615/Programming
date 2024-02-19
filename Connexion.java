package model;

import java.sql.*;

public class Connexion {
	private String url = "jdbc:mysql://127.0.0.1/gestionenseignant_swing";
	private String user = "root";
	private String passwd = "";
	private static Connection c;
	
	private Connexion(){
		try{
			this.c = DriverManager.getConnection(url, user, passwd);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static Connection getInstance(){
		if(c==null){
			new Connexion();
		}
		return c;
	}
}
