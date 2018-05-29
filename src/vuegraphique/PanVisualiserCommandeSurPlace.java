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

import control.ControlVisualiserCommandeSurPlace;
import model.BDCommande;

@SuppressWarnings("deprecation")
public class PanVisualiserCommandeSurPlace extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	// controleurs du cas
	private ControlVisualiserCommandeSurPlace controlVisualiserCommandeSurPlace;

	// les attributs metiers
	private static Map<String, String> mapCommandeSurPlace = new HashMap<>();

	// Les elements graphiques :
	// polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

	// Mise en page : les Box
	private Box boxMiseEnpage = Box.createVerticalBox();
	private Box boxCommandeSurPlace = Box.createVerticalBox();
	private Box boxCommandes = Box.createVerticalBox();

	private FrameCuisinier frame;

	public PanVisualiserCommandeSurPlace(ControlVisualiserCommandeSurPlace controlVisualiserCommandeSurPlace) {
		this.controlVisualiserCommandeSurPlace = controlVisualiserCommandeSurPlace;
	}

	// Methode d'initialisation du panel
	public void initialisation(FrameCuisinier frame) {
		this.frame = frame;
		// mise en forme du panel (couleur, ...)
		this.setBackground(Color.WHITE);
		// creation des differents elements graphiques (JLabel, Combobox,
		// Button, TextAera ...)

		JLabel titre = new JLabel("Commandes des clients sur place");
		titre.setFont(policeTitre);

		// mise en page : placements des differents elements graphiques dans des
		// Box
		this.boxCommandeSurPlace.add(titre);
		this.boxCommandeSurPlace.add(Box.createRigidArea(new Dimension(0, 15)));
		this.boxCommandeSurPlace.add(boxCommandes);
		// mise en page : placements des differentes box dans une box principale
		this.boxMiseEnpage.add(boxCommandeSurPlace);
		// mise en page : ajout de la box principale dans le panel
		this.add(boxMiseEnpage);
	}

	@Override
	public void update(Observable o, Object objet) {
		if ( o instanceof BDCommande ) {
			if ( objet instanceof String[] ) {
				String[] labels = (String[])objet;
				int numeroLabel = Integer.parseInt(labels[0]);
				if ( numeroLabel == 3 ) {
					String texteCommandeJour = ("Commande no " + labels[1] + " : " + labels[2] + ", "
							+ labels[3] + ", " + labels[4]);
							JLabel label = new JLabel(texteCommandeJour);
							label.setFont(policeParagraphe);
							PanVisualiserCommandeJour.mapCommandeJour.put(labels[1], texteCommandeJour);
							boxCommandes.add(label);
							actualiserPanel();
				}
			} else {
				System.out.println("Type de message inconnu.");
			}
		} else {
			System.out.println("Objet émetteur inconnu.");
		}
	}

	private void actualiserPanel() {
		frame.setVisible(true);
		frame.repaint();
	}

	private void initialiserPanel() {
		boxCommandes.removeAll();
		for (String texte : mapCommandeSurPlace.values()) {
			JLabel label = new JLabel(texte);
			label.setFont(policeParagraphe);
			boxCommandes.add(label);
		}
		actualiserPanel();
	}

	public void visualiserCommandeSurPlace(int numProfil){
		boolean identificationOk = controlVisualiserCommandeSurPlace.verifierIdentification(numProfil);
		if ( identificationOk ) {
			controlVisualiserCommandeSurPlace.setObserver(this);
		}
	}

}
