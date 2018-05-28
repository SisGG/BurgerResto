package control;

import model.BDClient;
import model.BDCommande;
import model.CarteBancaire;
import model.Client;
import model.Commande;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlRetirerCommandeBorne {
	
    /**
     * @see control.ControlValiderPayementBancaire
     */
    private ControlValiderPayementBancaire controlValiderPaymentBancaire;
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();	
    /**
     * @see model.BDCommande
     */
    private BDCommande bdCommande = BDCommande.getInstance();
	
    /**
     * Constructeur ControlRetirerCommandeBorne.
     *
     * @param validerPaymentBancaire Controleur validation paiement bancaire.
     */
    public ControlRetirerCommandeBorne(ControlValiderPayementBancaire controlValiderPaymentBancaire) {
        this.controlValiderPaymentBancaire = controlValiderPaymentBancaire;
    }
	
    /**
     * Retire une commande.
     *
     * @param numeroCommande Numéro de la commande à retirer.
     * @return Vrai si la commande à été retirer.
     */
    public boolean retirerCommande(int numeroCommande) {
        Commande commande = bdCommande.supprimerCommande(numeroCommande);
        if ( commande != null ) {
            int numeroClient = commande.getNumClient();
            Client client = bdClient.selectionnerClient(numeroClient);
            CarteBancaire carteBancaire = client.getCarteBancaire();
            int montant = commande.prixTotal();
            controlValiderPaymentBancaire.validerPaymentBancaire(carteBancaire, montant);
            client.ajouterCommande(commande);
            return true;
        }
        return false;
    }
}
