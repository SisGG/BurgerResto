package vueGraphique;

import java.awt.Color;
import javax.swing.JPanel;

import control.ControlCommander;

public class PanCommander extends JPanel {

	private static final long serialVersionUID = 1L;
	private ControlCommander controlCommander;
	private PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires;
	
	/**
	 * Constructeur PanCommander.
	 * 
	 * @param controlCommander Control commander commande.
	 * @param panEnregistrerCoordonneesBancaires Panel enregistrerCoordonneesBancaires.
	 */
	public PanCommander(ControlCommander controlCommander, PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires) {
		this.controlCommander = controlCommander;
		this.panEnregistrerCoordonneesBancaires = panEnregistrerCoordonneesBancaires;
	}
	
	/**
	 * Initialise le panel.
	 */
	public void initialisation() {
		this.setBackground(Color.YELLOW);
	}
}
