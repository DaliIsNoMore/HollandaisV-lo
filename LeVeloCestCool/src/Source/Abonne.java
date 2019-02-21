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
public class Abonne {


    private String login;
    private String mp;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private Date dateDebutAbonnement;
    private String message;
    
    public Abonne(String lg, String m, String n, String p, String a, String e, String t, Date d)
    {
     login=lg;
     mp=m;
     nom=n;
     prenom=p;
     adresse=a;
     email=e;
     telephone=t;
     dateDebutAbonnement=d;
     message = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getLogin() {
    return login;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateDebutAbonnement() {
        return dateDebutAbonnement;
    }

    public void setDateDebutAbonnement(Date dateDebutAbonnement) {
        this.dateDebutAbonnement = dateDebutAbonnement;
    }
    
   

}
