package model;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class Personnel extends Profil {
	
    private boolean gerant = false;
	
    /**
     * Constructeur Personnel.
     *
     * @param nom Nom du personnel.
     * @param prenom Prénom du personnel.
     * @param mdp Mot de passe du personnel.
     */
    public Personnel(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }
	
    /**
     * Permet de définir un personnel en tant que gérant.
     */
    public void definirGerant() {
        gerant = true;
    }
	
    /**
     * Vérifie si le personnel est un gérant ou non.
     *
     * @return Renvoie true si c'est un gérant, sinon renvoie false.
     */
    public boolean isGerant() {
        return gerant;
    }

    /**
     * @return La chaine de caractère de l'entité Personnel.
     */
    public String toString() {
        return "Personnel [gerant=" + gerant + ", " + super.toString() + "]";
    }
	
}
