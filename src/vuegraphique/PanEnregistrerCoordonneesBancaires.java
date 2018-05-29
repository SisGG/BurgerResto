package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.ControlEnregistrerCoordonneesBancaires;

public class PanEnregistrerCoordonneesBancaires extends JPanel {

	private static final long serialVersionUID = 1L;
	private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);
	private Font policeAremplacer = new Font("Arial", Font.ITALIC, 12);
	private Font policeChoixUtilisateur = new Font("Arial", Font.TRUETYPE_FONT, 12);
	private Box boxMiseEnPageCoordonneeBancaire = Box.createVerticalBox();
	private Box boxNumeroCarte = Box.createHorizontalBox();
	private Box boxValiditeCarte = Box.createHorizontalBox();
	private Box boxValiderCarte = Box.createHorizontalBox();
	private int numClient = -1;
	private TextArea textAeraNumeroCarte = new TextArea();
	private TextArea textAeraDateExpiration = new TextArea();
	
	
	public PanEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
	}
	
	public void initialisation() {
		this.setBackground(Color.YELLOW);

		JLabel texteCoordonnerBancaire = new JLabel("Entrer vos coordonnées bancaires :");
		texteCoordonnerBancaire.setFont(policeTitre);

		JLabel texteNumeroCarteBancaire = new JLabel("Entrer le numéro de votre carte bancaire :");
		texteNumeroCarteBancaire.setFont(policeParagraphe);
		boxNumeroCarte.add(texteNumeroCarteBancaire);
		boxNumeroCarte.add(Box.createRigidArea(new Dimension(10, 0)));
		textAeraNumeroCarte.setMaximumSize(new Dimension(160, 45));
		boxNumeroCarte.add(textAeraNumeroCarte);

		JLabel texteValiditeCarte = new JLabel("Entrer la date d'expiration de votre carte bancaire :");
		texteValiditeCarte.setFont(policeParagraphe);
		boxValiditeCarte.add(texteValiditeCarte);
		boxValiditeCarte.add(Box.createRigidArea(new Dimension(10, 0)));
		textAeraDateExpiration.setForeground(Color.GRAY);
		textAeraDateExpiration.setMaximumSize(new Dimension(50, 45));
		textAeraDateExpiration.setFont(policeAremplacer);
		textAeraDateExpiration.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				textAeraDateExpiration.setText(null);
				textAeraDateExpiration.setFont(policeChoixUtilisateur);
				textAeraDateExpiration.setForeground(Color.BLACK);
			}
		});
		boxValiditeCarte.add(textAeraDateExpiration);
		
		JButton validationCoordonneesBancaires = new JButton();
		validationCoordonneesBancaires.setText("Valider");
		validationCoordonneesBancaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ok");
			}
		});
		boxValiderCarte.add(validationCoordonneesBancaires);
		
		// On ajoute les boxs dans la boxe principale.
		boxMiseEnPageCoordonneeBancaire.add(texteCoordonnerBancaire);
		boxMiseEnPageCoordonneeBancaire.add(Box.createRigidArea(new Dimension(0, 30)));
		boxMiseEnPageCoordonneeBancaire.add(boxNumeroCarte);
		boxMiseEnPageCoordonneeBancaire.add(Box.createRigidArea(new Dimension(0, 30)));
		boxMiseEnPageCoordonneeBancaire.add(boxValiditeCarte);
		boxMiseEnPageCoordonneeBancaire.add(Box.createRigidArea(new Dimension(0, 30)));
		boxMiseEnPageCoordonneeBancaire.add(boxValiderCarte);
		
		this.add(boxMiseEnPageCoordonneeBancaire);
		boxMiseEnPageCoordonneeBancaire.setVisible(true);
		this.setVisible(true);
	}
	
	public void enregistrerCoordonneesBancaires(int numClient) {
		this.numClient = numClient;
		textAeraNumeroCarte.setText("");
		textAeraDateExpiration.setText("MMAA");
		this.setVisible(true);
		this.repaint();
	}


}
