package model;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public abstract class Aliment {
	
   /**
    * @see String
    */
    private String nom;

    /**
     * Constructeur Aliment.
     * 
     * @param nom Nom de l'aliment.
     */
    public Aliment(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le nom de l'aliment.
     * 
     * @return Le nom de l'aliment, sous forme d'une chaine de caractères.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return La chaine de caractère de l'entité Aliment.
     */
    public String toString() {
        return "nom=" + nom;
    }

}
