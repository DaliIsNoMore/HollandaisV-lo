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
public class Velo {
    private int id;
    private static int nb;
    private Date dateMiseEnService;
    private EtatVelo etat;
    private StatutVelo statut;
    private Borne borne;
    

    public Velo(Date dateMiseEnService, EtatVelo etat, StatutVelo statut) {
        nb++;
        this.id = nb;
        this.dateMiseEnService = dateMiseEnService;
        this.etat = etat;
        this.statut = statut;
        this.borne= null;
    }

    public int getId() {
        return id;
    }


    public static int getNb() {
        return nb;
    }


    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public EtatVelo getEtat() {
        return etat;
    }

    public void setEtat(EtatVelo etat) {
        this.etat = etat;
    }

    public StatutVelo getStatut() {
        return statut;
    }

    public void setStatut(StatutVelo statut) {
        this.statut = statut;
    }

    public Borne getBorne() {
        return borne;
    }

    public void setBorne(Borne borne) {
        this.borne = borne;
    }
    
    public String getInfo(){
        String s;
        return s  = "Id: " + getId()
                   +"\nDate de mise en service: " + getDateMiseEnService()
                   +"\nEtat: " + getEtat().getEtat()
                   +"\nStatut: " + getStatut().getStatut()
                   +"\nBorne: " + getBorne().getInfo()
                ;
    }
}
