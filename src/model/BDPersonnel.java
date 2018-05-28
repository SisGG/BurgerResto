package model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BDPersonnel {

    /**
     * @see java.util.Map
     */
    private Map<Integer, Personnel> listePersonnel = new HashMap<>();
    
    /**
     * Constructeur BDPersonnel.
     */
    private BDPersonnel() {
    }

    /**
     * Singleton de la classe BDPersonnel.
     *
     * @return L'instance de la classe BDPersonnel.
     */
    public static BDPersonnel getInstance() {
        return BDPersonnelHolder.instance;
    }

    private static class BDPersonnelHolder {
        private static final BDPersonnel instance = new BDPersonnel();
    }
    
    /**
     * Ajoute un personnel dans la base de données.
     *
     * @param personnel Personnel à ajouter dans la base de données.
     */
    public void ajouterPersonnel(Personnel personnel) {
    	listePersonnel.put(listePersonnel.size(), personnel);
    }

    /**
     * Connecte un personnel de la base de données.
     *
     * @param login Le login du personnel.
     * @param mdp Le mot de passe du personnel.
     * @return Le numéro du personnel recherché et trouvé, sinon -1.
     */
    public int connecterPersonnel(String login, String mdp) {
        int numConnexion = -1;
        for (Map.Entry<Integer, Personnel> entry : listePersonnel.entrySet()) {
            Integer numPersonnel = entry.getKey();
                Personnel personnel = entry.getValue();
                if (personnel.selectionnerProfil(login, mdp)) {
                    personnel.connecterProfil();
                    numConnexion = numPersonnel;
                }
            }
        return numConnexion;
    }
	
    /**
     * Retourne un personnel en fonction du numéro passé en parmètre.
     *
     * @param numeroClient Numéro du personnel enregistrer dans la base de données.
     * @return Le personnel correspondant au numéro de personnel passé en paramètre.
     */
    public Personnel selectionnerPersonnel(int numeroPersonnel) {
        return listePersonnel.get((Integer)numeroPersonnel);
    }

    /**
     * @return La chaine de caractère de l'entité BDPersonnel.
     */
    public String toString() {
        return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
    }
    
}
