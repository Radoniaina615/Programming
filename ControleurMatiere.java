package controleur;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import view.TableauModele;
import model.Matiere;


public class ControleurMatiere implements ActionListener{
	private JTextField tfIntitule, tfVh;
	private JComboBox<String> cbIdp;
	private JTable tMatieres;
	private int id;
	public ControleurMatiere(int id, JTextField tfIntitule, JTextField tfVh, JComboBox cbIdp, JTable tMatieres){
		this.id = id;
		this.tfIntitule = tfIntitule;
		this.tfVh = tfVh;
		this.tMatieres = tMatieres;
		this.cbIdp = cbIdp;
		 
	}
	public void actionPerformed(ActionEvent e){
		Matiere m = new Matiere();
		JOptionPane boite = new JOptionPane();
		switch(this.id){
		case 1:
			try{
				String intitule =this.tfIntitule.getText();
				int vh = Integer.parseInt(this.tfVh.getText());
				String sIdp = this.cbIdp.getSelectedItem().toString();
				String ssIdp = "";
				int i= 0;
				while(sIdp.charAt(i)!=' '){
					ssIdp += sIdp.charAt(i);
					i++;
				}
				
				int idp = Integer.parseInt(ssIdp);
				m.setIntitule(intitule);
				m.setVh(vh);
				m.setIdp(idp);
				m.create();
				boite.showMessageDialog(null, "Tafiditra tsara", "Milamina", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception f){
					boite.showMessageDialog(null, "Misy olana be", "Loza!!", JOptionPane.ERROR_MESSAGE);
				}
			this.tfIntitule.setText("");
			this.tfVh.setText("");
			ArrayList<Matiere> liste = m.read();
			String[] entete =  {"Intitule", "Vh", "Idp" };
			String[][] donnees = new String[liste.size()][entete.length];
			for(int i=0 ; i < liste.size() ; i++){
				donnees[i][0]= liste.get(i).getIntitule();
				donnees[i][1]= "" + liste.get(i).getVh();
				donnees[i][2]= "" + liste.get(i).getIdp();
			}
			TableauModele tm = new TableauModele(donnees, entete);
			this.tMatieres.setModel(tm);
			break;
		}
			
	}
}
