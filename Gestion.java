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
                break;
                
            default:
                System.out.println("Au revoir");
                break;
                
        }
    }
    public void connecter()
    {
     String lg;
     String mp;
     
     System.out.println("Saisissez votre login");
     lg = Clavier.lireString();
     System.out.println("Saisissez votre mot de passe");
     mp = Clavier.lireString();
             
    }
    
    public void creerCompteAbonne()
    {
        
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
            
}

    