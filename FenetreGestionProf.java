package view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
public class FenetreGestionProf extends JFrame{
	private JTabbedPane tp;
	private PanneauProf pf;
	private PanneauMatiere pm;
	public FenetreGestionProf() {
		this.setTitle("Exemple");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 700);
		this.setLocationRelativeTo(null);
		this.tp = new JTabbedPane();
		this.pf = new PanneauProf();
		this.pm = new PanneauMatiere();
		this.tp.add(this.pf, "Profs");
		this.tp.add(this.pm, "Matieres");
		this.getContentPane().add(this.tp);
		this.setVisible(true);
	}
}
