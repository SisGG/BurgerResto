package vue;

import control.ControlCreerProfil;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryCreerProfilPersonnel {

	/**
	 * @see control.ControlCreerProfil
	 */
	private ControlCreerProfil controlCreerProfil;
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();
	
	/**
	 * Constructeur BoundaryCreerProfilPersonnel.
	 *
	 * @param controlCreerProfil Controleur création profil.
	 */
	public BoundaryCreerProfilPersonnel(ControlCreerProfil controlCreerProfil) {
		this.controlCreerProfil = controlCreerProfil;
	}
	
	/**
	 * Créé un nouveau profil personnel.
	 */
	public void creerProfilPersonnel() {
		String nom, prenom;
		System.out.print("Veuillez entrer le nom du nouvel employe : ");
		nom = clavier.entrerClavierString();
		System.out.print("Veuillez entrer le prénom du nouvel employe : ");
		prenom = clavier.entrerClavierString();
		System.out.print("Le mot de passe est : mdp, à modifier à la première connexion.");
		controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT, nom, prenom, "mdp");
	}
	
}
