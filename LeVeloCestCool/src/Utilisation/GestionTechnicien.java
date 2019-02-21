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
    private ArrayList<EtatVelo>listeEtatVelo;
        
    public GestionTechnicien(){
        listeFicheReparation = new ArrayList();
        listeVelo = new ArrayList();
        listeBorne = new ArrayList();
        listeTypeReparation = new ArrayList();
        listeStatutVelo = new ArrayList();
        listeEtatVelo = new ArrayList();
    }

    public ArrayList<EtatVelo> getListeEtatVelo() {
        return listeEtatVelo;
    }

    public void setListeEtatVelo(ArrayList<EtatVelo> listeEtatVelo) {
        this.listeEtatVelo = listeEtatVelo;
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
    
    public EtatVelo rechercheEtatVelo(int id){
        EtatVelo e= null;
        int i = 0;
        
        if(!listeEtatVelo.isEmpty()){
            while(i<listeEtatVelo.size() && e == null){
                if(listeEtatVelo.get(i).getId() == id){
                    e = listeEtatVelo.get(i);
                }
            i++;
            }
        }
        
        return e;
    }
    
    public ArrayList<EtatVelo> rechercheListeEtatVelo(){
        ArrayList<EtatVelo> e= listeEtatVelo;
        
        return e;
    }
    public ArrayList<StatutVelo> rechercheListeStatutVelo(){
        ArrayList<StatutVelo> s= listeStatutVelo;
        
        return s;
    }
    
    public ArrayList<Borne> rechercheListeBorne(){
        ArrayList<Borne> b= listeBorne;
        
        return b;
    }
    
    public StatutVelo rechercheStatutVelo(int id){
        StatutVelo s= null;
        int i = 0;
        
        if(!listeStatutVelo.isEmpty()){
            while(i<listeStatutVelo.size() && s == null){
                if(listeStatutVelo.get(i).getId() == id){
                    s = listeStatutVelo.get(i);
                }
            i++;
            }
        }
        
        return s;
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
        ArrayList<Velo>listeVeloBorne;
        listeVeloBorne = new ArrayList();

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
 
     
    public FicheReparation creerFicheReparation(Date d,Double pr, String p, TypeReparation tr, Velo v, Technicien t){
        FicheReparation f;
    
        f= new FicheReparation(d,pr,p,tr,v,t);
    
        return f;
    }
    
    public boolean verificationFicheReparation(int id){
    boolean verif=true;
    int i=0;
    
    while(i<listeFicheReparation.size()&& verif==true){
        if(listeFicheReparation.get(i).getVelo().getId()==id){
            verif=false;
            i++;
        }
    }
    return verif;  
    }

    public boolean finaliserFicheReparation(int id){
           Velo v;
           FicheReparation fr=null;
           int i =0;
           boolean finaliser=false;

           v=rechercheVelo(id);
           if (null!=v){
               for(i=0;i<listeFicheReparation.size();i++){
                   if(listeFicheReparation.get(i).getVelo().getId()==id){
                       fr=listeFicheReparation.get(i);
                   }

               }


            fr.getVelo().setStatut(null);
            fr.getVelo().setEtat(listeEtatVelo.get(2));


            fr.setDateFinReparation(new Date());  
            finaliser =true;
           }
          return  finaliser;
    }
    
    public boolean deposerVelo(Velo v, Borne b){
        boolean deposer=false;
        int idb;
        ArrayList<Velo>listeVeloBorne;
        listeVeloBorne = new ArrayList();

        idb=b.getId();
           listeVeloBorne=listeVeloBorne(idb);
        if(listeVeloBorne.size()<b.getPlaceMax()){
            v.setBorne(b);
            deposer=true;
            }

        return deposer;
    }
    
    public TypeReparation rechercheTypeReparation(int id ){
      TypeReparation t=null, trouve=null;
      int i=0;
        if (!listeTypeReparation.isEmpty()){
            while (i<listeTypeReparation.size()&&trouve==null){
                t=listeTypeReparation.get(i);
                if(t.getId()== id){
                    trouve=t;
                }
            }
        }

        return trouve;
    }





            
}

