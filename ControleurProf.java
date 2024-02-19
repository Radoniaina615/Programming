package controleur;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import view.TableauModele;
import model.Prof;

public class ControleurProf implements ActionListener{
	private JTextField tfNom, tfAge, tfSpecialite, tfVille;
	private JTable tProfs;
	private int id;
	public ControleurProf(int id, JTextField tfNom, JTextField tfAge, JTextField tfSpecialite, JTextField tfVille, JTable tProfs){
		this.id = id;
		this.tfNom = tfNom;
		this.tfAge = tfAge;
		this.tfSpecialite = tfSpecialite;
		this.tfVille = tfVille;
		this.tProfs = tProfs;
	}
	public void actionPerformed(ActionEvent e){
		Prof p = new Prof();
		JOptionPane boite = new JOptionPane();
		switch(this.id){
		case 1:
			try{
				String nom =this.tfNom.getText();
				int age = Integer.parseInt(this.tfAge.getText());
				String specialite = this.tfSpecialite.getText();
				String ville =this.tfVille.getText();
				p.setNom(nom);
				p.setAge(age);
				p.setSpecialite(specialite);
				p.setVille(ville);
				p.create();
				boite.showMessageDialog(null, "Tafiditra tsara", "Milamina", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception f){
					boite.showMessageDialog(null, "Misy olana be", "Loza!!", JOptionPane.ERROR_MESSAGE);
				}
			this.tfNom.setText("");
			this.tfAge.setText("");
			this.tfSpecialite.setText("");
			this.tfVille.setText("");
			ArrayList<Prof> liste = p.read();
			String[] entete =  {"Nom", "Age", "Specialite", "Ville" };
			String[][] donnees = new String[liste.size()][entete.length];
			for(int i=0 ; i < liste.size() ; i++){
				donnees[i][0]= liste.get(i).getNom();
				donnees[i][1]= "" + liste.get(i).getAge();
				donnees[i][2]= liste.get(i).getSpecialite();
				donnees[i][3]= liste.get(i).getVille();}
			TableauModele ptm = new TableauModele(donnees, entete);
			this.tProfs.setModel(ptm);
			break;
		}
			
	}
}
