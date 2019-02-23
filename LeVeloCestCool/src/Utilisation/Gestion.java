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
                    menuAbonne(a);
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
                                menuGestionnaire((Gestionnaire)m);
                            }
                            else
                            {
                                menuTechnicien((Technicien)m);
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
    accueil();
    
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
                modifierCompteAbonne(a);
                menuAbonne(a);
                break;
            case 2:
                //supprimerCompteAbonne(a);
                menuAbonne(a);
                break;
            case 3:
                //créerLocation();
                menuAbonne(a);
                break;
            case 4:
                //modifierLocation();
                menuAbonne(a);
                break;
            default: accueil();
        }
        
    }
    
    public void modifierCompteAbonne(Abonne a){
    String mp="";
    String nom="";
    String prenom="";
    String adresse="";
    String email="";
    String telephone="";

    Date dateDebutAbonnement = null;
    int choix;
        
        System.out.println("Entre votre choix:");
        System.out.println("1: modifier le mot de passe");
        System.out.println("2: Changer le nom");
        System.out.println("3: Changer le prenom");
        System.out.println("4: Changer l'adresse");
        System.out.println("5: Changer l'email");
        System.out.println("6 Changer le telehpone");
        System.out.println("7 Changer la date");
        choix = Clavier.lireInt();
        
        switch(choix){
            case 1 :
                System.out.println("Votre nouveau mot de passe");
                mp = Clavier.lireString();
               
                break;
                
            case 2:
                System.out.println("Votre nouveau nom");
                nom = Clavier.lireString();
                break;
                
            case 3:
                System.out.println("Votre nouveau prenom");
                prenom = Clavier.lireString();
                break;
                
            case 4:
                System.out.println("Votre nouvelle adresse");
                adresse = Clavier.lireString();
                break;
                
            case 5:
                System.out.println("Votre nouveau email");
                email = Clavier.lireString();
                break;
            case 6:
                System.out.println("Votre nouveau numéro de téléphone");
                telephone = Clavier.lireString();
                break;
                
            case 7:
                System.out.println("Votre nouvelle date");
                System.out.println("Jour");
                int jour = Clavier.lireInt();
                System.out.println("Mois");
                int mois = Clavier.lireInt();
                System.out.println("Annee");
                int annee = Clavier.lireInt();
                dateDebutAbonnement = new Date(annee- 1900,mois-1,jour);
                
                break;
                
            
        }
        if(ga.modifierAbonne(a,choix,mp,nom,prenom,adresse,email,telephone,dateDebutAbonnement)){
            System.out.println("modification effectuée");
        }
    }

    
    
    public void menuGestionnaire(Gestionnaire m)
    {
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: Contacter abonnés avec une location en retard");
        System.out.println("2: Rappel d'expiration de la location aux Abonnés");
        System.out.println("3: Afficher la liste de vélo à envoyer en réparation");
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                //abonneRetard();
                menuGestionnaire(m);
                break;
            case 2:
                //abonneRappelExpiration();
                menuGestionnaire(m);
                break;
            case 3:
                //afficherVeloReparation();
                menuGestionnaire(m);
                break;
        }
        
    }
    
    public void abonneRetard(){
        ArrayList<Location>listeLocation = ga.getListeLocation();
        ArrayList<Abonne>listeAbonne;
        int i = 0;
        
        listeAbonne = gg.abonneRetard(listeLocation);
        if (!listeAbonne.isEmpty()){
            for(i=0;i<listeAbonne.size();i++ ){
                ga.rechercheAbonne(listeAbonne.get(i).getLogin()).setMessage("Votre location à expiré, vous êtes priez de rendre votre vélo");
                System.out.println(listeAbonne.get(i).getInfo());
            }
        }
        else{
            System.out.println("Pas de locations en retard");
        }
        
    }
    
    public void abonneRappelExpiration(){
        ArrayList<Location>listeLocation = ga.getListeLocation();
        
        listeLocation = gg.rappelAbonne(listeLocation);
        
        ga.setListeLocation(listeLocation);
        System.out.println("Le message de rappel à été envoyé aux abonnés");
    }
    
    public void afficherVeloReparation(){
        ArrayList<Velo>listeVeloMauvaisEtat = gt.getListeVelo(); 
        ArrayList<EtatVelo>listeEtatVelo = gt.getListeEtatVelo();
        Technicien t =null;
        int i;
        
        listeVeloMauvaisEtat = gg.RechercheVeloMauvaisEtat(listeVeloMauvaisEtat, listeEtatVelo);
        if(!listeVeloMauvaisEtat.isEmpty()){
            for(i = 0;i<listeVeloMauvaisEtat.size();i++){
                System.out.println("Velo en mauvais état :"+listeVeloMauvaisEtat.get(i).getInfo());
            }

            i = 0;

            while(i<gg.getListeMembreSociete().size()&& t==null){
                if (gg.getListeMembreSociete().get(i) instanceof Technicien){
                    t = (Technicien)gg.getListeMembreSociete().get(i);
                    t.setListeVeloMauvaisEtat(listeVeloMauvaisEtat);
                }
                i++;
            }
        }
    }
    
    public void menuTechnicien(Technicien t)
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
                menuTechnicien(t);
                break;
            case 2:
                //modifierBorne();
                menuTechnicien(t);
                break;
            case 3:
                //supprimerBorne();
                menuTechnicien(t);
                break;
            case 4:
                //creerVelo();
                menuTechnicien(t);
                break;
            case 5:
                //modifierVelo();
                menuTechnicien(t);
                break;
            case 6:
                //supprimerVelo();
                menuTechnicien(t);
                break;
            case 7:
                //creerReparation();
                menuTechnicien(t);
                break;
            case 8:
                //modifierReparation();
                menuTechnicien(t);
                break;
            case 9:
                //modifierBorneVelo();
                menuTechnicien(t);
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
        
    
    
    public void menuBorne(Technicien t){
    int n;
    System.out.println("Que voulez vous faire?");
    System.out.println("Créer une nouvelle borne");
    System.out.println("Modifier une borne");
    System.out.println("Supprimer une borne");

    n=Clavier.lireInt();

    switch (n){

        case 1 :
            //creerBorne();
            menuBorne(t);
            break;


        case 2:
            //modifierBorne();
            menuBorne(t);
            break;


        case 3 :
            //supprimerBorne();
            menuBorne(t);
            break;



        default :
            menuTechnicien(t);        
    }
    
    }
    
    public Borne creerBorne(){
        Borne b;
        String adresse;
        int placemax;
        
        System.out.println("Rentrez l'adresse de la borne");
        adresse=Clavier.lireString();
        System.out.println("Rentrez le nombre de place maximum pour cette nouvelle borne");
        placemax=Clavier.lireInt();
        
        b=gt.creerBorne(adresse, placemax);
        
        return b;
    }
    
    
    public void modifierBorne(){
        int choix, id, nbplace=0;
        ArrayList<Velo>listeVeloBorne;
        
        System.out.println("Entre l'identifiant de la borne à modifier");
        id = Clavier.lireInt();
        listeVeloBorne=gt.listeVeloBorne(id);
        
        System.out.println("Entre votre choix:");
        System.out.println("1: Ajouter des places disponibles à la borne");
        System.out.println("2: Diminuer le nombre de place disponible");
        choix=Clavier.lireInt();
        
        switch(choix){
            
            case 1:
                System.out.println("Entrez le nombre de place à ajouter ");
                nbplace=Clavier.lireInt();
                break;
                
            
            case 2 :
                do{
                   System.out.println("Nombre de place à retirer");
                    nbplace=Clavier.lireInt();
                
                    if(listeVeloBorne.get(0).getBorne().getPlaceMax()-nbplace <listeVeloBorne.size()){
                        System.out.println("Impossible de retirer ce nombre de place car trop de vélo sont attachés à cette borne");
                    }
                    
                }while(listeVeloBorne.get(0).getBorne().getPlaceMax()-nbplace <listeVeloBorne.size());
                break;
        }
        
        if(gt.modifierBorne(id, choix, nbplace)){
            System.out.println("Modification effectuée");
        }

    }
    

    public void supprimerBorne(){
        int id;
        int i = 0;
        
        System.out.print("Saisir l'id de la borne à détruire");
        id = Clavier.lireInt();
        
        if(gt.supprimerBorne(id).isEmpty()){
            System.out.print("Suppression effectuée");
        }
        else{
            System.out.println("Le(s) vélo(s) suivant est(sont) encore attaché(s) à la borne, veuillez les détacher :");
            for(i=0;i<gt.supprimerBorne(id).size();i++){
                System.out.println("id : " +gt.supprimerBorne(id).get(i).getId());
            }
        }
    }


    public void menuVelo(Technicien t){
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
            menuVelo(t);
            break;


        case 2:
            modifierVelo();
            menuVelo(t);
            break;


        case 3 :
            supprimerVelo();
            menuVelo(t);
            break;



        default :
            menuTechnicien(t);        
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

