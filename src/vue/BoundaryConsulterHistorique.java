package vue;

import control.ControlConsulterHistorique;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryConsulterHistorique {
	
	/**
	 * @see control.ControlConsulterHistorique
	 */
	private ControlConsulterHistorique controlConsulterHistorique;
	
	/**
	 * Constructeur BoundaryConsulterHistorique.
	 *
	 * @param controlConsulterHistorique Controleur consulter son historique.
	 */
	public BoundaryConsulterHistorique(ControlConsulterHistorique controlConsulterHistorique) {
		this.controlConsulterHistorique = controlConsulterHistorique;
	}
	
	/**
	 * Consulter son historique.
	 *
	 * @param numClient Numéro du client.
	 */
	public void consulterHistorique(int numProfil) {
		boolean identificationOk = controlConsulterHistorique
				.verifierIdentification(numProfil);
		
		if ( identificationOk ) {
			System.out.println("Historique du client n°" + (numProfil+1) + " : ");
			String commandes = controlConsulterHistorique.consulterHistorique(numProfil);
			System.out.println(commandes);
		}
	}

}
