package vue;

import control.ControlSIdentifier;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundarySIdentifierClient {
	
	/**
	 * @see control.ControlSIdentifier
	 */
	private ControlSIdentifier controlSIdentifier;
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();
	
	/**
	 * Constructeur BoundarySIdentifierClient.
	 *
	 * @param controlSIdentifier Controleur pour s'identifier.
	 */
	public BoundarySIdentifierClient(ControlSIdentifier controlSIdentifier) {
		this.controlSIdentifier = controlSIdentifier;
	}
	
	/**
	 * Identifie un client.
	 *
	 * @return Renvoie le numéro du client connecté, -1 sinon.
	 */
	public int sIdentifierClient() {
		System.out.print("Veuillez entrer votre login : ");
		String login = clavier.entrerClavierString();
		
		System.out.print("Veuillez entrer votre mot de passe : ");
		String mdp = clavier.entrerClavierString();
		return controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, login, mdp);
	}

}
