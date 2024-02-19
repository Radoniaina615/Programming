package model;

import java.sql.*;
import java.util.*;

public class Prof {
	private int idp;
	private String nom;
	private int age;
	private String specialite;
	private String ville;
	private Connection c;
	public Prof(){
		super();
		this.c = Connexion.getInstance();
	}
	public int getIdp(){
		return idp;
	}
	public String getNom(){
		return nom;
	}
	public int getAge(){
		return age;
	}
	public String getSpecialite(){
		return specialite;
	}
	public String getVille(){
		return ville;
	}
	public void setIdp(int idp){
		this.idp = idp;
	}
	public void setNom(String nom){
		this.nom = nom;
	}
	public void setAge(int age){
		this.age = age;
	}
	public void setSpecialite(String specialite){
		this.specialite = specialite;
	}
	public void setVille(String ville){
		this.ville = ville;
	}
	public boolean create(){
		try{
			PreparedStatement ps = this.c.prepareStatement("INSERT INTO Prof VALUE(null, ?, ?, ?,?);");
			ps.setString(1,  this.getNom());
			ps.setInt(2, this.getAge());
			ps.setString(3, this.getSpecialite());
			ps.setString(4, this.getVille());
			ps.executeUpdate();
			return true;
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Prof> read(){
		try {
			PreparedStatement ps = this.c.prepareStatement("SELECT * FROM Prof");
			ResultSet rs = ps.executeQuery();
			ArrayList<Prof> liste = new ArrayList<Prof>();
			while(rs.next()){
				Prof p = new Prof();
				p.setIdp(rs.getInt("idp"));
				p.setNom(rs.getString("nom"));
				p.setAge(rs.getInt("age"));
				p.setSpecialite(rs.getString("specialite"));
				p.setVille(rs.getString("ville"));
				liste.add(p);
			}
			return liste;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	public boolean update(){
		try {
			PreparedStatement ps = this.c.prepareStatement("UPDATE Prof SET nom= ?, age=?, specialite=?, ville=? WHERE idp=?;");
			ps.setString(1,  this.getNom());
			ps.setInt(2, this.getAge());
			ps.setString(3, this.getSpecialite());
			ps.setString(4, this.getVille());
			ps.setInt(5,  this.getIdp());
			ps.executeUpdate();
			return true;
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(){
		try{
			PreparedStatement ps = this.c.prepareStatement("DELETE FROM Prof WHERE idp=?;");
			ps.setInt(1,  this.getIdp());
			ps.executeUpdate();
			return true;
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
}