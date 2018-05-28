package vue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author LanXor
 *
 */
public class Fichier {

	/**
	 * 
	 * @param nomFichier
	 * @param texte
	 */
	public static void ecrire(String nomFichier, String texte) {
		try {
			String chemin = "./" + nomFichier + ".txt";
			File writer = new File(chemin);
			FileWriter fichier = new FileWriter(writer, true);
			try {
				fichier.write(texte + "\n");
			} finally {
				fichier.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nomFichier
	 */
	public static void effacer(String nomFichier) {
		try {
			String chemin = "./" + nomFichier + ".txt";
			File writer = new File(chemin);
			FileWriter fichier = new FileWriter(writer, false);
			try {
				fichier.write("");
			} finally {
				fichier.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nomFichier
	 * @param texteEffacer
	 */
	public static void effacerLigne(String nomFichier, String texteEffacer) {
		String chaine = "";
		try {
			String chemin = "./" + nomFichier + ".txt";
			File reader = new File(chemin);
			FileReader fichier = new FileReader(reader);
			try {
				BufferedReader bufferedReader = new BufferedReader(fichier);
				String chaineTemporaire = "";
				do {
					chaineTemporaire = bufferedReader.readLine();
					if (chaineTemporaire != null && !chaineTemporaire.equals(texteEffacer)) {
						chaine += chaineTemporaire + "\n";
					}
				} while (chaineTemporaire != null);
				bufferedReader.close();
			} finally {
				fichier.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		if (chaine != null) {
			effacer(nomFichier);
			ecrire(nomFichier, chaine);
		}
	}
	
}
