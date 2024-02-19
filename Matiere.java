package model;

import java.sql.*;
import java.util.*;

public class Matiere {
	private int idm;
	private String intitule;
	private int vh;
	private int idp;
	private Connection c;
	public Matiere() {
		super();
		this.c = Connexion.getInstance();
	}
	public int getIdm(){
		return idm;
	}
	public String getIntitule(){
		return intitule;
	}
	public int getVh() {
		return vh;
	}
	public int getIdp(){
		return idp;
	}
	public void setIdm(int idm){
		this.idm = idm;
    }
	public void setIntitule(String intitule){
		this.intitule = intitule;
	}
	public void setVh(int vh){
		this.vh = vh;
	}
	public void setIdp(int idp){
		this.idp = idp;
	}
	public boolean create(){
		try{
			PreparedStatement ps = this.c.prepareStatement("INSERT INTO Matiere VALUES(null*, ?, ?, ?);");
			ps.setString(1,this.getIntitule());
			ps.setInt(2, this.getVh());
			ps.setInt(3, this.getIdp());
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<Matiere> read(){
		try{
			PreparedStatement ps =this.c.prepareStatement("SELECT * FROM Matiere");
			ResultSet rs = ps.executeQuery();
			ArrayList<Matiere> liste = new ArrayList<Matiere>();
			while(rs.next()){
				Matiere m = new Matiere();
				m.setIntitule(rs.getString("intitule"));
				m.setVh(rs.getInt("vh"));
				m.setIdp(rs.getInt("idp"));
				liste.add(m);
			}
			return liste;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	public boolean update(){
		try{
			PreparedStatement ps =this.c.prepareStatement("UPDATE Matiere SET intitule = ?,vh = ?,idp = ?,WHERE idm = ?;");
			ps.setString(1,this.getIntitule());
			ps.setInt(2, this.getVh());
			ps.setInt(3, this.getIdp());
			ps.setInt(4, this.getIdm());
			ps.executeUpdate();
			return true;
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean delete(){
		try{
			PreparedStatement ps =this.c.prepareStatement("DELETE FROM Prof WHERE idm = ?;");
			ps.setInt(1,this.getIdm());
			ps.executeUpdate();
			return true;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
			
}
	


