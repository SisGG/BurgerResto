package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlVisualiserCommandeJour;
import model.BDCommande;

@SuppressWarnings("deprecation")
public class PanVisualiserCommandeJour extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	// controleurs du cas
	private ControlVisualiserCommandeJour controlVisualiserCommandeJour;

	// les attributs metiers
	public static Map<String, String> mapCommandeJour = new HashMap<>();

	// Les elements graphiques :
	// polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

	// Mise en page : les Box
	private Box boxMiseEnpage = Box.createVerticalBox();
	private Box boxCommandeJour = Box.createVerticalBox();
	private Box boxCommandes = Box.createVerticalBox();

	private FrameCuisinier frame;

	public PanVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
		this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
	}

	// Methode d'initialisation du panel
	public void initialisation(FrameCuisinier frame) {
		this.frame = frame;
		// mise en forme du panel (couleur, ...)
		this.setBackground(Color.WHITE);
		// creation des differents elements graphiques (JLabel, Combobox,
		// Button, TextAera ...)

		JLabel titre = new JLabel("Commande du Jour");
		titre.setFont(policeTitre);

		// mise en page : placements des differents elements graphiques dans des
		// Box
		this.boxCommandeJour.add(titre);
		this.boxCommandeJour.add(Box.createRigidArea(new Dimension(0, 15)));
		this.boxCommandeJour.add(boxCommandes);
		// mise en page : placements des differentes box dans une box principale
		this.boxMiseEnpage.add(boxCommandeJour);
		// mise en page : ajout de la box principale dans le panel
		this.add(boxMiseEnpage);
	}

	@Override
	public void update(Observable o, Object objet) {
		if ( o instanceof BDCommande ) {
			if ( objet instanceof String[] ) {
				String[] labels = (String[])objet;
				int numeroLabel = Integer.parseInt(labels[0]);
				if ( numeroLabel == 1 ) {
					String texteCommandeJour = ("Commande no " + labels[1] + " : " + labels[2] + ", "
							+ labels[3] + ", " + labels[4]);
							JLabel label = new JLabel(texteCommandeJour);
							label.setFont(policeParagraphe);
							PanVisualiserCommandeJour.mapCommandeJour.put(labels[1], texteCommandeJour);
							boxCommandes.add(label);
							actualiserPanel();
				} else if ( numeroLabel == 2 ) {
					PanVisualiserCommandeJour.mapCommandeJour.clear();
					boxCommandes.removeAll();
					actualiserPanel();
					} else if ( numeroLabel == 3 ) {
						PanVisualiserCommandeJour.mapCommandeJour.remove(labels[1]);
						initialiserPanel();
				} else {
					System.out.println("Numero d'affichage non reconnu");
				}
				
			} else {
				System.out.println("Type de message inconnu.");
			}
		} else {
			System.out.println("Objet emetteur inconnu.");
		}
	}

	private void actualiserPanel() {
		frame.setVisible(true);
		frame.repaint();
	}

	private void initialiserPanel() {
		boxCommandes.removeAll();
		for (String texte : mapCommandeJour.values()) {
			JLabel label = new JLabel(texte);
			label.setFont(policeParagraphe);
			boxCommandes.add(label);
		}
		actualiserPanel();
	}

	public void visualiserCommandeJour(int numProfil){
		boolean identificationOk = controlVisualiserCommandeJour
				.verifierIdentification(numProfil);
		if ( identificationOk ) {
			controlVisualiserCommandeJour.setObserver(this);
		}
	}

}
