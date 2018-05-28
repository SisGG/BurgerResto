package model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BDClient {
	
    /**
     * @see java.util.Map
     */
    private Map<Integer, Client> listeClient = new HashMap<>();
    
    /**
     * Ajoute un client dans la base de données.
     *
     * @param client Client à ajouter dans la BD.
     */
    public void ajouterClient(Client client) {
    	listeClient.put(listeClient.size(), client);
    }
    
    /**
     * Constructeur BDClient.
     */
    private BDClient() {
    }
    
    /**
     * Singleton de la classe BDClient.
     *
     * @return L'instance de la classe BDClient.
     */
    public static BDClient getInstance() {
        return BDClientHolder.instance;
    }

    private static class BDClientHolder {
        private static final BDClient instance = new BDClient();
    }
	
    /**
     * Connecte un client de la base de données.
     *
     * @param login Le login du client.
     * @param mdp Le mot de passe du client.
     * @return Le numéro du client recherché et trouvé, sinon -1.
     */
    public int connecterClient(String login, String mdp) {
        int numConnexion = -1;
        for (Map.Entry<Integer, Client> entry : listeClient.entrySet()) {
            Integer numClient = entry.getKey();
            Client client = entry.getValue();
            if (client.selectionnerProfil(login, mdp)) {
                client.connecterProfil();
                numConnexion = numClient;
            }
         }
         return numConnexion;
    }
	
    /**
     * Retourne un client en fonction du numéro passé en paramètre.
     *
     * @param numeroClient Numéro du client enregistrer dans la base de données.
     * @return Le client correspondant au numéro de client passé en paramètre.
     */
    public Client selectionnerClient(int numeroClient) {
        return listeClient.get((Integer)numeroClient);
    }

    /**
     * @return La chaine de caractère de l'entité BDClient.
     */
    public String toString() {
        return "BDClient [listeClient=" + listeClient + "]";
    }
    
}
