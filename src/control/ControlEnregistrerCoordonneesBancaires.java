package control;

import model.BDClient;
import model.Client;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlEnregistrerCoordonneesBancaires {

    /**
     * @see control.ControlVerifierCoordonneesBancaires
     */
    private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();

    /**
     * Constructeur ControlEnregistrerCoordonneesBancaires.
     *
     * @param controlVerifierCoordonneesBancaires Controleur vérification validité des vérifications.
     */
    public ControlEnregistrerCoordonneesBancaires(ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
    }
	
    /**
     * Enregistre une carte nouvelle carte bancaire pour un client.
     *
     * @param numClient Numéro du client où la carte sera enregistrer.
     * @param numeroCarte Numéro de carte bancaire.
     * @param dateExpCarte Date d'expiration de la carte bancaire.
     * @return Vrai si la carte renseignée est valide, faux sinon.
     */
    public boolean enregistrerCoordonneesBancaires(int numClient, int numeroCarte, int dateExpCarte) {
        boolean carteValide = controlVerifierCoordonneesBancaires
				.verifierCoordonneesBancaires(numeroCarte, dateExpCarte);
        if ( carteValide ) {
            Client client = bdClient.selectionnerClient(numClient);
            client.enregistrerCoordonneesBancaires(numeroCarte, dateExpCarte);
        }
        return carteValide;
    }

}
