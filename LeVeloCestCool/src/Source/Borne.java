/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Source;
import java.util.Date;
/**
 *
 * @author Alexis
 */
public class Borne {
    private int id;
    private String adresse;
    private int placeMax;
    private static int nb;

    public Borne(String adresse, int placeMax) {
        nb++;
        this.id = nb;
        this.adresse = adresse;
        this.placeMax=placeMax;
    }


   
    public int getId() {
        return id;
    }

public static int getNb() {
        return nb;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPlaceMax() {
        return placeMax;
    }

     
   public void ajouterPlace (int nbplace){
       this.placeMax= this.placeMax+nbplace;
   }
    
   public void supprimerPlace (int nbplace){
       this.placeMax= this.placeMax-nbplace;
   }
   
   public String getInfo(){
    String s;
    return s = "Id: "+getId() + "Adresse: "+ getAdresse()+ "Nombre de place: "+ getPlaceMax();
   }
}
