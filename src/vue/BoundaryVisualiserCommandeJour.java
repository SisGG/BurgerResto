package vue;

import java.util.Observable;
import java.util.Observer;

import control.ControlVisualiserCommandeJour;
import model.BDCommande;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryVisualiserCommandeJour implements Observer {
	
	/**
	 * @see control.ControlVisualiserCommandeJour
	 */
	private ControlVisualiserCommandeJour controlVisualiserCommandeJour;
	
	/**
	 * Constructeur BoundaryVisualiserCommandeJour.
	 *
	 * @param controlVisualiserCommandeJour Controleur visualiser commande du jour.
	 */
	public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
		this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
	}
	
	/**
	 * Fonction update des observer/observable.
	 */
	public void update(Observable arg0, Object arg1) {
		if ( arg0 instanceof BDCommande ) {
			if ( arg1 instanceof String[] ) {
				String[] labels = (String[])arg1;
				int numeroLabel = Integer.parseInt(labels[0]);
				if ( numeroLabel == 1 ) {
					Fichier.ecrire("ecranCuisinierCommandeJour", "Commande n°" + labels[1] + " : "
							+ labels[2] + ", " + labels[3] + ", "
							+ labels[4]);
				} else if ( numeroLabel == 2 ) {
					Fichier.effacer("ecranCuisinierCommandeJour");
				} else if ( numeroLabel == 3 ) {
					Fichier.effacerLigne("ecranCuisinierCommandeJour", "Commande n°" + labels[1] + " : "
							+ labels[2] + ", " + labels[3] + ", "
							+ labels[4]);
				} else {
					System.out.println("Numéro d'affichage non reconnu");
				}
				
			} else {
				System.out.println("Type de message inconnu.");
			}
		} else {
			System.out.println("Objet émetteur inconnu.");
		}
	}
	
	/**
	 * Visualise les commandes du jour.
	 *
	 * @param numProfil Numéro de profil.
	 */
	public void visualiserCommandeJour(int numProfil) {
		boolean identificationOk = controlVisualiserCommandeJour
				.verifierIdentification(numProfil);
		if ( identificationOk ) {
			controlVisualiserCommandeJour.setObserver(this);
		}
	}

}
