/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisation;
import Source.*;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author GREGO
 */
public class Gestion {
    
    private ArrayList<Abonne>listeAbonne;
    private ArrayList<Velo>listeVelo;
    private ArrayList<Borne>listeBorne;
    private ArrayList<EtatVelo>listeEtatVelo;
    private ArrayList<FicheReparation>listeFicheReparation;
    private ArrayList<Location>listeLocation;
    private ArrayList<MembreSociete>listeMembreSociete;
    private ArrayList<StatutVelo>listeStatutVelo;
    private ArrayList<TypeReparation>listeTypeReparation;

    
    public Gestion()
    {
    listeAbonne = new ArrayList();
    listeVelo= new ArrayList();
    listeBorne= new ArrayList();
    listeEtatVelo= new ArrayList();
    listeFicheReparation= new ArrayList();
    listeLocation= new ArrayList();
    listeMembreSociete= new ArrayList();
    listeStatutVelo= new ArrayList();
    listeTypeReparation= new ArrayList();
    }
            
    public void accueil()
    {
        int choix;
        
        
        
        System.out.println("Choisissez votre option");
        System.out.println("1: Se connecter");
        System.out.println("2: Créer un compte");
        System.out.println("Autre  Quitter");
        choix = Clavier.lireInt();
        
        switch(choix)
        {
            case 1 :
                connecter();
                break;
                
            case 2 :
                creerCompteAbonne();
                accueil();
                break;
                
            default:
                System.out.println("Au revoir");
                break;
                
        }
    }
    public void connecter()
    {
     String choix;
     String lg;
     String mp;
     Abonne a= null;
     MembreSociete m = null;
     
     do{
     System.out.println("1: Abonné, 2: Membre de la société");
     choix = Clavier.lireString();
         if (!choix.equals("1")&&!choix.equals("2"))
         {
             System.out.println("Erreur de saisie, veuillez recommencer");
         }
     }while(!(choix.equals("1") || choix.equals("2")));
     
     System.out.println("Saisissez votre login");
     lg = saisieLogin();
     System.out.println("Saisissez votre mot de passe");
     mp = Clavier.lireString();
     
     if (choix.equals("1"))
         {
          a = rechercheAbonne(lg);
          if(a!=null)
          {
            do{
                if (a.getMp().equals(mp)) 
                {
                    menuAbonne();
                } 
                else
                {
                    System.out.println("Mauvais mot de passe");
                }
            }while(!a.getMp().equals(mp));  
          } 
         }
         else
         {
             if(choix.equals("2"))
             {
                 rechercheMembreSociete(lg);
                 if(m!=null)
                {
                    do{
                        if (m.getMp().equals(mp)) 
                        {
                            if (m instanceof Gestionnaire)
                            {
                                menuGestionnaire();
                            }
                            else
                            {
                                menuTechnicien();
                            }
                        } 
                        else
                        {
                            System.out.println("Mauvais mot de passe");
                        }
                    }while(!m.getMp().equals(mp));          
                } 
             }
         }
     
    }
    
    public void menuAbonne()
    {
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: Modifier compte");
        System.out.println("2: Supprimer compte");
        System.out.println("3: Créer location");
        System.out.println("4: Modifier location");
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                //modifierCompteAbonne();
                menuAbonne();
                break;
            case 2:
                //supprimerCompteAbonne();
                menuAbonne();
                break;
            case 3:
                //créerLocation();
                menuAbonne();
                break;
            case 4:
                //modifierLocation();
                menuAbonne();
                break;
        }
        
    }
    public void menuGestionnaire()
    {
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: afficher Abonné");
        System.out.println("2: message Abonné");
        System.out.println("3: Afficher la liste de vélo à envoyer en réparation");
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                //afficherAbonne();
                menuGestionnaire();
                break;
            case 2:
                //messageAbonne();
                menuGestionnaire();
                break;
            case 3:
                //afficherVeloReparation();
                menuGestionnaire();
                break;
        }
        
    }
    
    public void menuTechnicien()
    {
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: Créer Borner");
        System.out.println("2: Modifier Borne");
        System.out.println("3: Supprimer Borne");
        System.out.println("4: Créer Vélo");
        System.out.println("5: Modifier Vélo");
        System.out.println("6: Supprimer Vélo");
        System.out.println("7: Créer une réparation");
        System.out.println("8: Modifier une réparation");
        System.out.println("9: Modifier la borne d'un vélo");
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                //creerBorne();
                menuTechnicien();
                break;
            case 2:
                //modifierBorne();
                menuTechnicien();
                break;
            case 3:
                //supprimerBorne();
                menuTechnicien();
                break;
            case 4:
                //creerVelo();
                menuTechnicien();
                break;
            case 5:
                //modifierVelo();
                menuTechnicien();
                break;
            case 6:
                //supprimerVelo();
                menuTechnicien();
                break;
            case 7:
                //creerReparation();
                menuTechnicien();
                break;
            case 8:
                //modifierReparation();
                menuTechnicien();
                break;
            case 9:
                //modifierBorneVelo();
                menuTechnicien();
                break;
            
        }
        
    }
    
    public void creerCompteAbonne()
    {
        Abonne a;
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
        
        a = new Abonne(lg,mp, nom, prenom, adresse, email, telephone, dateDebutAbonnement);
        listeAbonne.add(a);
        
        System.out.println("Profil abonné créé");
    }
    
    public String verificationLoginAbonne()
    {// modifier pour inclure la recherche
     
    String lg;
    Abonne a;
    boolean lgUnique ;
    
    do
    {
        lg = saisieLogin();
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
    public String saisieLogin()
    {
        String lg= null;
        lg = Clavier.lireString();
        return lg;
    }
    public Abonne rechercheAbonne(String lg)
    {
        Abonne a = null;
        int i=0;
        
        if(!listeAbonne.isEmpty())
        {
            while(i<listeAbonne.size() && a ==null)
            {
                if(listeAbonne.get(i).getLogin().equals(lg))
                {
                    a = listeAbonne.get(i);
                }
                i++;
            }
        }
        if (a==null)
        {
            System.out.println("Abonne non trouvé");
        }
        return a;
    }
public MembreSociete rechercheMembreSociete(String lg)
    {
        MembreSociete m = null;
        int i=0;
        
        if(!listeMembreSociete.isEmpty())
        {
            while(i<listeMembreSociete.size() && m ==null)
            {
                if(listeMembreSociete.get(i).getLogin().equals(lg))
                {
                    m = listeMembreSociete.get(i);
                }
                i++;
            }
        }
        if (m==null)
        {
            System.out.println("Membre non trouvé");
        }
        return m;
    } 
        
    
    public void initialisation()
    {
     initialiseTechnicien(); 
     initialiseTest();
    }
    
    public void initialiseTechnicien()
    {
        String log = null;
        String mp = null;
        String prenom = null;
        String nom = null;
        Date date = new Date(1600-1900, 10-1, 10);
        
        Technicien t = new Technicien(log,mp, prenom, nom, date);
        listeMembreSociete.add(t);        
    }
    
    public void initialiseTest() 
    {

    }
    public void menuBorne(){
    int n;
    System.out.println("Que voulez vous faire?");
    System.out.println("Créer une nouvelle borne");
    System.out.println("Modifier une borne");
    System.out.println("Supprimer une borne");

    n=Clavier.lireInt();

    switch (n){

        case 1 :
            //creerBorne();
            menuBorne();
            break;


        case 2:
            //modifierBorne();
            menuBorne();
            break;


        case 3 :
            //supprimerBorne();
            menuBorne();
            break;



        default :
            menuTechnicien();        
    }
    }
    public void menuVelo(){
    int n;
    System.out.println("Que voulez vous faire?");
    System.out.println("Créer un vélo");
    System.out.println("Modifier un vélo ");
    System.out.println("Supprimer un vélo");

    n=Clavier.lireInt();

    switch (n){

        case 1 :
            //creerVelo();
            menuVelo();
            break;


        case 2:
            //modifierVelo();
            menuVelo();
            break;


        case 3 :
            supprimerVelo();
            menuVelo();
            break;



        default :
            menuGestionnaire();        
    }
    }



    public Borne CreerBorne()
    {
    Borne b;    
    int id, i;
    String adresse;
    int placeMax;


    System.out.println("Adresse de la borne: ");
    adresse=Clavier.lireString();
    System.out.println ("Nombre de place max: ");
    placeMax=Clavier.lireInt();
    b= new Borne (adresse,placeMax);
    listeBorne.add(b);
    return b;
    }

    public Borne RechercheBorne()
    {
    Borne b, trouve=null;
    int id;
    int i=0;
    System.out.println("id de la borne: ");
    id=Clavier.lireInt();
    if (!listeBorne.isEmpty()){
    while (i<listeBorne.size()&&trouve==null)
    {
    b=listeBorne.get(i);
    if(b.getId()== id)
    {
    trouve=b;
    }
    }
    }
    return trouve;
    }



    public void supprimerVelo(){

        int id;
        Velo v=null;
        int i=0;
        boolean trouve=false;

        System.out.println("ID du vélo que vous souhaitez supprimer");
        id=Clavier.lireInt();

        if(!listeVelo.isEmpty()){
        do{
        if(id==listeVelo.get(i).getId())
        {
            v=listeVelo.get(i);
            trouve=true;
        }  

        i++;



        }while(trouve==false && i<listeVelo.size());

        if(trouve==false)
        {
        System.out.println("Désolé ID Vélo introuvable");
        }

        v.setStatut(listeStatutVelo.get(2));//ajouter en 3e position la destruction
    }
    }

    }

