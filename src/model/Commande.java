package model;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class Commande {
	
    private static int numeroCommande = 0;
    private int numClient;
    private int numeroCommandeAttribuee;
    /**
     * @see model.Hamburger
     */
    private Hamburger hamburger;
    /**
     * @see model.Accompagnement
     */
    private Accompagnement accompagnement;
    /**
     * @see model.Boisson
     */
    private Boisson boisson;

    /**
     * Constructeur Commande.
     *
     * @param numClient Numéro de client de la commande.
     * @param hamburger Hamburger de la commande.
     * @param accompagnement Accompagnement de la commande.
     * @param boisson Boisson de la commande.
     */
    public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
    	this.hamburger = hamburger;
    	this.accompagnement = accompagnement;
    	this.boisson = boisson;
        ++numeroCommande;
        this.numClient = numClient;
        this.numeroCommandeAttribuee = numeroCommande;
    }
    
    /**
     * Initialise le numéro de la classe commande à 0.
     */
    public static void initialiserNumeroCommande() {
    	numeroCommande = 0;
    }

    /**
     * Getter NumeroCarteAttribuee.
     *
     * @return Le numéro de commande attribuée à la commande.
     */
    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }
    
    /**
     * Getter numeroClient.
     *
     * @return Le numéro de client de la commande.
     */
    public int getNumClient() {
    	return numClient;
    }
    
    /**
     * Getter Hamburger.
     *
     * @return Le hamburger de la commande.
     */
    public Hamburger getHamburger() {
    	return hamburger;
    }
    
    /**
     * Getter Accompagnement.
     *
     * @return L'accompagnement de la commande.
     */
    public Accompagnement getAccompagnement() {
    	return accompagnement;
    }
    
    /**
     * Getter Boisson.
     *
     * @return La boisson de la commande.
     */
    public Boisson getBoisson() {
    	return boisson;
    }
    
    /**
     * Calcule le prix total de la commande.
     *
     * @return le prix total de la commande.
     */
    public int prixTotal() {
    	return 8;
    }

    /**
     * @return La chaine de caractère de l'entité Commande.
     */
    public String toString() {
        return "Commande [numClient=" + numClient
	    + ", hamburger=" + hamburger
            + ", accompagnement=" + accompagnement
            + ", boisson=" + boisson + "]";
    }

}
