package vue;

import control.ControlEnregistrerCoordonneesBancaires;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryEnregistrerCoordonneesBancaires {

	/**
	 * @see control.ControlEnregistrerCoordonneesBancaires
	 */
	private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	/**
	 * @see vue.Clavier
	 */
	private Clavier clavier = new Clavier();
	
	/**
	 * Constructeur BoundaryEnregistrerCoordoneesBancaires.
	 *
	 * @param controlEnregistrerCoordonneesBancaires Controleur enregistrer coordonées bancaires.
	 */
	public BoundaryEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
	}
	
	/**
	 * Enregistre une nouvel carte bancaire pour un client.
	 *
	 * @param numClient Numéro de client.
	 * @return Vrai si la carte a été enregistrer, faux sinon.
	 */
    public boolean enregistrerCoordonneesBancaires(int numClient) {
    	System.out.print("Veuillez saisir votre numero de carte bancaire : ");
    	int numeroCarte = clavier.entrerClavierInt();
    	
    	System.out.print("Veuillez saisir la date d'expiration de votre carte bancaire : ");
    	int dateExpCarte = clavier.entrerClavierInt();
    	
    	boolean carteValide = controlEnregistrerCoordonneesBancaires
    			.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateExpCarte);
    	if ( !carteValide ) {
    		System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir.");
    	}
    	return carteValide;
    }

}
