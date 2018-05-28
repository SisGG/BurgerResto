package control;

import model.Accompagnement;
import model.Boisson;
import model.Hamburger;
import model.Menu;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlAjouterAlimentMenu {
    /**
     * @see model.Menu
     */
    private Menu menu = Menu.getInstance();
    /**
     * @see control.ControlVerifierIdentification
     */
    private ControlVerifierIdentification controlVerifierIdentification;
    
    /**
     * Constructeur ControlAjouterAlimentMenu.
     *
     * @param controlVerifierIdentification Controleur vérification de l'indentification.
     */
    public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
    	this.controlVerifierIdentification = controlVerifierIdentification;
    }

    /**
     * Ajoute un nouveau hamburger dans le menu.
     *
     * @param nom Nom du hamburger à ajouter.
     */
    public void ajouterHamburger(String nom) {
        Hamburger hamburger = new Hamburger(nom);
        menu.ajouterHamburger(hamburger);
    }

    /**
     * Ajoute un accompagnement au menu.
     *
     * @param nom Nom de l'accompagnement à ajouter.
     */
    public void ajouterAccompagnement(String nom) {
        Accompagnement accompagnement = new Accompagnement(nom);
        menu.ajouterAccompagnement(accompagnement);
    }

    /**
     * Ajoute une boisson au menu.
     *
     * @param nom Nom de la boisson à ajouter.
     */
    public void ajouterBoisson(String nom) {
        Boisson boisson = new Boisson(nom);
        menu.ajouterBoisson(boisson);
    }

    /**
     * Vérifie si l'utilisateur est connecté.
     *
     * @param numProfil Numéro de profil à vérifier.
     * @return Vrai si le profil est connecté, faux sinon.
     */
    public boolean verifierIdentification(int numProfil) {
    	boolean identificationOk = controlVerifierIdentification
    			.verifierIdentification(ProfilUtilisateur.GERANT, numProfil);
    	return identificationOk;
    }
    
    /**
     * Renvoie la chaine de caractère du menu.
     *
     * @return La chaine de caractère du menu.
     */
    public String visualiserMenu() {
    	return menu.toString();
    }

}
