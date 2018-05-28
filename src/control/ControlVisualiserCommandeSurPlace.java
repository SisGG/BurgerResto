package control;

import java.util.Observer;

import model.BDClient;
import model.BDCommande;
import model.Client;
import model.Commande;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlVisualiserCommandeSurPlace {
	
    /**
     * @see control.ControlVerifierIdentification
     */
    private ControlVerifierIdentification controlVerifierIdentification;
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();
    /**
     * @see model.BDCommande
     */
    private BDCommande bdCommande = BDCommande.getInstance();
	
    /**
     * Constructeur ControlVisualiserCommandeSurPlace.
     *
     * @param controlVerifierIdentification Controleur vérification identification.
     */
    public ControlVisualiserCommandeSurPlace(ControlVerifierIdentification controlVerifierIdentification) {
	    this.controlVerifierIdentification = controlVerifierIdentification;
	}
	
    /**
     * Vérifie si l'utilisateur est connecté.
     *
     * @param numClient Numéro du client à vérifié.
     * @return Vrai si l'utilisateur est connecté, faux sinon.
     */
    public boolean verifierIdentification(int numClient) {
        boolean identificationOk = controlVerifierIdentification
    			.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
        return identificationOk;
    }
	
    /**
     * Définit un nouvel observer.
     */
    public void setObserver(Observer observeur) {
        bdCommande.addObserver(observeur);
    }

}
