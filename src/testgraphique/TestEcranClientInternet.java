package testgraphique;

import control.ControlAjouterAlimentMenu;
import control.ControlCommander;
import control.ControlCreerProfil;
import control.ControlEnregistrerCoordonneesBancaires;
import control.ControlSIdentifier;
import control.ControlVerifierCoordonneesBancaires;
import control.ControlVerifierIdentification;
import model.ProfilUtilisateur;
import vuegraphique.FrameClientInternet;

public class TestEcranClientInternet {

	public static void main(String[] args) {
		// initialisation pour test commander
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		ControlVerifierIdentification controlVerifierIdentification = new ControlVerifierIdentification();
		ControlAjouterAlimentMenu controlAjouterAlimentCarte = new ControlAjouterAlimentMenu(controlVerifierIdentification);
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();

		// senario pour le test
		controlAjouterAlimentCarte.ajouterHamburger("baconBurger");
		controlAjouterAlimentCarte.ajouterHamburger("chickenBurger");
		controlAjouterAlimentCarte.ajouterHamburger("cheeseBurger");
		controlAjouterAlimentCarte.ajouterAccompagnement("frites");
		controlAjouterAlimentCarte.ajouterAccompagnement("pommesChips");
		controlAjouterAlimentCarte.ajouterBoisson("coca");
		controlAjouterAlimentCarte.ajouterBoisson("orangeBubbles");

		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond",
				"Hector", "cdh");
		int numClient = controlSIdentifier.sIdentifier(
				ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");

		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Durand",
				"Jacques", "cdj");
		int numClient2 = controlSIdentifier.sIdentifier(
				ProfilUtilisateur.CLIENT, "Jacques.Durand", "cdj");

		// cas commander
		ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires = new ControlVerifierCoordonneesBancaires();
		ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires = new ControlEnregistrerCoordonneesBancaires(controlVerifierCoordonneesBancaires);
		ControlCommander controlCommande = new ControlCommander(controlVerifierIdentification);
		new FrameClientInternet(numClient, controlCommande,
				controlEnregistrerCoordonneesBancaires);
		new FrameClientInternet(numClient2, controlCommande,
				controlEnregistrerCoordonneesBancaires);
	}
}
