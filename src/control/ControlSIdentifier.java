package control;

import model.BDClient;
import model.BDPersonnel;
import model.ProfilUtilisateur;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class ControlSIdentifier {
	
    /**
     * @see model.BDClient
     */
    private BDClient bdClient = BDClient.getInstance();
    /**
     * @see model.BDPersonnel
     */
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    /**
     * Identifie un utilisateur, et le connecte.
     *
     * @param client Type de client.
     * @param login Login à vérifier.
     * @param mdp Mot de passe à vérifier.
     * @return Numéro du profil, sinon -1.
     */
    public int sIdentifier(ProfilUtilisateur client, String login, String mdp) {
        int numProfil = -1;
        switch (client) {
            case CLIENT:
                numProfil = bdClient.connecterClient(login, mdp);
                break;
            default:
                numProfil = bdPersonnel.connecterPersonnel(login, mdp);
                break;
        }
        return numProfil;
    }
	
    /**
     * Renvoie la chaine de caractère des utilisateurs de la base de données.
     *
     * @return La chaine de caractre des utilisateurs de la base de données.
     */
    public String visualiserBDUtilisateur() {
        return bdPersonnel + "\n" + bdClient;
    }
	
}
