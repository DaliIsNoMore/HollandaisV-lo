/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;
import java.util.Date;

/**
 *
 * @author Elie LAMOUREUX
 */
abstract public class MembreSociete {
    private String login;
    private String mp;
    private String prenom;
    private String nom;
    private Date DateEmbauche;

    public MembreSociete (String lg, String m, String p, String n, Date de)
    { login=lg;
    mp=m;
    prenom=p;
    nom=n;
    DateEmbauche=de;
    }
    public String getlogin(){
        return login;
    }
    public String getmp(){
        return mp;
    }
    public void setmp(String mp){
        this.mp=mp;
    }
    public String getprenom(){
        return prenom;
    }
    public void setprenom(String prenom){
        this.prenom=prenom;
                }
    public String getnom(){
        return nom;
    }
    public void setnom(String nom){
        this.nom=nom;
    }
    public Date getDateEmbauche(){
        return DateEmbauche;
    }
    public void setDateEmbauche(Date DateEmbauche) {
        this.DateEmbauche=DateEmbauche;
    }
    public String getInfos(){
        return ("\nprenom: "+getprenom()+"\nnom: "+getnom()+"\nDateEmbauche: "+getDateEmbauche());
    }   
    
    }

