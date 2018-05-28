package control;

import model.BDClient;
import model.BDPersonnel;
import model.Client;
import model.Personnel;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlVerifierIdentification {
	
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();
    /**
     * @see model.BDPersonnel
     */
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();
	
    /**
     * Vérifie si l'utilisateur est identifier.
     *
     * @param profilUtilisateur Type de profil utilisateur.
     * @param numProfil Numéro de profil à tester.
     * @return Renvoie vrai si l'utilisateur est connecté, faux sinon.
     */
    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numProfil) {
        boolean connexionOk = false;
        switch ( profilUtilisateur ) {
            case CLIENT:
                Client client = bdClient.selectionnerClient(numProfil);
                if ( client != null ) {
                    connexionOk = client.isConnecte();
                }
                break;
            case PERSONNEL:
                Personnel personnel = bdPersonnel.selectionnerPersonnel(numProfil);
                if ( personnel != null ) {
                    connexionOk = personnel.isConnecte();
                }
                break;
            default:
                Personnel gerant = bdPersonnel.selectionnerPersonnel(numProfil);
                if ( gerant != null ) {
                    boolean identificationOk = gerant.isGerant();
                    if ( identificationOk ) {
                        connexionOk = gerant.isConnecte();
                    }
                }
                break;
        }
        return connexionOk;
    }

}
