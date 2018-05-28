package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class Menu {
    /**
     * @see java.util.List 
     * @see model.Hamburger
     */
    private List<Hamburger> listeHamburger = new ArrayList<Hamburger> ();
    /**
     * @see java.util.List
     * @see model.Accompagnement
     */
    private List<Accompagnement> listeAccompagnement = new ArrayList<Accompagnement> ();
    /**
     * @see java.util.List
     * @see model.Boisson
     */
    private List<Boisson> listeBoisson = new ArrayList<Boisson> ();

    /**
     * Constructeur Menu.
     */
    private Menu() {
    }

    /**
     * Singleton de la classe Menu.
     *
     * @return L'instance de la classe Menu.
     */
    public static Menu getInstance() {
        return MenuHolder.instance;
    }

    private static class MenuHolder {
        private static final Menu instance = new Menu();
    }

    /**
     * Ajoute un nouvel hamburger dans le menu.
     *
     * @param hamburger Le hamburger à ajouter dans le menu.
     */
    public void ajouterHamburger(Hamburger hamburger) {
    	listeHamburger.add(hamburger);
    }

    /**
     * Ajoute un nouvel accompagnement dans le menu.
     *
     * @param accompagnement L'accompagnement à ajouter dans le menu.
     */
    public void ajouterAccompagnement(Accompagnement accompagnement) {
    	listeAccompagnement.add(accompagnement);
    }

    /**
     * Ajoute une nouvelle boisson dans le menu.
     *
     * @param boisson La boisson à ajouter dans le menu.
     */
    public void ajouterBoisson(Boisson boisson) {
    	listeBoisson.add(boisson);
    }

    /**
     * Getter listeHamburger.
     *
     * @return La liste de tous les hamburgers du menu.
     */
    public List<Hamburger> getListHamburger() {
        return listeHamburger;
    }

    /**
     * Getter listeAccompagnement.
     *
     * @return La liste de tous les accompagnements du menu.
     */
    public List<Accompagnement> getListAccompagnement() {
        return listeAccompagnement;
    }

    /**
     * Getter listeBoisson.
     *
     * @return La liste de toutes les boissons du menu.
     */
    public List<Boisson> getListBoisson() {
        return listeBoisson;
    }
    
    /**
     * Récupère un hamburger en particulier.
     *
     * @param numHamburger Le numéro du hamburger dans le menu.
     * @return L'hamburger récupéré.
     */
    public Hamburger getHamburger(int numHamburger) {
    	return listeHamburger.get(numHamburger-1);
    }
    
    /**
     * Récupère un accompagnement en particulier.
     *
     * @param numAccompagnement Le numéro de l'accompagnement dans le menu.
     * @return L'accompagnement récupéré.
     */
    public Accompagnement getAccompagnement(int numAccompagnement) {
    	return listeAccompagnement.get(numAccompagnement-1);
    }
    
    /**
     * Récupère une boisson en particulier.
     *
     * @param numBoisson Le numéro de la boisson dans le menu.
     * @return La boisson récupéré.
     */
    public Boisson getBoisson(int numBoisson) {
    	return listeBoisson.get(numBoisson-1);
    }
    
    /**
     * 
     */
    public String toString() {
        return "Menu [listHamburger=" + listeHamburger + ", listAccompagnement=" + listeAccompagnement + ", listBoisson="
            + listeBoisson + "]";
    }

}
