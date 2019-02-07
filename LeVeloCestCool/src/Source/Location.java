/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;
import java.util.Date;
/**
 *
 * @author GREGO
 */
public class Location {


    private int id;
    private static int nb;
    private Date dateDebut;
    private Date dateFin;
    private Abonne abonne;
    private Velo velo;
    
    public Location(Date d, Abonne a, Velo v)
    {
        nb++;
        id = nb;
        dateFin = null;
        dateDebut = d;
        abonne = a;
        velo = v;
            
    }
            
    public int getId() {
        return id;
    }

    public static int getNb() {
        return nb;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }
}
