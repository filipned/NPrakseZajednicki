/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FILIP
 */
public class Zaposleni extends AbstractObject {
    
    private int zaposleniID;
    private String email;
    private String lozinka;

    public Zaposleni() {
    }
    
    public Zaposleni(int zaposleniID, String email, String lozinka) {
        this.zaposleniID = zaposleniID;
        this.email = email;
        this.lozinka = lozinka;
    }

    @Override
    public String vratiImeTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiParametre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> sviZaposleni = new ArrayList<>();
        
        try {
            while (rs.next()) {
               int zaposleniID = rs.getInt("zaposleniID");
               String email = rs.getString("email");
               String lozinka = rs.getString("lozinka");
               
               Zaposleni z = new Zaposleni(zaposleniID, email, lozinka);
                System.out.println(z.toString());
               sviZaposleni.add(z);

            }
        } catch(SQLException ex) {
            System.out.println("Greska RSuTabelu kod zaposlenog!");
        }
        return sviZaposleni;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Zaposleni) {
            Zaposleni z = (Zaposleni) o;
            if(z.getEmail().equals(this.email) && z.getLozinka().equals(this.lozinka)) 
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return zaposleniID + " " + email + " " +  lozinka;
    }
    
    
}
