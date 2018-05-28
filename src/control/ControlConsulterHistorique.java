package control;

import java.util.List;

import model.BDClient;
import model.Client;
import model.Commande;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlConsulterHistorique {
	
    /**
     * @see control.ControlVerifierIdentification
     */
    private ControlVerifierIdentification controlVerifierIdentification;
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();
	
    /**
     * Constructeur ControlConsulterHistorique.
     *
     * @param controlVerifierIdentification Controleur vérification identité.
     */
    public ControlConsulterHistorique(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }
	
    /**
     * Vérifie si un client est connecté ou non.
     *
     * @param numClient Numéro de client à vérifier.
     * @return Vrai si le client est connecté, faux sinon.
     */
    public boolean verifierIdentification(int numClient) {
        boolean identificationOk = controlVerifierIdentification
    			.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
        return identificationOk;
    }
	
    /**
     * Renvoie la liste des commandes d'un client.
     *
     * @param numClient Numéro du client à consulter.
     * @return La chaine de caractère comportant son l'historique des commandes.
     */
    public String consulterHistorique(int numClient) {
        Client client = bdClient.selectionnerClient(numClient);
        List<Commande> listCommande = client.getHistoriqueCommandes();
        String message = "";
        for( Commande commande : listCommande) {
            message += "Commande n°" + commande.getNumeroCommandeAttribuee() + " : "
                    + commande.getHamburger().getNom() + ", "
                    + commande.getAccompagnement().getNom() + ", "
                    + commande.getBoisson().getNom()
                    + ".\n";
        }
        return message;
    }

}
