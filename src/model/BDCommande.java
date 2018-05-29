package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
@SuppressWarnings("deprecation")
public class BDCommande extends Observable {

	/**
	 * @see java.util.Map
	 */
	private Map<Integer, Commande> commandes = new HashMap<>();

	/**
	 * Constructeur BDCommande.
	 */
	private BDCommande() {
	}

	/**
	 * Singleton de la classe BDCommande.
	 *
	 * @return L'instance de la classe BDCommande.
	 */
	public static BDCommande getInstance() {
		return BDCommandeHolder.instance;
	}

	private static class BDCommandeHolder {
		private static final BDCommande instance = new BDCommande();
	}

	/**
	 * Crée une commande et l'ajoute dans la base de données.
	 *
	 * @param numClient      Numéro du client de la commande.
	 * @param hamburger      Hamburger de la commande.
	 * @param accompagnement Accompagnement de la commande.
	 * @param boisson        Boisson de la commande.
	 * @return Retourne le numéro de commande enregistrer.
	 */
	public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
		String[] labels = new String[5];
		Commande commande = new Commande(numClient, hamburger, accompagnement, boisson);
		this.ajouterCommande(commande);
		int numeroCommande = commande.getNumeroCommandeAttribuee();
		labels[0] = String.valueOf(1);
		labels[1] = String.valueOf(numeroCommande);
		labels[2] = hamburger.getNom();
		labels[3] = accompagnement.getNom();
		labels[4] = boisson.getNom();
		setChanged();
		notifyObservers(labels);
		return numeroCommande;
	}

	/**
	 * Ajoute une commande à la base de données.
	 *
	 * @param commande Commande à ajouter dans la base de données.
	 */
	public void ajouterCommande(Commande commande) {
		int numeroCommande = commande.getNumeroCommandeAttribuee();
		commandes.put(numeroCommande, commande);
	}

	/**
	 * Supprime une commande dans la base de données.
	 *
	 * @param numeroCommande Numéro de commande à supprimer.
	 * @return Retourne la commande supprimer de la base de données.
	 */
	public Commande supprimerCommande(int numeroCommande) {
		Commande commande = commandes.get(numeroCommande);
		String[] labels = new String[5];
		labels[0] = String.valueOf(3);
		labels[1] = String.valueOf(numeroCommande);
		if (commande != null) {
			Hamburger hamburger = commande.getHamburger();
			Accompagnement accompagnement = commande.getAccompagnement();
			Boisson boisson = commande.getBoisson();
			labels[2] = hamburger.getNom();
			labels[3] = accompagnement.getNom();
			labels[4] = boisson.getNom();
			setChanged();
			notifyObservers(labels);
		}
		return commande;
	}

	/**
	 * Vide la base de données de toutes les commandes enregistrées.
	 */
	public void viderCommandes() {
		commandes.clear();
		String[] labels = new String[1];
		labels[0] = String.valueOf(2);
		setChanged();
		notifyObservers(labels);
	}

	/**
	 * 
	 */
	public String toString() {
		return "BDCommande [commandes=" + commandes + "]";
	}

}
