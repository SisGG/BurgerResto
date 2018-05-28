package vue;

import control.ControlAjouterAlimentMenu;

/**
 * 
 * @author LAPEYRADE Sylvain
 * @author OLIVIER Thomas
 *
 */
public class BoundaryAjouterAlimentMenu {
	
	/**
	 * @see control.ControlAjouterAlimentMenu
	 */
    private ControlAjouterAlimentMenu controlAjouterAlimentMenu;
    /**
     * @see vue.Clavier
     */
    private Clavier clavier = new Clavier();

    /**
     * Constructeur BoundaryAjouterAlimentMenu.
     *
     * @param controlAjouterAlimentMenu Controleur pour ajouter un aliment au menu.
     */
    public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
        this.controlAjouterAlimentMenu = controlAjouterAlimentMenu;
    }

    /**
     * Ajoute un aliment au menu.
     *
     * @param numProfil Numéro de profil de l'utilisateur ajoutant l'aliment.
     */
    public void ajouterAlimentMenu(int numProfil) {
        boolean entreeCorrect = false;
        int choix = 0;
        String nom;
        
        boolean identificationOk = controlAjouterAlimentMenu
        		.verifierIdentification(numProfil);
        if ( identificationOk ) {
        	do {
                System.out.println("Que voulez-vous ajouter en aliment ? ");
                System.out.println("Tapez 1 pour un Hamburger.");
                System.out.println("Tapez 2 pour un Accompagnement.");
                System.out.println("Tapez 3 pour une Boisson.");
                System.out.print("Votre choix : ");
                choix = clavier.entrerClavierInt();
                entreeCorrect = choix == 1 || choix == 2 || choix == 3;
                if ( !entreeCorrect )
                    System.out.println("Veuillez entrer 1, 2 ou 3");
            } while(!entreeCorrect);
            System.out.print("Veuillez entrer le nom de l'aliment : ");
            nom = clavier.entrerClavierString();
            switch(choix) {
                case 1:
                    controlAjouterAlimentMenu.ajouterHamburger(nom);
                    break;
                case 2:
                    controlAjouterAlimentMenu.ajouterAccompagnement(nom);
                    break;
                case 3:
                    controlAjouterAlimentMenu.ajouterBoisson(nom);
                    break;
                default:
                    System.out.println("Type d'aliment non reconnu.");    
            }
        }
    }

}
