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
	private IUseEnregistrerCoordonneesBancaires panAppelant;
	
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);
	private Font policeAremplacer = new Font("Arial", Font.ITALIC, 12);
	private Font policeChoixUtilisateur = new Font("Arial", Font.TRUETYPE_FONT, 12);
	
	private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
	private Box boxNumeroCarte = Box.createHorizontalBox();
	private Box boxValiditeCarte = Box.createHorizontalBox();
	private Box boxValiderCarte = Box.createHorizontalBox();
	
	private int numClient;
	
	private TextArea textAeraNumeroCarte = new TextArea();
	private TextArea textAeraDateExpiration = new TextArea();
	
	
	public PanEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
	}
	
	public void initialisation() {
		this.setBackground(Color.YELLOW);

		JLabel texteCoordonneBancaire = new JLabel("Entrez vos cordonnées bancaires");
		texteCoordonneBancaire.setFont(policeTitre);
		this.boxMiseEnPageCoordonneesBancaires.add(texteCoordonneBancaire);

		JLabel texteNumeroCarteBancaire = new JLabel("Entrez le numéro de votre carte bancaire");
		texteNumeroCarteBancaire.setFont(policeParagraphe);
		this.boxNumeroCarte.add(texteNumeroCarteBancaire);

		JLabel texteValiditeCarte = new JLabel("Entrez la date d'expiration de votre carte bancaire");
		texteValiditeCarte.setFont(policeParagraphe);
		this.boxValiditeCarte.add(texteValiditeCarte);

		this.boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
		this.boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);
		this.boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);

		this.add(boxMiseEnPageCoordonneesBancaires);
		this.boxMiseEnPageCoordonneesBancaires.setVisible(true);
		this.setVisible(false);

		this.textAeraNumeroCarte.setMaximumSize(new Dimension(60, 20));
		this.boxNumeroCarte.add(textAeraNumeroCarte);

		this.textAeraDateExpiration.setForeground(Color.GRAY);
		this.textAeraDateExpiration.setMaximumSize(new Dimension(60, 20));
		this.textAeraDateExpiration.setFont(policeAremplacer);

		this.textAeraDateExpiration.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				textAeraDateExpiration.setText(null);
				textAeraDateExpiration.setFont(policeChoixUtilisateur);
				textAeraDateExpiration.setForeground(Color.black);
			}
		});
		this.boxValiditeCarte.add(textAeraDateExpiration);

		JButton validationCoordonneeBancaire = new JButton();
		validationCoordonneeBancaire.setText("Valider");
		validationCoordonneeBancaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroCarte = Integer.valueOf(textAeraNumeroCarte.getText());
				int dateCarte = Integer.valueOf(textAeraDateExpiration.getText());
				traitementCoordoneesBancaires(numeroCarte, dateCarte);
			}
		});
		this.boxValiderCarte.add(validationCoordonneeBancaire);
	}
	
	public void enregistrerCoordonneesBancaires(int numClient, IUseEnregistrerCoordonneesBancaires panAppelant) {
		this.numClient = numClient;
		this.panAppelant = panAppelant;
		textAeraNumeroCarte.setText(null);
		textAeraDateExpiration.setText("MMAA");
		this.setVisible(true);
		this.repaint();
	}
	
	private void traitementCoordoneesBancaires(int numeroCarte, int dateCarte) {
		boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
		panAppelant.retourEnregistrerCoordonneesBancaires(carteValide);
	}


}
