package control;

import java.util.Observer;

import model.BDCommande;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
@SuppressWarnings("deprecation")
public class ControlVisualiserCommandeJour {

    /**
     * @see control.ControlVerifierIdentification
     */
    private ControlVerifierIdentification controlVerifierIdentification;
    /**
     * @see model.BDCommande
     */
    private BDCommande bdCommande = BDCommande.getInstance();
	
    /**
     * Constructeur ControlVisualiserCommande.
     *
     * @param controlVerifierIdentification Controleur vérifier identification.
     */
    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }
    
    /**
     * Vérifie si l'utilisateur est connecté.
     *
     * @param numProfil Numéro de profil utilisateur à vérifier.
     * @return Vrai si l'utilisateur est connecté, faux sinon.
     */
    public boolean verifierIdentification(int numProfil) {
        boolean identificationOk = controlVerifierIdentification
    			.verifierIdentification(ProfilUtilisateur.PERSONNEL, numProfil);
        return identificationOk;
    }
	
    /**
     * Définit un nouvel observer.
     *
     * @param observer : A observer
     */
    public void setObserver(Observer observer) {
        bdCommande.addObserver(observer);
    }

}
