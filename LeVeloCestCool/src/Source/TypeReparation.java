/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author GREGO
 */
public class TypeReparation {

    private int id;
    private static int nb;
    private String type;
    
    public TypeReparation(String t)
    {
    nb++;
    id = nb;
    type = t;
    }

    public int getId() {
        return id;
    }

    public static int getNb() {
        return nb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
