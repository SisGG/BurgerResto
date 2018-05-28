package vue;

import java.util.Observable;
import java.util.Observer;
import control.ControlVisualiserCommandeSurPlace;
import model.BDCommande;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryVisualiserCommandeSurPlace implements Observer {
	
	/**
	 * @see control.ControlVisualiserCommandeSurPlace
	 */
	private ControlVisualiserCommandeSurPlace controlVisualiserCommandeClient;
	
	/**
	 * Constructeur BoundaryVisualiserCommandeSurPlace.
	 *
	 * @param controlVisualiserCommandeClient Controleur visualier commande du client.
	 */
	public BoundaryVisualiserCommandeSurPlace(ControlVisualiserCommandeSurPlace controlVisualiserCommandeClient) {
		this.controlVisualiserCommandeClient = controlVisualiserCommandeClient;
	}
	
	/**
	 * Visualise la commande sur place.
	 *
	 * @param numClient Numéro de client.
	 */
	public void visualiserCommandeSurPlace(int numProfil) {
		boolean identificationOk = controlVisualiserCommandeClient
				.verifierIdentification(numProfil);
		if ( identificationOk ) {
			controlVisualiserCommandeClient.setObserver(this);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if ( arg0 instanceof BDCommande ) {
			if ( arg1 instanceof String[] ) {
				String[] labels = (String[])arg1;
				int numeroLabel = Integer.parseInt(labels[0]);
				if ( numeroLabel == 3 ) {
					Fichier.ecrire("ecranCuisinierCommandeSurPlace","Commande n°" + labels[1] + " : "
							+ labels[2] + ", " + labels[3] + ", "
							+ labels[4]);
				}
			} else {
				System.out.println("Type de message inconnu.");
			}
		} else {
			System.out.println("Objet émetteur inconnu.");
		}
		
	}
	
}
