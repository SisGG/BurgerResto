package vue;

import control.ControlCommander;
import control.ControlVerifierIdentification;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryCommander {
	
	/**
	 * @see control.ControlCommander
	 */
    private ControlCommander controlCommander;
    /**
     * @see vue.BoundaryEnregistrerCoordonneesBancaires
     */
    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires;
    /**
     * @see vue.Clavier
     */
    private Clavier clavier = new Clavier();
    
    /**
     * Constructeur BoundaryCommander.
     *
     * @param controlCommander Controleur commander commande.
     * @param boundaryEnregistrerCoordonneesBancaires Boundary enregistrer une carte bancaire.
     */
    public BoundaryCommander(ControlCommander controlCommander, BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires) {
    	this.controlCommander = controlCommander;
    	this.boundaryEnregistrerCoordonneesBancaires = boundaryEnregistrerCoordonneesBancaires;
    }

    /**
     * Commande une nouvelle commande.
     *
     * @param numClient Numéro du client connecté.
     */
    public void commander(int numClient) {
    	boolean clientConnecte = controlCommander
    			.verifierIdentification(numClient);
    	
    	if ( clientConnecte ) {
    		
    		String listeHamburger = controlCommander.getListHamburger();
    		System.out.print("Veuillez sélectionner le numéro de votre hamburger\n" + listeHamburger
    							+ "\nChoix : ");
    		int numeroHamburger = clavier.entrerClavierInt();
    		

    		String listeAccompagnement = controlCommander.getListAccompagnement();
    		System.out.print("Veuillez sélectionner le numéro de votre accompagnement\n" + listeAccompagnement
    							+ "\nChoix : ");
    		int numeroAccompagnement = clavier.entrerClavierInt();
    		

    		String listeBoisson = controlCommander.getListBoisson();
    		System.out.print("Veuillez sélectionner le numéro de votre boisson\n" + listeBoisson
    							+ "\nChoix : ");
    		int numeroBoisson = clavier.entrerClavierInt();
    		
    		boolean carteRenseignee = controlCommander.isCarteRenseignee(numClient);
    		
    		if ( !carteRenseignee ) {
    			carteRenseignee = boundaryEnregistrerCoordonneesBancaires
    					.enregistrerCoordonneesBancaires(numClient);
    			carteRenseignee = true;
    		}
    		
    		if ( carteRenseignee ) {
    			int numeroCommande = controlCommander
    					.enregistrerCommande(numClient, numeroHamburger, numeroAccompagnement, numeroBoisson);
    		    System.out.println("Votre numéro de commande est le " + numeroCommande);
    		}
    	}
    }

}
