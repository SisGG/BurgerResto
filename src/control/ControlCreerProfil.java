package control;

import model.BDClient;
import model.BDPersonnel;
import model.Client;
import model.Personnel;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlCreerProfil {
	
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();
    /**
     * @see model.BDPersonnel
     */
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();
	
    /**
     * Crée un nouveau profil utilisateur.
     *
     * @param profil Type de profil à créer.
     * @param nom Nom du profil à créer.
     * @param prenom Prénom du profil à créer.
     * @param mdp Mot de passe du profil à créer.
     */
    public void creerProfil(ProfilUtilisateur profil, String nom, String prenom, String mdp) {
        switch(profil) {
            case GERANT:
                Personnel gerant = new Personnel(nom, prenom, mdp);
                gerant.definirGerant();
                bdPersonnel.ajouterPersonnel(gerant);
                break;
            case PERSONNEL:
                Personnel personnel = new Personnel(nom, prenom, mdp);
                bdPersonnel.ajouterPersonnel(personnel);
                break;
            case CLIENT:
                Client client = new Client(nom, prenom, mdp);
                bdClient.ajouterClient(client);
                break;
        }
    }

    /**
     * Renvoie la chaine de caractère des utilisateurs de la base de données.
     *
     * @return La chaine de caractère des utilisateurs de la base de données.
     */
    public String visualiserBDUtilisateur() {
        return bdPersonnel + "\n" + bdClient;
    }	

}
