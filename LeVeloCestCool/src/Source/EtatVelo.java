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
public class EtatVelo {
    private int id;
    private String etat;
    private static int nb;

    public EtatVelo(int id, String etat) {
        nb++;
        this.id = nb;
        this.etat = etat;
    }


   
    public int getId() {
        return id;
    }

public static int getNb() {
        return nb;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
                                  
    
    
    
    
    
    
    
    
    
}
