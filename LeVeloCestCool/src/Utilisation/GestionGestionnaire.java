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
public class GestionGestionnaire {

    
    private ArrayList<MembreSociete>listeMembreSociete;
    
    public GestionGestionnaire(){
        listeMembreSociete = new ArrayList();   
    }
    
    public ArrayList<MembreSociete> getListeMembreSociete() {
        return listeMembreSociete;
    }

    public void setListeMembreSociete(ArrayList<MembreSociete> listeMembreSociete) {
        this.listeMembreSociete = listeMembreSociete;
    }

    
    public MembreSociete rechercheMembreSociete(String lg){
    int i=0;
    MembreSociete m = null;   
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
    return m;
    }
    
    public ArrayList<Abonne> abonneRetard(ArrayList<Location>listeLocation){
        ArrayList<Abonne> listeAbonneRetard = new ArrayList();
        Date d = new Date();
        int jourDifference = 30;
        long valeurDateDebut;
        long valeurDateFin = d.getTime();
        long valeurDateDifference = jourDifference* 86400000;
        
        if (!listeLocation.isEmpty()){
            for (int i = 0; i<listeLocation.size();i++){
                if (listeLocation.get(i).getDateFin() == null){
                    valeurDateDebut = listeLocation.get(i).getDateDebut().getTime();
                    if (valeurDateFin - valeurDateDebut > valeurDateDifference){
                        listeAbonneRetard.add(listeLocation.get(i).getAbonne());
                    }
                }
            }
        }
        
        return listeAbonneRetard;
    }
    
    public boolean rappelAbonne(ArrayList<Location>listeLocation){
        boolean effectuer = false;
        Date d = new Date();
        int differenceReelle;
        int jourDifference = 23;
        long valeurDateDebut;
        long valeurDateFin = d.getTime();
        long valeurDateDifference = jourDifference* 86400000;
        String message ;
        
        if (!listeLocation.isEmpty()){
            for (int i = 0; i<listeLocation.size();i++){
                if (listeLocation.get(i).getDateFin() == null){
                    valeurDateDebut = listeLocation.get(i).getDateDebut().getTime();
                    if (valeurDateFin - valeurDateDebut > valeurDateDifference){
                        differenceReelle = (int)((valeurDateFin - valeurDateDebut)/86400000);
                        message = "Votre location expire dans " + differenceReelle + " jour(s)";
                        listeLocation.get(i).getAbonne().setMessage(message);
                    }
                    else{
                        message = "";
                        listeLocation.get(i).getAbonne().setMessage(message);
                    }
                }
            }
        }
        
        
        return effectuer;
    }
    
    public ArrayList<Velo> RechercheVeloMauvaisEtat(ArrayList<Velo>listeVelo, ArrayList<EtatVelo>listeEtatVelo){
        ArrayList<Velo> listeVeloMauvaisEtat = new ArrayList();
        
        if (!listeVelo.isEmpty()&& !listeEtatVelo.isEmpty()){
            for (int i = 0; i<listeVelo.size();i++){
                if(listeVelo.get(i).getEtat().getEtat().equals(listeEtatVelo.get(0).getEtat())){
                    listeVeloMauvaisEtat.add(listeVelo.get(i));
                }
            }
        }
        
        return listeVeloMauvaisEtat;
    }
}
