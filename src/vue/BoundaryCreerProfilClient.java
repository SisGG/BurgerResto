package vue;

import control.ControlCreerProfil;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryCreerProfilClient {

	/**
	 * @see control.ControlCreerProfil
	 */
	private ControlCreerProfil controlCreerProfil;
	
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();

	/**
	 * Constructeur BoundaryCreerProfilClient.
	 *
	 * @param controlCreerProfil Controleur créer un profil
	 */
	public BoundaryCreerProfilClient(ControlCreerProfil controlCreerProfil) {
		this.controlCreerProfil = controlCreerProfil;
	}

	/**
	 * Crée un nouveau profil client.
	 */
	public void creerProfilClient() {
		String nom, prenom, mdp;
		System.out.print("Veuillez entrer votre nom : ");
		nom = clavier.entrerClavierString();
		System.out.print("Veuillez entrer votre prénom : ");
		prenom = clavier.entrerClavierString();
		System.out.print("Veuillez entrer votre mot de passe :");
		mdp = clavier.entrerClavierString();
		controlCreerProfil.creerProfil(ProfilUtilisateur.CLIENT, nom, prenom, mdp);
	}
	
}
