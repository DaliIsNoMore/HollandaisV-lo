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
    
    public Abonne rechercheAbonne(String lg){
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
    
    public Location creerLocation (Date dateDebut, Abonne abonne, Velo velo, ArrayList<StatutVelo> listeStatutVelo){
    Location l= null;
    
    
    if (!velo.getStatut().equals(listeStatutVelo.get(2).getStatut())){
    l=new Location (dateDebut, abonne, velo);
    listeLocation.add(l);
    }
    
    return l;
    }
    
    public boolean modifierAbonne (Abonne a, int choix, String mp, String nom, String prenom, String adresse,String mail, String telephone, Date dateDebutAbonnement){
    boolean effectuer=false;
     
    switch (choix){
        case 1 :
            a.setMp(mp);
            effectuer=true;
            break;
            
        case 2 :
            a.setNom(nom);
            effectuer=true;
            break;
            
        case 3 :
            a.setPrenom(prenom);
            effectuer=true;
            break;
            
        case 4:
            a.setDateDebutAbonnement(dateDebutAbonnement);
            effectuer=true;
            break;

        case 5 :
            a.setAdresse(adresse);
            effectuer=true;
            break;
            
        case 6 :
            a.setEmail(mail);
            effectuer=true;
            break;

        case 7 :
            a.setTelephone(telephone);
            effectuer=true;
            break;
    }
    
    return effectuer;
             
    }
   
    public boolean supprimerAbonne (Abonne a){
    boolean effectuer = false;
    Location l = null;
    int i = 0;
    if (!listeLocation.isEmpty()){
        while(i<listeLocation.size()&&l == null){
            if (listeLocation.get(i).getAbonne().getLogin().equals(a.getLogin())){
                l = listeLocation.get(i);
            }
        }

        if (l!=null){
            listeAbonne.remove(a);
            effectuer = true;
        }
    }
            
    return effectuer;
    }
    
    public boolean modifierLocation (int id,int choix, Date dateFin, Velo velo){
        Location l;
        boolean effectuer=false;
        
        l=rechercheLocation(id);
        if(null!=l){
            switch (choix){
                
                case 1:
                    l.setDateFin (dateFin);
                    effectuer=true;
                    break;
                    
                case 2:
                    l.setVelo(velo);
                    effectuer=true;
                    break;
            }
        }
        
        return effectuer;
    }
    
    public Location rechercheLocation(int id){
        Location l= null;
        int i = 0;
        
        while (i<listeLocation.size()&&l == null){
            if(id==listeLocation.get(i).getId()){
                    l=listeLocation.get(i);
            }
            i++;
        }
        
        return l;
    }
}
