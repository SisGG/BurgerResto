package vueGraphique;

import javax.swing.JFrame;

public class FrameClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructeur FrameClient.
	 * 
	 * @param numClient Numéro du client.
	 */
	public FrameClient(int numClient) {
		this.setTitle("BurgerResto");
		this.setSize(900, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
