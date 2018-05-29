package testgraphique;

import javax.swing.JFrame;

import control.ControlEnregistrerCoordonneesBancaires;
import control.ControlVerifierCoordonneesBancaires;
import vuegraphique.IUseEnregistrerCoordonneesBancaires;
import vuegraphique.PanEnregistrerCoordonneesBancaires;

public class TestEnregistrerCoordonneeBancaire {

	public static void main(String[] args) {
		ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
		ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(
				controlVerifierCoordonneesBancaires);
		// JFrame test = new JFrame();
		// test.add(panTest);
		// test.isVisible();
		// panTest.isVisible();
		// panTest.enregistrerCoordonneesBancaires(1);
		JFrame fenetre = new JFrame();
		fenetre.setVisible(true);
		fenetre.setSize(800,400);

		 PanEnregistrerCoordonneesBancaires panTest = new
		 PanEnregistrerCoordonneesBancaires(controlEnregistrerCoordonneesBancaires);
		 fenetre.setContentPane(panTest);
		 panTest.initialisation();
		 //Cette ligne passe ne passe plus a la compilation dans la partie 16.
		 //panTest.enregistrerCoordonneesBancaires(1);
		 panTest.setVisible(true);
		 fenetre.repaint();
	}

}
