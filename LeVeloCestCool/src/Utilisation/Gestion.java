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
    private GestionAbonne ga;
    private GestionTechnicien gt;
    private GestionGestionnaire gg;
    
    public Gestion()
    {
    ga = new GestionAbonne();
    gt = new GestionTechnicien();
    gg = new GestionGestionnaire();
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
     lg = Clavier.lireString();
     System.out.println("Saisissez votre mot de passe");
     mp = Clavier.lireString();
     
     if (choix.equals("1"))
         {
          a = ga.rechercheAbonne(lg);
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
                 m = gg.rechercheMembreSociete(lg);
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
        System.out.println("Autre: retour à l'accueil");
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
            default: accueil();
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
    
    
    public MembreSociete rechercheMembreSociete(String lg)
    {
        MembreSociete m = null;
        
        m = gg.rechercheMembreSociete(lg);
        
        if (m==null)
        {
            System.out.println("Membre non trouvé");
        }
        return m;
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
    System.out.println("1: Créer un vélo");
    System.out.println("2: Modifier un vélo ");
    System.out.println("3: Supprimer un vélo");
    System.out.println("Autre: retour au menu précédent");

    n=Clavier.lireInt();

    switch (n){

        case 1 :
            creerVelo();
            menuVelo();
            break;


        case 2:
            modifierVelo();
            menuVelo();
            break;


        case 3 :
            supprimerVelo();
            menuVelo();
            break;



        default :
            menuTechnicien();        
    }
    }
    
    public void supprimerVelo(){
        int id;
        
        System.out.print("Saisir l'id du vélo à détruire");
        id = Clavier.lireInt();
        
        if(gt.supprimerVelo(id)){
            System.out.print("Suppression effectuée");
        }
    }

    public void creerVelo(){
        Velo v= null;
        Date d;
        int jour;
        int mois;
        int annee;
        EtatVelo e = null;
        StatutVelo s = null;
        Borne b ;
        int idStatutVelo = -1;
        int idEtatVelo = -1;
        int idBorne = -1;
        
        
        System.out.println("Veuillez rentrer la date de création de velo:");
        System.out.println("Quel jour?");
        jour = Clavier.lireInt();
        System.out.println("Quel mois ?");
        mois = Clavier.lireInt();
        System.out.println("Quelle année?");
        annee = Clavier.lireInt();
        
        d = new Date(annee - 1900, mois-1, jour);
        
        do{
            afficherListeStatutVeloM();
            System.out.println("Choisissez votre option");
            idStatutVelo = Clavier.lireInt()-1;
            if (idStatutVelo<0 || idStatutVelo>(gt.rechercheListeStatutVelo().size()-1)){
                System.out.println("Veuillez rentrer un nombre disponible");
            }
        }while(idStatutVelo<0 || idStatutVelo>(gt.rechercheListeStatutVelo().size()-1));
        
        s = gt.rechercheStatutVelo(idStatutVelo);
        
        do{
            afficherListeEtatVeloM();
            System.out.println("Choisissez votre option");
            idEtatVelo = Clavier.lireInt()-1;
            if (idEtatVelo<0 || idEtatVelo>(gt.rechercheListeEtatVelo().size()-1)){
                System.out.println("Veuillez rentrer un nombre disponible");
            }
        }while(idEtatVelo<0 || idEtatVelo>(gt.rechercheListeEtatVelo().size()-1));
        
        e = gt.rechercheEtatVelo(idEtatVelo);
        do{
            afficherListeBorneM();
            System.out.println("Choisissez votre option");
            System.out.println("0 : ne pas enregistrer la borne");
            idBorne = Clavier.lireInt()-1;
            
            if (idBorne<-1 || idBorne>(gt.rechercheListeBorne().size()-1)){
                System.out.println("Veuillez rentrer un nombre disponible");
            }
        }while(idBorne<-1 || idBorne>(gt.rechercheListeBorne().size()-1));
        
        if (idBorne == -1){
            b = null;
        }
        else{
            b= gt.rechercheBorne(idBorne);
        }
        
        v =gt.creerVelo(d, e, s, b);
        
    }
    
    public void afficherListeStatutVeloM(){
        ArrayList<StatutVelo>rechercheListeStatutVelo = gt.rechercheListeStatutVelo();
        int i = 0;
        
        for (i=0;i<rechercheListeStatutVelo.size();i++){
            i++;
            System.out.println(i + " : "+ rechercheListeStatutVelo.get(i).getStatut());
            i--;
        }
    }
    
    public void afficherListeEtatVeloM(){
        ArrayList<EtatVelo>rechercheListeEtatVelo = gt.rechercheListeEtatVelo();
        int i = 0;
        
        for (i=0;i<rechercheListeEtatVelo.size();i++){
            i++;
            System.out.println(i + " : "+ rechercheListeEtatVelo.get(i).getEtat());
            i--;
        }
    }
    
    public void afficherListeBorneM(){
        ArrayList<Borne>rechercheListeBorne = gt.rechercheListeBorne();
        int i = 0;
        
        for (i=0;i<rechercheListeBorne.size();i++){
            i++;
            System.out.println(i + " : "+ rechercheListeBorne.get(i).getInfo());
            i--;
        }
    }

    public void modifierVelo(){
        int id = 0;
        int choix= 0;
        Date d = null;
        int jour;
        int mois;
        int annee;
        EtatVelo e = null;
        StatutVelo s = null;
        Borne b = null;
        int idStatutVelo = -1;
        int idEtatVelo = -1;
        int idBorne = -1;
        
        System.out.println("Entre l'identifiant du vélo à modifier");
        id = Clavier.lireInt();
        
        System.out.println("Entre votre choix:");
        System.out.println("1: modifier la date");
        System.out.println("2: Changer l'etat du vélo");
        System.out.println("3: Changer le statut du vélo");
        System.out.println("4: Changer la borne du vélo");
        
        switch(choix){
            case 1 :
                System.out.println("Veuillez rentrer la date de création de velo:");
                System.out.println("Quel jour?");
                jour = Clavier.lireInt();
                System.out.println("Quel mois ?");
                mois = Clavier.lireInt();
                System.out.println("Quelle année?");
                annee = Clavier.lireInt();

                d = new Date(annee - 1900, mois-1, jour);
                break;
                
            case 2:
                do{
                    afficherListeStatutVeloM();
                    System.out.println("Choisissez votre option");
                    idStatutVelo = Clavier.lireInt()-1;
                    if (idStatutVelo<0 || idStatutVelo>(gt.rechercheListeStatutVelo().size()-1)){
                        System.out.println("Veuillez rentrer un nombre disponible");
                    }
                }while(idStatutVelo<0 || idStatutVelo>(gt.rechercheListeStatutVelo().size()-1));

                s = gt.rechercheStatutVelo(idStatutVelo);
                break;
                
            case 3:
                do{
                    afficherListeEtatVeloM();
                    System.out.println("Choisissez votre option");
                    idEtatVelo = Clavier.lireInt()-1;
                    if (idEtatVelo<0 || idEtatVelo>(gt.rechercheListeEtatVelo().size()-1)){
                        System.out.println("Veuillez rentrer un nombre disponible");
                    }
                }while(idEtatVelo<0 || idEtatVelo>(gt.rechercheListeEtatVelo().size()-1));

                e = gt.rechercheEtatVelo(idEtatVelo);
                break;
                
            case 4:
                do{
                    afficherListeBorneM();
                    System.out.println("Choisissez votre option");
                    System.out.println("0 : ne pas enregistrer la borne");
                    idBorne = Clavier.lireInt()-1;

                    if (idBorne<-1 || idBorne>(gt.rechercheListeBorne().size()-1)){
                        System.out.println("Veuillez rentrer un nombre disponible");
                    }
                }while(idBorne<-1 || idBorne>(gt.rechercheListeBorne().size()-1));

                if (idBorne == -1){
                    b = null;
                }
                else{
                    b= gt.rechercheBorne(idBorne);
                }
                break;
        }
        if(gt.modifierVelo(id, choix, d, e, s, b)){
            System.out.println("modification effectuée");
        }
        
        
    }
    
    
}

