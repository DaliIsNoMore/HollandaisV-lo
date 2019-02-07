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
public class FicheReparation {


    private int id;
    private static int nb;
    private Date dateDebutReparation;
    private Date dateFinReparation;
    private Double prixReparation;
    private String probleme;
    private TypeReparation typeReparation;
    private Velo velo;
    private Technicien technicien;
    
    public FicheReparation(Date d,Double pr, String p, TypeReparation tr, Velo v, Technicien t)
    {
        nb++;
        id = nb;
        dateDebutReparation = d;
        dateFinReparation = null;
        prixReparation = pr;
        probleme = p;
        typeReparation = tr;
        velo = v;
        technicien = t;
                
    }
    
        public int getId() {
        return id;
    }

    public static int getNb() {
        return nb;
    }

    public Date getDateDebutReparation() {
        return dateDebutReparation;
    }

    public void setDateDebutReparation(Date dateDebutReparation) {
        this.dateDebutReparation = dateDebutReparation;
    }

    public Date getDateFinReparation() {
        return dateFinReparation;
    }

    public void setDateFinReparation(Date dateFinReparation) {
        this.dateFinReparation = dateFinReparation;
    }

    public Double getPrixReparation() {
        return prixReparation;
    }

    public void setPrixReparation(Double prixReparation) {
        this.prixReparation = prixReparation;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public TypeReparation getTypeReparation() {
        return typeReparation;
    }

    public void setTypeReparation(TypeReparation typeReparation) {
        this.typeReparation = typeReparation;
    }

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }
}
