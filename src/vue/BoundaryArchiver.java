package vue;

import control.ControlArchiver;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryArchiver {
	
	/**
	 * @see control.ControlArchiver
	 */
	private ControlArchiver controlArchiver;
	
	/**
	 * Constructeur BoundaryArchiver.
	 *
	 * @param controlArchiver Controleur pour archiver.
	 */
	public BoundaryArchiver(ControlArchiver controlArchiver) {
		this.controlArchiver = controlArchiver;
	}
	
	/**
	 * Archive.
	 *
	 * @param numGerant Numéro du profil du gérant.
	 */
	public void archiver(int numGerant) {
		controlArchiver.archiver(numGerant);
	}
	
}
