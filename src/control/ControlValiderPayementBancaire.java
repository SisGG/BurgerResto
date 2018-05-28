package control;

import model.CarteBancaire;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlValiderPayementBancaire {

    /**
     * Valide le paiment de la commande avec une carte bancaire.
     *
     * @param carteBancaire Carte bancaire qui paye.
     * @param montant Montant de la transaction (le prix de la commande).
     */
    public void validerPaymentBancaire(CarteBancaire carteBancaire, int montant) {
        System.out.println("Compte bancaire n°" + carteBancaire.getNumeroCarte()
            + " a été débité de " + montant + " euros.");
    }
	
}
