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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FILIP
 */
public class Bransa extends AbstractObject {

    
    private int bransaID;
    private String imeBranse;

    public Bransa() {
    }

    public Bransa(int bransaID, String imeBranse) {
        this.bransaID = bransaID;
        this.imeBranse = imeBranse;
    }
    
    
    
    @Override
    public String vratiImeTabele() {
        return "branse";
    }

    @Override
    public String vratiParametre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "bransaID";
    }

    @Override
    public int vratiVrednostPK() {
        return bransaID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> branse = new ArrayList<>();     
        try {
            while(rs.next()) {
                int id = rs.getInt("bransaID");
                String imeBranse = rs.getString("imeBranse");

                Bransa bransa = new Bransa(id, imeBranse);
                branse.add(bransa);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Fakultet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return branse;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getBransaID() {
        return bransaID;
    }

    public void setBransaID(int bransaID) {
        this.bransaID = bransaID;
    }

    public String getImeBranse() {
        return imeBranse;
    }

    public void setImeBranse(String imeBranse) {
        this.imeBranse = imeBranse;
    }

    @Override
    public String toString() {
        return imeBranse; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Bransa) {
            Bransa b = (Bransa) o;
            
            if(b.imeBranse.equals(this.imeBranse))
                return true;
        }
        return false;
    }
    
    
 
    
}
