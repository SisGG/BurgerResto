package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class Client extends Profil {
	
    /**
    * @see java.util.List
    * @see model.Commande
    */
    private List<Commande> historiqueCommande = new ArrayList<>();
    /**
     * @see model.CarteBancaire
     */
    private CarteBancaire carteBancaire;

    /**
     * Constructeur Client.
     *
     * @param nom Nom du client.
     * @param prenom Prénom du client.
     * @param mdp Mot de passe du client.
     */
    public Client(String nom, String prenom, String mdp) {
    	super(nom, prenom, mdp);
    }

    /**
     * Vérifie si le client possède une carte bancaire.
     *
     * @return Retourne si le client possède une carte bancaire.
     */
    public boolean isCoordonneesBancaireExist() {
        return false;
    }
    
    /**
     * Enregistre une nouvelle carte bancaire au client.
     *
     * @param numeroCarte Numéro de la carte bancaire.
     * @param dateCarte Date de validité de la carte bancaire.
     */
    public void enregistrerCoordonneesBancaires(int numeroCarte, int dateExpCarte) {
    	this.carteBancaire = new CarteBancaire(numeroCarte, dateExpCarte);
    }

    /**
     * Ajoute une commande dans l'historique de commande du client.
     *
     * @param commande Commande à ajouter dans l'historique du client.
     */
    public void ajouterCommande(Commande commande) {
    	historiqueCommande.add(commande);
    }
    
    /**
     * Getter historique des commandes du client.
     *
     * @return L'historique des commandes du client.
     */
    public List<Commande> getHistoriqueCommandes() {
    	return historiqueCommande;
    }
    
    /**
     * Getter carte bancaire du client.
     *
     * @return La carte bancaire du client.
     */
    public CarteBancaire getCarteBancaire() {
    	return carteBancaire;
    }

    /**
     * @return La chaine de caractère de l'entité Client.
     */
    public String toString() {
        return "Client [" + super.toString() + ", carteBancaire=" + carteBancaire + "]";
    }

}
