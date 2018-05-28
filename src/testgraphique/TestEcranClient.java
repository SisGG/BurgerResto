package testgraphique;

import control.ControlCommander;
import control.ControlEnregistrerCoordonneesBancaires;
import control.ControlVerifierCoordonneesBancaires;
import control.ControlVerifierIdentification;
import vueGraphique.FrameClient;

public class TestEcranClient {
	
	/*
	 * Main fonction
	 */
	public static void main(String[] args) {
		new FrameClient(1,
				new ControlCommander(new ControlVerifierIdentification()),
				new ControlEnregistrerCoordonneesBancaires(new ControlVerifierCoordonneesBancaires()));
	}
	
}
