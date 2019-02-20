/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisation;
import Source.*;
import java.util.ArrayList;
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
}
