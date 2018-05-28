package model;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public abstract class Profil {
	
    protected String nom;
    protected String prenom;
    protected String login;
    protected String mdp;
    protected boolean connecte = false;
	
    /**
     * Constructeur Profil.
     *
     * @param nom Nom du profil.
     * @param prenom Prénom du profil.
     * @param mdp Mot de passe du profil.
     */
    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        login = prenom + "." + nom;
    }
	
    /**
     * Compare le login et le mot de passe passé en paramètre à celui du profil.
     *
     * @param login Login à comparer.
     * @param mdp Mot de passe à comparer.
     * @return Renvoie vraie si les deux couples sont exacte, faux sinon.
     */
    public boolean selectionnerProfil(String login, String mdp) {
        boolean isClient = (this.login.equals(login) && this.mdp.equals(mdp));
        return isClient;
    }
	
    /**
     * Définit la variable connecter à true.
     */
    public void connecterProfil() {
        connecte = true;
    }
	
    /**
     * Vérifie si le profil est connecté.
     *
     * @return Vrai si le profil est connecté, faux sinon.
     */
    public boolean isConnecte() {
        return connecte;
    }
	
    /**
     * La chaine de caractère de l'entité Profil.
     */
    public String toString() {
        return "nom=" + nom 
            + ", prenom=" + prenom
            + ", login=" + login
            + ", mdp=" + mdp
            + ", connecte=" + connecte;
    }
	
}
