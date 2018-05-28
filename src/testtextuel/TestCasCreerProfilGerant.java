package testtextuel;

import control.ControlCreerProfil;
import vue.BoundaryCreerProfilGerant;

public class TestCasCreerProfilGerant {

	public static void main(String[] args) {
		// Initialisation controleur du cas
		ControlCreerProfil controlCreerProfil = new ControlCreerProfil();
		
		// Initialisation vue du cas
		BoundaryCreerProfilGerant boundaryCreerProfilGerant = new BoundaryCreerProfilGerant(controlCreerProfil);

		// Lancement du cas
		boundaryCreerProfilGerant.creerProfilGerant();

		// Verification de la bonne realisation du cas
		System.out.println("VERIFICATION");
		System.out.println(controlCreerProfil.visualiserBDUtilisateur());

		// Resultat du test
		// Veuillez entrer votre nom
		// Martin
		// Veuillez entrer votre prenom
		// Victor
		// Veuillez entrer votre mot de passe
		// gmv
		// VERIFICATION
		// BDPersonnel [listePersonnel={}]
		// BDClient [listeClient={0=Client [nom=Martin, prenom=Victor, login=Victor.Martin, mdp=gmv, connecte=false]}]
		
		// Martin Victor gmv
		// erreur dans les commentaires plus haut !
	}
}
