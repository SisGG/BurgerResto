package vueGraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.ControlCommander;
import control.ControlEnregistrerCoordonneesBancaires;

public class FrameClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String COMMANDER = "COMMANDER";
	private static final String HISTORIQUE = "HISTORIQUE";
	private static final String MODIFIER_PROFIL = "MODIFIER_PROFIL";
	private static final String ECRAN_ACCUEIL = "ECRAN_ACCUEIL";
	private MenuBar barreMenu = new MenuBar();
	private JPanel panContents = new JPanel();
	private JPanel panAccueil = new JPanel();
	private PanCommander panCommander;
	private PanEnregistrerCoordonneesBancaires panEnregistrerCoordonneesBancaires;
	private PanHistorique panHistorique = new PanHistorique();
	private PanModifierProfil panModifierProfil = new PanModifierProfil();
	private CardLayout cartes = new CardLayout();

	/**
	 * Constructeur FrameClient.
	 * 
	 * @param numeroClient Numéro du client.
	 * @param controlCommander Controleur commander commande.
	 * @param controlEnregistrerCoordonneesBancaires Controleur Enregistrer coordonnees bancaires.
	 */
	public FrameClient(int numClient,
			ControlCommander controlCommander,
			ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		
		panEnregistrerCoordonneesBancaires = new PanEnregistrerCoordonneesBancaires(controlEnregistrerCoordonneesBancaires);
		panCommander = new PanCommander(controlCommander,
				panEnregistrerCoordonneesBancaires);
		
		this.setTitle("Burger Resto");
		this.setSize(900, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.initialisationMenu(numClient);
		this.setMenuBar(barreMenu);
		
		panCommander.initialisation();
		panHistorique.initialisation();
		panModifierProfil.initialisation();
		this.panContents.setLayout(cartes);
		
		panContents.add(panCommander, COMMANDER);
		panContents.add(panHistorique, HISTORIQUE);
		panContents.add(panModifierProfil, MODIFIER_PROFIL);
		
		this.getContentPane().add(panContents);
		this.initialiserAccueil();
		
		this.setVisible(true);
	}
	
	/**
	 * Initialise le menu.
	 */
	private void initialisationMenu(int numClient) {
		MenuItem commander = new MenuItem("Commander");
		commander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				panCommander.commander(numClient);
				cartes.show(panContents, COMMANDER);
			}
		});
		
		MenuItem historique = new MenuItem("Historique");
		MenuItem modifierProfil = new MenuItem("Modifier mon profil");
		
		Menu menuMonCompte = new Menu("Mon compte");
		menuMonCompte.add(commander);
		menuMonCompte.add(historique);
		menuMonCompte.add(modifierProfil);
		
		commander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cartes.show(panContents, COMMANDER);
				panelVisible(COMMANDER);
			}
		});

		historique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cartes.show(panContents, HISTORIQUE);
				panelVisible(HISTORIQUE);
			}
		});

		modifierProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cartes.show(panContents, MODIFIER_PROFIL);
				panelVisible(MODIFIER_PROFIL);
			}
		});

		Menu menuDeconnexion = new Menu("Déconnexion");
		
		barreMenu.add(menuMonCompte);
		barreMenu.add(menuDeconnexion);
	}
	
	/**
	 * Initialise la page d'accueil.
	 */
	private void initialiserAccueil() {
		this.panAccueil.setBackground(Color.ORANGE);
		JLabel texteAccueil = new JLabel("Bienvenu à Burger Resto");
		texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
		this.panAccueil.add(texteAccueil);
		this.panAccueil.setVisible(true);
		this.panContents.add(panAccueil, ECRAN_ACCUEIL);
		cartes.show(panContents, ECRAN_ACCUEIL);
	}
	
	/*
	 * Changement de visibilité des panels.
	 */
	private void panelVisible(String nomPanel) {
		switch(nomPanel) {
			case COMMANDER:
				panHistorique.setVisible(false);
				panModifierProfil.setVisible(false);
				panCommander.setVisible(true);
				break;
			case HISTORIQUE:
				panHistorique.setVisible(true);
				panModifierProfil.setVisible(false);
				panCommander.setVisible(false);
				break;
			case MODIFIER_PROFIL:
				panHistorique.setVisible(false);
				panModifierProfil.setVisible(true);
				panCommander.setVisible(false);
				break;
			default:
				System.out.println("Pas de panel a ce nom.");
				break;
		}
	}

}
