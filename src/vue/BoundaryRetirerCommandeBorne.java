package vue;

import control.ControlRetirerCommandeBorne;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryRetirerCommandeBorne {
	
	/**
	 * @see control.ControlRetirerCommandeBorne
	 */
	private ControlRetirerCommandeBorne controlRetirerCommandeBorne;
	
	/**
	 * @ee vue.Clavier
	 */
	private Clavier clavier;
	
	/**
	 * Controleur BoundaryRetirerCommandeBorne.
	 *
	 * @param controlRetirerCommandeBorne Controleur pour retirer une commande à la borne.
	 */
	public BoundaryRetirerCommandeBorne(ControlRetirerCommandeBorne controlRetirerCommandeBorne) {
		this.controlRetirerCommandeBorne = controlRetirerCommandeBorne;
		this.clavier = new Clavier();
	}
	
	/**
	 * Retire une commande à la borne.
	 */
	public void retirerCommandeBorne() {
    	System.out.print("Veuillez entrer le numéro de commande : ");
    	int numeroCommande = clavier.entrerClavierInt();
    	boolean commandeTrouvee = controlRetirerCommandeBorne.retirerCommandeBorne(numeroCommande);
    	if ( commandeTrouvee ) {
    		System.out.println("Vous pouvez récupérer votre commande au comptoir.");
    	} else {
    		System.out.println("Numéro de commande inexistant.");
    	}
	}
}
