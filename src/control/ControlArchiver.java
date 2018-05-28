package control;

import model.BDCommande;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlArchiver {
	
    /**
     * @see model.BDCommande
     */
    private BDCommande bdCommande = BDCommande.getInstance();
    /**
     * @see control.ControlVerifierIdentification
     */
    private ControlVerifierIdentification controlVerifierIdentification;

    /**
     * Constructeur ControlArchiver.
     *
     * @param controlVerifierIdentification Controleur vérifier identification.
     */
    public ControlArchiver(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }
	
    /**
     * Archive les commandes en vidant la base de données.
     *
     * @param numGerant Numéro du gérant à vérifier l'identification.
     */
    public void archiver(int numGerant) {
        boolean identificationOk = controlVerifierIdentification
                                   .verifierIdentification(ProfilUtilisateur.GERANT, numGerant);
        if ( identificationOk ) {
            bdCommande.viderCommandes();
        }
    }

}
