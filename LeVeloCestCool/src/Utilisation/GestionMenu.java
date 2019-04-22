/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisation;

import Source.Abonne;
import Source.Clavier;
import Source.Gestionnaire;
import Source.MembreSociete;
import Source.Technicien;

/**
 *
 * @author GREGO
 */
public class GestionMenu {
    
    
    private GestionTechnicien gt;
    private GestionGestionnaire gg;
    private GestionMenuAbonne gma;
    
    public GestionMenu()
    {
    
    gt = new GestionTechnicien();
    gg = new GestionGestionnaire();
    gma = new GestionMenuAbonne();
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
                gma.creerCompteAbonne();
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
          a = gma.rechercheAbonne(lg);
          if(a!=null)
          {
            do{
                if (a.getMp().equals(mp) && gma.getGa().validiteDateAbonne(a)) 
                {
                    gma.menuAbonne(a);
                    
                } 
                else{
                    if(gma.getGa().validiteDateAbonne(a))
                    {
                        System.out.println("Mauvais mot de passe");
                    }
                    else{
                        System.out.println("Date");
                    }
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
                                //menuGestionnaire((Gestionnaire)m);
                            }
                            else
                            {
                                //menuTechnicien((Technicien)m);
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
}
