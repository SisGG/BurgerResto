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

public class TestEcranClient {
	
	/*
	 * Fonction main
	 * Cree la fenetre
	 */
	public static void main(String[] args) {

		// Mise en place de l'environnement
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		ControlSIdentifier controlSIdentifier = new ControlSIdentifier();
		ControlAjouterAlimentMenu controlAjouterAlimentCarte = new ControlAjouterAlimentMenu(new ControlVerifierIdentification());

		controlAjouterAlimentCarte.ajouterHamburger("baconBurger");
		controlAjouterAlimentCarte.ajouterHamburger("chickenBurger");
		controlAjouterAlimentCarte.ajouterHamburger("cheeseBurger");
		controlAjouterAlimentCarte.ajouterAccompagnement("frites");
		controlAjouterAlimentCarte.ajouterAccompagnement("pommesChips");
		controlAjouterAlimentCarte.ajouterBoisson("coca");
		controlAjouterAlimentCarte.ajouterBoisson("orangeBubbles");
		
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, "Dupond", "Hector", "cdh");
		int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, "Hector.Dupond", "cdh");
		
		if ( numClient != -1 ) {
			new FrameClientInternet(numClient,
					new ControlCommander(new ControlVerifierIdentification()),
					new ControlEnregistrerCoordonneesBancaires(new ControlVerifierCoordonneesBancaires()));
		}
	}
	
}
