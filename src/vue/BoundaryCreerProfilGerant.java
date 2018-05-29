package vue;

import control.ControlCreerProfil;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryCreerProfilGerant {

	/**
	 * @see control.ControlCreerProfil
	 */
	private ControlCreerProfil controlCreerProfil;
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();
	
	/**
	 * Constructeur BoundaryCreerProfilGerant.
	 *
	 * @param controlCreerProfil Controleur création profil.
	 */
	public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil) {
		this.controlCreerProfil = controlCreerProfil;
	}
	
	/**
	 * Créer un nouveau profil gérant.
	 */
	public void creerProfilGerant() {
		String nom, prenom, mdp;
		System.out.print("Veuillez entrer votre nom : ");
		nom = clavier.entrerClavierString();
		System.out.print("Veuillez entrer votre prénom : ");
		prenom = clavier.entrerClavierString();
		System.out.print("Veuillez entrer votre mot de passe :");
		mdp = clavier.entrerClavierString();
		controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT, nom, prenom, mdp);
	}
	
}
