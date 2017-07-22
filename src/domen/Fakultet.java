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
public class Fakultet extends AbstractObject {

    private int fakultetID;
    private String imeFakulteta;

    public Fakultet() {
    }

    public Fakultet(int fakultetID, String imeFakulteta) {
        this.fakultetID = fakultetID;
        this.imeFakulteta = imeFakulteta;
    }
    
    
    
    @Override
    public String vratiImeTabele() {
        return "fakulteti";
    }

    @Override
    public String vratiParametre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        return "fakultetID";
    }

    @Override
    public int vratiVrednostPK() {
        return fakultetID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
            
        List<AbstractObject> fakulteti = new ArrayList<>();     
        try {
            while(rs.next()) {
                int id = rs.getInt("fakultetID");
                String imeFakulteta = rs.getString("imeFakulteta");

                Fakultet fakultet = new Fakultet(id, imeFakulteta);
                fakulteti.add(fakultet);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Fakultet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fakulteti;
        
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getFakultetID() {
        return fakultetID;
    }

    public void setFakultetID(int fakultetID) {
        this.fakultetID = fakultetID;
    }

    public String getImeFakulteta() {
        return imeFakulteta;
    }

    public void setImeFakulteta(String imeFakulteta) {
        this.imeFakulteta = imeFakulteta;
    }

    @Override
    public String toString() {
        return imeFakulteta;//To change body of generated methods, choose Tools | Templates.
    }
 
    
    
}
