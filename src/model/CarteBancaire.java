package model;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class CarteBancaire {
	
    /**
     * 
     */
    private int numeroCarte;
    
    /**
     * 
     */
    private int dateExpCarte;
    
    /**
     * Constructeur CarteBancaire.
     *
     * @param numeroCarte Numéro de carte bancaire.
     * @param dateCarte Date de validé de la carte bancaire.
     */
    public CarteBancaire(int numeroCarte, int dateExpCarte) {
    	this.numeroCarte = numeroCarte;
    	this.dateExpCarte = dateExpCarte;
    }
    
    /**
     * Getter numéroCarte.
     *
     * @return Retourne le numéro de carte bancaire.
     */
    public int getNumeroCarte() {
    	return this.numeroCarte;
    }

    /**
     * @return La chaine de caractère de l'entité CarteBancaire.
     */
    public String toString() {
        return "CarteBancaire [numeroCarte=" + numeroCarte + ", dateExpCarte=" + dateExpCarte + "]";
    }

}
