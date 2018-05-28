package vueGraphique;

import java.awt.Color;
import javax.swing.JPanel;
import control.ControlEnregistrerCoordonneesBancaires;

public class PanEnregistrerCoordonneesBancaires extends JPanel {

	private static final long serialVersionUID = 1L;
	private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	
	public PanEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
	}
	
	public void initialisation() {
		this.setBackground(Color.YELLOW);
	}


}
