/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisation;

import Source.Abonne;
import Source.Clavier;
import java.util.Date;

/**
 *
 * @author GREGO
 */
public class GestionMenuAbonne {
    private GestionAbonne ga;
    
    
    public GestionMenuAbonne(){
        ga =new GestionAbonne();
    }

    public GestionAbonne getGa() {
        return ga;
    }

    public void setGa(GestionAbonne ga) {
        this.ga = ga;
    }
    
    public void menuAbonne(Abonne a)
    {
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: Modifier compte");
        System.out.println("2: Supprimer compte");
        System.out.println("3: Créer location");
        System.out.println("4: Modifier location");
        System.out.println("Autre: retour à l'accueil");
        System.out.println("Message :\n" + a.getMessage());
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                //modifierCompteAbonne(a);
                menuAbonne(a);
                break;
            case 2:
                //supprimerCompteAbonne(a);
                //accueil();
                break;
            case 3:
                //creerLocation(a);
                menuAbonne(a);
                break;
            case 4:
                //modifierLocation(a);
                menuAbonne(a);
                break;
            default: //accueil();
        }
        
    }
    
    public void creerCompteAbonne(){
        String lg;
        String mp;
        String nom;
        String prenom;
        String adresse;
        String email;
        String telephone;
        Date dateDebutAbonnement = new Date();
        String confirmation="";
        
        
        do
        {
            System.out.println("Login ?");
            lg = verificationLoginAbonne();
            System.out.println("Mot de passe ?");
            mp = Clavier.lireString();
            System.out.println("Nom ?");
            nom = Clavier.lireString();
            System.out.println("Prénom?");
            prenom = Clavier.lireString();
            System.out.println("Adresse?");
            adresse = Clavier.lireString();
            System.out.println("Email? ");
            email = Clavier.lireString();
            System.out.println("Téléphone ?");
            telephone = Clavier.lireString();

            System.out.println("Récapitulatif: " + "\nLogin: " + lg + "\nMot de passe: " + mp +"\nNom: " + nom + "\nPrénom: " + prenom + "\nAdresse: " + adresse +"\nEmail: " + email +"\nTéléphone: " + telephone + "\nDate: "+ dateDebutAbonnement);
            System.out.println("1: Confirmer, Autre: Recommencer la saisie");
            confirmation = Clavier.lireString();
        }while(!confirmation.equals("1"));
        
        ga.creerAbonne(lg,mp, nom, prenom, adresse, email, telephone, dateDebutAbonnement);
        if (!ga.getListeAbonne().isEmpty()){
            System.out.println("Profil abonné créé");
        }        
        System.out.println("Profil abonné créé");
    }
    
    public String verificationLoginAbonne()
    {
     
    String lg;
    Abonne a;
    boolean lgUnique ;
    
    do
    {   
        System.out.println("Entrez le login de l'abonné");
        lg = Clavier.lireString();
        a = rechercheAbonne(lg);
        lgUnique= true;
        if (a != null)
        {
            lgUnique=false;
            System.out.println("Login déjà pris, changez votre login");
        }
        
    }while(lgUnique == false);

    return lg;
    }
    public Abonne rechercheAbonne(String lg)
    {
        Abonne a = null;
        
        a = ga.rechercheAbonne(lg);
        if (a==null)
        {
            System.out.println("Abonne non trouvé");
        }
        return a;
    }
    
}
