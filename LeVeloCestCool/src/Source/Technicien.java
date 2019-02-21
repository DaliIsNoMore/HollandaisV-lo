/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Source;

import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Alexis
 */
public class Technicien extends MembreSociete{
    private static ArrayList<Velo>listeVeloMauvaisEtat;
    
    public Technicien (String lg, String m, String p, String n, Date de){
        super(lg,m,p,n,de);
        listeVeloMauvaisEtat = new ArrayList();
        
    }

    public static ArrayList<Velo> getListeVeloMauvaisEtat() {
        return listeVeloMauvaisEtat;
    }

    public static void setListeVeloMauvaisEtat(ArrayList<Velo> listeVeloMauvaisEtat) {
        Technicien.listeVeloMauvaisEtat = listeVeloMauvaisEtat;
    }
    

    
    
}
