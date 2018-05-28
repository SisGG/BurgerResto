package vue;

import control.ControlSIdentifier;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundarySIdentifierPersonnel {
	
	/**
	 * @see control.ControlSIdentifier
	 */
	private ControlSIdentifier controlSIdentifier;
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();
	
	/**
	 * Constructeur BoundarySIdentifierPersonnel.
	 *
	 * @param controlSIdentifier Controleur pour s'identifier.
	 */
	public BoundarySIdentifierPersonnel(ControlSIdentifier controlSIdentifier) {
		this.controlSIdentifier = controlSIdentifier;
	}
	
	/**
	 * Identifie un personnel.
	 *
	 * @return Renvoie le nuémro du personnel connecté, -1 sinon.
	 */
	public int identifierPersonnel() {
		System.out.print("Veuillez entrer votre login : ");
		String login = clavier.entrerClavierString();
		
		System.out.print("Veuillez entrer votre mot de passe : ");
		String mdp = clavier.entrerClavierString();
		return controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL, login, mdp);
	}

}
