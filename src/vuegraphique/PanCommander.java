package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlCommander;

public class PanCommander extends JPanel implements IUseEnregistrerCoordonneesBancaires {

	private static final long serialVersionUID = 1L;
	private ControlCommander controlCommande;
	private PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaire;

	private int numClient;
	private int numeroHamburger;
	private int numeroAccompagnement;
	private int numeroBoisson;

	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

	private Box boxMiseEnPageCommande = Box.createVerticalBox();
	private Box boxChoixHamburger = Box.createHorizontalBox();
	private Box boxChoixAccompagnement = Box.createHorizontalBox();
	private Box boxChoixBoisson = Box.createHorizontalBox();
	private Box boxValiderChoix = Box.createHorizontalBox();
	private Box boxMiseEnPageNumeroCommande = Box.createVerticalBox();

	private JButton validerCommande = new JButton();
	private JLabel numeroCommande = new JLabel();

	/**
	 * Constructeur PanCommander.
	 * 
	 * @param controlCommander                   Control commander commande.
	 * @param panEnregistrerCoordonneesBancaires Panel
	 *                                           enregistrerCoordonneesBancaires.
	 */
	public PanCommander(ControlCommander controlCommande,
			PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires) {
		this.controlCommande = controlCommande;
		this.panEnregistrerCoordonneesBancaire = panEnregistrerCoordonneesBancaires;
	}

	/**
	 * Initialise le panel
	 */
	public void initialisation() {
		this.setBackground(Color.YELLOW);

		JLabel texteCommander = new JLabel("Votre menu");
		texteCommander.setFont(policeTitre);

		/* Hamburger */
		JLabel texteHamburger = new JLabel("Choisissez votre hamburger : ");
		texteHamburger.setFont(policeParagraphe);
		boxMiseEnPageCommande.add(texteCommander);
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixHamburger.add(texteHamburger);
		boxMiseEnPageCommande.add(boxChoixHamburger);

		/* Accompagnement */
		JLabel texteAcc = new JLabel("Choisissez votre accompagnement : ");
		texteAcc.setFont(policeParagraphe);
		boxMiseEnPageCommande.add(texteAcc);
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixAccompagnement.add(texteAcc);
		boxMiseEnPageCommande.add(boxChoixAccompagnement);

		/* Boisson */
		JLabel texteBoisson = new JLabel("Choisissez votre boisson : ");
		texteBoisson.setFont(policeParagraphe);
		boxMiseEnPageCommande.add(texteBoisson);
		boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixBoisson.add(texteBoisson);
		boxMiseEnPageCommande.add(boxChoixBoisson);

		/* Valider */
		validerCommande.setText("Valider");
		validerCommande.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (numeroHamburger != 0 && numeroAccompagnement != 0 && numeroBoisson != 0) {
					validationCartePayement();
				}

			}
		});
		boxValiderChoix.add(validerCommande);
		boxMiseEnPageCommande.add(boxValiderChoix);

		JLabel textNumeroCommandeTitre = new JLabel("Votre commande");
		textNumeroCommandeTitre.setFont(policeTitre);
		numeroCommande.setFont(policeParagraphe);

		boxMiseEnPageNumeroCommande.add(numeroCommande);
		boxMiseEnPageNumeroCommande.add(textNumeroCommandeTitre);
		boxMiseEnPageNumeroCommande.add(Box.createRigidArea(new Dimension(0, 30)));
		numeroCommande.setFont(policeParagraphe);
		boxMiseEnPageNumeroCommande.add(numeroCommande);
		this.add(boxMiseEnPageNumeroCommande);
		this.add(boxMiseEnPageCommande);
	}

	/**
	 * Permet a un client de faire une commande a partir de son numero
	 * 
	 * @param numClient
	 */
	public void commander(int numClient) {
		this.numClient = numClient;
		boxMiseEnPageCommande.setVisible(true);
		boxMiseEnPageNumeroCommande.setVisible(false);

		if (controlCommande.verifierIdentification(numClient)) {
			this.affichageMenu();
			this.selectionMenu();
		}
	}

	/**
	 * 
	 */
	private void affichageMenu() {
		/* Hamburger */
		List<String> listeHamburger = controlCommande.getListHamburger();

		final JComboBox<String> comboBoxHamburger = new JComboBox<>();
		comboBoxHamburger.addItem("");

		for (String item : listeHamburger) {
			comboBoxHamburger.addItem(item);
			comboBoxHamburger.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					numeroHamburger = comboBoxHamburger.getSelectedIndex();
				}
			});
		}
		this.boxChoixHamburger.add(Box.createRigidArea(new Dimension(10, 0)));
		this.boxChoixHamburger.add(comboBoxHamburger);

		/* Accompagnement */
		List<String> listeAccompagnement = controlCommande.getListAccompagnement();

		final JComboBox<String> comboBoxAccompagnement = new JComboBox<>();
		comboBoxAccompagnement.addItem("");
		for (String item : listeAccompagnement) {
			comboBoxAccompagnement.addItem(item);
			comboBoxAccompagnement.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					numeroAccompagnement = comboBoxAccompagnement.getSelectedIndex();
				}
			});
		}
		this.boxChoixAccompagnement.add(Box.createRigidArea(new Dimension(10, 0)));
		this.boxChoixAccompagnement.add(comboBoxAccompagnement);

		/* Boisson */
		List<String> listeBoisson = controlCommande.getListBoisson();

		final JComboBox<String> comboBoxBoisson = new JComboBox<>();
		comboBoxBoisson.addItem("");
		for (String item : listeBoisson) {
			comboBoxBoisson.addItem(item);
			comboBoxBoisson.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					numeroBoisson = comboBoxBoisson.getSelectedIndex();
				}
			});
		}
		this.boxChoixBoisson.add(Box.createRigidArea(new Dimension(10, 0)));
		this.boxChoixBoisson.add(comboBoxBoisson);
	}

	/*
	 * 
	 */
	private void selectionMenu() {
		boxMiseEnPageCommande.setVisible(true);
		this.setVisible(true);
		repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vuegraphique.IUseEnregistrerCoordonneesBancaires#
	 * retourEnregistrerCoordonneesBancaires(boolean)
	 */
	@Override
	public void retourEnregistrerCoordonneesBancaires(boolean carteValide) {
		this.panEnregistrerCoordonneesBancaire.setVisible(false);
		if (carteValide) {
			this.enregistrerCommande(carteValide);
		}
	}

	/*
	 * 
	 */
	private void validationCartePayement() {
		boolean carteRenseignee = controlCommande.isCarteRenseignee(numClient);
		if (!carteRenseignee) {
			boxMiseEnPageCommande.setVisible(false);
			panEnregistrerCoordonneesBancaire.setVisible(true);
			this.repaint();
			panEnregistrerCoordonneesBancaire.enregistrerCoordonneesBancaires(numClient, this);
		} else {
			this.enregistrerCommande(carteRenseignee);
		}
	}

	/*
	 * 
	 */
	public void enregistrerCommande(boolean carteRenseignee) {
		if (carteRenseignee) {
			int numCommande = controlCommande.enregistrerCommande(numClient, numeroHamburger-1, numeroAccompagnement-1,
					numeroBoisson-1);
			numeroCommande.setText("Votre numero est : " + numCommande);
		}
		this.setVisible(true);
		boxMiseEnPageCommande.setVisible(false);
		boxMiseEnPageNumeroCommande.setVisible(true);
		this.repaint();
	}
}
