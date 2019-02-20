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
public class GestionTechnicien {
    
    private ArrayList<FicheReparation>listeFicheReparation;
    private ArrayList<Velo>listeVelo;
    private ArrayList<Borne>listeBorne;
    private ArrayList<TypeReparation>listeTypeReparation;
    private ArrayList<StatutVelo>listeStatutVelo;
        
    public GestionTechnicien(){
        listeFicheReparation = new ArrayList();
        listeVelo = new ArrayList();
        listeBorne = new ArrayList();
        listeTypeReparation = new ArrayList();
        listeStatutVelo = new ArrayList();
    }
    
    public ArrayList<FicheReparation> getListeFicheReparation() {
        return listeFicheReparation;
    }

    public void setListeFicheReparation(ArrayList<FicheReparation> listeFicheReparation) {
        this.listeFicheReparation = listeFicheReparation;
    }

    public ArrayList<Velo> getListeVelo() {
        return listeVelo;
    }

    public void setListeVelo(ArrayList<Velo> listeVelo) {
        this.listeVelo = listeVelo;
    }

    public ArrayList<Borne> getListeBorne() {
        return listeBorne;
    }

    public void setListeBorne(ArrayList<Borne> listeBorne) {
        this.listeBorne = listeBorne;
    }

    public ArrayList<TypeReparation> getListeTypeReparation() {
        return listeTypeReparation;
    }

    public void setListeTypeReparation(ArrayList<TypeReparation> listeTypeReparation) {
        this.listeTypeReparation = listeTypeReparation;
    }
    
    public ArrayList<StatutVelo> getListeStatutVelo() {
        return listeStatutVelo;
    }

    public void setListeStatutVelo(ArrayList<StatutVelo> listeStatutVelo) {
        this.listeStatutVelo = listeStatutVelo;
    }
    
    public Boolean supprimerVelo(int id){
        Velo v=null;
        boolean supprimer=false;
        v=rechercheVelo(id);
               
         if(null!=v){
             v.setStatut(listeStatutVelo.get(2));//ajouter en 3e position la destruction
             supprimer=true;
         }
         
      return supprimer; 
    }
  
    public Velo rechercheVelo(int id){
        Velo v=null;
        int i=0;
        boolean trouve=false;
            if(!listeVelo.isEmpty()){
                do{
                    if(id==listeVelo.get(i).getId()){
                        v=listeVelo.get(i);
                        trouve=true;
                    } 
                    i++;
                }while(trouve==false && i<listeVelo.size());
        
            }
        return v;
    }

    public Velo creerVelo (Date dateMiseEnService, EtatVelo etat, StatutVelo statut, Borne borne){
        Velo v;
        
        v= new Velo (dateMiseEnService,etat,statut);
        v.setBorne(borne);
        listeVelo.add(v);
        
        return v;
        
    }

    public boolean modifierVelo(int id, int choix, Date date, EtatVelo etat, StatutVelo statut, Borne borne){
        Velo v=null;
        boolean effectuer=false;
        v=rechercheVelo(id);
    
        if(null!=v){
  
            switch (choix){
        
            case 1:
                v.setDateMiseEnService(date);
                effectuer=true;
                break;
            
            case 2 :
                v.setEtat(etat);
                effectuer=true;
                break;

            case 3 :
                v.setStatut(statut);
                effectuer=true;
                break;

            case 4:
                v.setBorne(borne);
                effectuer = true;
                break;

            }
    
        }
    
    return effectuer;
    }


    public Borne creerBorne(String adresse, int placeMax){
        Borne b;    

        b= new Borne (adresse,placeMax);
        listeBorne.add(b);
        
        return b;
    }
    
    public Borne rechercheBorne(int id){
        Borne b, trouve=null;
        int i=0;
        
        if (!listeBorne.isEmpty()){
            while (i<listeBorne.size()&&trouve==null){
                b=listeBorne.get(i);
                if(b.getId()== id){
                    trouve=b;
                }
            }
        }
        return trouve;
    }
    
    public ArrayList<Velo> supprimerBorne (int id){
        Borne b=null;
        ArrayList<Velo>listeVeloBorne;
        listeVeloBorne = new ArrayList();

        b = rechercheBorne(id);
        listeVeloBorne=listeVeloBorne(id);
        if (listeVeloBorne.size()==0){
           listeBorne.remove(b);
        }

        return listeVeloBorne;
    }
    
    public ArrayList<Velo> listeVeloBorne (int id){
        int i = 0;
        Borne b=null;
        ArrayList<Velo>listeVeloBorne;
        listeVeloBorne = new ArrayList();

        b=rechercheBorne(id);
        for(i=0;i<listeVelo.size();i++){
            if(listeVelo.get(i).getBorne().getId()==id){
                listeVeloBorne.add(listeVelo.get(i));
            }
        }

        return listeVeloBorne;
    }

    public boolean modifierBorne(int id, int choix, int nbplace){
        Borne b =null;
        boolean effectuer=false;
        
        b=rechercheBorne(id);
        if(null!=b){
            switch (choix){

            case 1:
                b.ajouterPlace(nbplace);
                effectuer=true;
                break;

            case 2 :
                b.supprimerPlace(nbplace);
                effectuer=true;
                break;
            }
        }
        return effectuer;
        }

     public Velo CreerVelo (Date dateMiseEnService, EtatVelo etat, StatutVelo statut, Borne borne)
    {
        Velo v;
        v= new Velo (dateMiseEnService,etat,statut);
        v.setBorne(borne);
        listeVelo.add(v);
        return v;
        
    }
     
    public FicheReparation creerFicheReparation(Date d,Double pr, String p, TypeReparation tr, Velo v, Technicien t){
        FicheReparation f;
    
        f= new FicheReparation(d,pr,p,tr,v,t);
    
        return f;
    }

}
