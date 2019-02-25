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
public class StatutVelo {
    private int id;
    private String statut;
    private static int nb;

    public StatutVelo( String statut) {
        nb++;
        this.id = nb;
        this.statut = statut;
    }


   
    public int getId() {
        return id;
    }

public static int getNb() {
        return nb;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
                                  
    
    
    
    
    
    
    
    
    
}
