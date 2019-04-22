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
     Technicien t = null;
     Gestionnaire g = null;
     
     
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
                if (a.getMp().equals(mp) && ga.validiteDateAbonne(a)) 
                {
                    menuAbonne(a);
                    
                } 
                else{
                    if(ga.validiteDateAbonne(a))
                    {
                        System.out.println("Mauvais mot de passe");
                    }
                    else{
                        //menuAbonneR(a);
                    }
                }
                    
            }while(!a.getMp().equals(mp));  
          }
          else{ System.out.println("Abonné non trouvé");
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
                                g= (Gestionnaire)m;
                                menuGestionnaire(g);
                                System.out.println("Gestion");
                            }
                            else
                            {
                                t =(Technicien)m;
                                menuTechnicien(t);
                                System.out.println("Technicien");
                            }
                        } 
                        else
                        {
                            System.out.println("Mauvais mot de passe");
                        }
                    }while(!m.getMp().equals(mp));
                }
                 else{
                        System.out.println("wut");    
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
                supprimerCompteAbonne(a);
                accueil();
                break;
            case 3:
                creerLocation(a);
                menuAbonne(a);
                break;
            case 4:
                modifierLocation(a);
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

    public void supprimerCompteAbonne(Abonne a){
        
        if(ga.supprimerAbonne(a)){
            System.out.print("Suppression effectuée");
        }
    }
    
    public Location creerLocation(Abonne a){
        Location l= null;
        Date d=new Date();
        Velo v=null;
        int id;
        ArrayList<StatutVelo> listeStatutVelo = gt.getListeStatutVelo();
        
        
        for (int i = 0; i<gt.afficherVeloDisponible().size();i++){
            System.out.println(gt.afficherVeloDisponible().get(i).getInfo());
        }
        System.out.println("Selectionnez le vélo en tappant l'id de votre choix");
        id = Clavier.lireInt();
        
        v= gt.rechercheVelo(id);
        l = ga.creerLocation(d, a, v, listeStatutVelo);
        
        System.out.println(l.getInfo());
        return l;
    }
    
    public void modifierLocation(Abonne a){
        Location l = ga.rechercheLocationAbonne(a);
        Date d = new Date();
        int ide;
        EtatVelo e;
        boolean run;
        int idv;
        
        idv=l.getVelo().getId();
        transfererBorneVelo(idv);        
        afficherListeEtatVeloM();
        System.out.println("Selectionnez l'état du vélo");
        ide = Clavier.lireInt();
        e = gt.rechercheEtatVelo(ide);
        run = gt.modifierVelo(l.getVelo().getId(), 2, null, e , null, null);
        run = gt.modifierVelo(l.getVelo().getId(), 3, null, null , gt.getListeStatutVelo().get(3), null); 
        ga.getListeLocation().get(l.getId()).setDateFin(d);
        
        System.out.print("Location finie");
 
    }
    
    public void menuGestionnaire(Gestionnaire m){
        int choix;
        
        System.out.println("Choisissez votre option:");
        System.out.println("1: Contacter abonnés avec une location en retard");
        System.out.println("2: Rappel d'expiration de la location aux Abonnés");
        System.out.println("3: Afficher la liste de vélo à envoyer en réparation");
        choix = Clavier.lireInt();
        
        switch (choix)
        {
            case 1:
                abonneRetard();
                menuGestionnaire(m);
                break;
            case 2:
                abonneRappelExpiration();
                menuGestionnaire(m);
                break;
            case 3:
                afficherVeloReparation();
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
        System.out.println("Le message de rappel a été envoyé aux abonnés");
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
                creerBorne();
                menuTechnicien(t);
                break;
            case 2:
                modifierBorne();
                menuTechnicien(t);
                break;
            case 3:
                supprimerBorne();
                menuTechnicien(t);
                break;
            case 4:
                creerVelo();
                menuTechnicien(t);
                break;
            case 5:
                modifierVelo();
                menuTechnicien(t);
                break;
            case 6:
                supprimerVelo();
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
    
     public void afficherListeTypeReparation(){
        ArrayList<TypeReparation>rechercheListeTypeReparation=gt.rechercheListeTypeReparation();
        int i=0;
        
        for (i=0;i<rechercheListeTypeReparation.size();i++){
            i++;
            System.out.println(i + " : "+ rechercheListeTypeReparation.get(i-1).getType());
            i--;
        }
      } 

    public void creerFicheReparation (Technicien t) {
     int id, jour, mois, annee,idTypeReparation;
     Date d;
     Double pr;
     String p;
     TypeReparation tr;
     Velo v=null;
     
     
       System.out.println("Veuillez rentrer la date de récuperation du velo:");
        System.out.println("Quel jour?");
        jour = Clavier.lireInt();
        System.out.println("Quel mois ?");
        mois = Clavier.lireInt();
        System.out.println("Quelle année?");
        annee = Clavier.lireInt();
        
        d = new Date(annee - 1900, mois-1, jour);
        
     do
        {
            System.out.println("Entrez l'id du vélo à envoyer en réparation ?");
            id = Clavier.lireInt();
            
            v=gt.rechercheVelo(id);
            
            if(v==null){
             System.out.println("Vélo introuvable");  
             }  
                
          }while(v==null);
     
          System.out.println("Entrez le problème :");
          p=Clavier.lireString();
          
          
     do{
            afficherListeTypeReparation();
            System.out.println("Choisissez votre option");
            idTypeReparation = Clavier.lireInt()-1;
            if (idTypeReparation<0 || idTypeReparation>(gt.rechercheListeTypeReparation().size()-1)){
                System.out.println("Veuillez rentrer un nombre disponible");
            }
        }while(idTypeReparation<0 || idTypeReparation>(gt.rechercheListeTypeReparation().size()-1));
        
        tr = gt.rechercheTypeReparation(idTypeReparation);
        
        
            System.out.println("Entrez le prix de la réparation");
            pr = Clavier.lireDouble();
            
         gt.creerFicheReparation(d, pr, p, tr, v, t);
    }

public void finaliserFicheReparation(){
    int id;
    
    
    System.out.println("Entre l'id du vélo concerné ");
    id=Clavier.lireInt();
    
    if(gt.finaliserFicheReparation(id)){
        System.out.println("Fiche réparation close à la date du jour");
    }
    else{
        System.out.println("Pas de fiche de réparation concernant ce vélo");
    }
    
    transfererBorneVelo(id);
}

public void transfererBorneVelo(){
    int idv,idb;
    Velo v;
    Borne b;
 
    
    do{
         System.out.println("Entre l'id du vélo concerné ");
        idv=Clavier.lireInt();
    
        v=gt.rechercheVelo(idv); 
        if(v==null){
            System.out.println("Vélo introuvable");
            }
    } while (v==null);
    
    do{
             System.out.println("Entre l'id de la borne concernée ");
            idb=Clavier.lireInt();
    
            b=gt.rechercheBorne(idb); 
            if(v==null){
                    System.out.println("Borne introuvable");
                    }
    } while (v==null);
  
    if(gt.deposerVelo(v, b)){
            System.out.println("Vélo transferer à la borne "+ b.getId()+ "se situant à l'adresse : "+ b.getAdresse());
        }
    else {
             System.out.println("Nombre de place insuffisante à la borne");
            }
    
}
public void transfererBorneVelo(int id){
    Velo v;
    Borne b;
    int idb;
    
         v=gt.rechercheVelo(id); 
         
        do{
                 System.out.println("Entre l'id de la borne concernée ");
                 idb=Clavier.lireInt();
    
                b=gt.rechercheBorne(idb); 
                if(b==null){
                    System.out.println("Borne introuvable");
                    }
        } while (b==null);
        
     if(gt.deposerVelo(v, b)){
            System.out.println("Vélo transferer à la borne "+ b.getId()+ "se situant à l'adresse : "+ b.getAdresse());
        }  
     else {
             System.out.println("Nombre de place insuffisante à la borne");
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
            creerBorne();
            menuBorne(t);
            break;

        case 2:
            modifierBorne();
            menuBorne(t);
            break;

        case 3 :
            supprimerBorne();
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
            System.out.println(i + " : "+ rechercheListeEtatVelo.get(i-1).getEtat());
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
    
public void  initialisation(){
    
    Gestionnaire g;
    Technicien t;
    int n =2;
    String x;
    ArrayList<Borne>initialisationB= new ArrayList();
    Borne b;
    
    TypeReparation tr;
    ArrayList<Velo>initialisationV= new ArrayList();
    Velo v;
    EtatVelo e;
    StatutVelo s;
    int i = 0;
    
    for (i=0; i< n; i++){
        x =i+ "Luix";
        g = new Gestionnaire(x, x, "Jean "+x, "Roger "+x, new Date());
        gg.getListeMembreSociete().add(g);
        System.out.println("Profil Gestionnaire : " + g.getInfos() + "Id & mp: " + x + "\n");
    }
    System.out.println("---------------- Gestionnaires initialisés ---------------");
    i = 0;
    for (i=0; i< n; i++){
        x =i+ "Lui";
        t = new Technicien(x, x, "Michel "+x, "Patrick "+x, new Date());
        gg.getListeMembreSociete().add(t);
        System.out.println("Profil Technicien : " + t.getInfos()+ "Id & mp: " + x + "\n");
    }
    
    
    System.out.println("---------------- Techniciens initialisés ---------------");
    
    n = 4;
    i = 0;
    
    for (i=0; i< n-1; i++){
        x = "3" + i+ "rue Enrouée";
        i++;
        b = new Borne(x, i);
        initialisationB.add(b);
        System.out.println("Borne : " + b.getInfo() + "\n");
        i--;
    }
    gt.setListeBorne(initialisationB);
    System.out.println("---------------- Bornes initialisés ---------------");
   
    i = 0;
    
    for (i=0; i< n; i++){
        x = "Réparation de la visse n°"+ i;
        
        tr = new TypeReparation(x);
        gt.getListeTypeReparation().add(tr);
        System.out.println("Type de réparation : " + tr.getId() + "\n");
        
    }
    
    System.out.println("---------------- Types de réparations initialisés ---------------");
    
    
    e = new EtatVelo("Mauvais");
    gt.getListeEtatVelo().add(e);
    System.out.println("Etat:" + e.getEtat() + " ID:"+ e.getId());
    e = new EtatVelo("Moyen");
    gt.getListeEtatVelo().add(e);
    System.out.println("Etat:" + e.getEtat() + " ID:"+ e.getId());
    e = new EtatVelo("Bon");
    gt.getListeEtatVelo().add(e);
    System.out.println("Etat:" + e.getEtat() + " ID:"+ e.getId());
    System.out.println("---------------- Etats de vélo initialisés ---------------");
    
    s = new StatutVelo("En cours de location");
    gt.getListeStatutVelo().add(s);
    System.out.println("Statut:" + s.getStatut() + " ID:"+ s.getId());
    s = new StatutVelo("En cours de réparation");
    gt.getListeStatutVelo().add(s);
    System.out.println("Statut:" + s.getStatut() + " ID:"+ s.getId());
    s = new StatutVelo("Détruit");
    gt.getListeStatutVelo().add(s);
    System.out.println("Statut:" + s.getStatut() + " ID:"+ s.getId());
    s = new StatutVelo("Disponible");
    gt.getListeStatutVelo().add(s);
    System.out.println("Statut:" + s.getStatut() + " ID:"+ s.getId());
    System.out.println("---------------- Statuts de vélo initialisés ---------------");
    
    
    n = (gt.getListeEtatVelo().size()-1)*(gt.getListeStatutVelo().size()-1)+1;
    int u = 0;
    i = 0;
    
    for (i=0; u*i< n; i++){
        v = new Velo(new Date(),gt.getListeEtatVelo().get(i), gt.getListeStatutVelo().get(u));
        initialisationV.add(v);
        System.out.println("Velo : " + v.getInfo() + "\n");
        
        if ((i*u<n-1)&&(i == gt.getListeEtatVelo().size()-1)){u++;i=-1;}
    }
    gt.setListeVelo(initialisationV);
    System.out.println("---------------- Vélos initialisés ---------------");
    
    
}
   
}

