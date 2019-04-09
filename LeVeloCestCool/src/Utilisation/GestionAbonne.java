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
public class GestionAbonne {

    
    private ArrayList<Abonne>listeAbonne;
    private ArrayList<Location>listeLocation;
    
    public GestionAbonne(){
        listeAbonne = new ArrayList();
        listeLocation = new ArrayList();
        
    }
    
    public ArrayList<Abonne> getListeAbonne() {
        return listeAbonne;
    }

    public void setListeAbonne(ArrayList<Abonne> listeAbonne) {
        this.listeAbonne = listeAbonne;
    }

    public ArrayList<Location> getListeLocation() {
        return listeLocation;
    }

    public void setListeLocation(ArrayList<Location> listeLocation) {
        this.listeLocation = listeLocation;
    }
    
    public Abonne creerAbonne(String lg,String mp, String nom, String prenom, String adresse, String email, String telephone, Date dateDebutAbonnement){
        Abonne a =null;
        a = new Abonne(lg,mp, nom, prenom, adresse, email, telephone, dateDebutAbonnement);
        listeAbonne.add(a);
        return a;
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
        
        return a;
    }
    
    public Location creerLocation (Date dateDebut, Date dateFin, Abonne abonne, Velo velo){
    Location l;
    
    l=new Location (dateDebut, abonne, velo);
    l.setAbonne(abonne);
    l.setVelo(velo);
    listeLocation.add(l);
    
    return l;
    }
}
