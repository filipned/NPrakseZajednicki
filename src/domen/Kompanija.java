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
public class Kompanija extends AbstractObject {

    private int kompanijaID;
    private String regBr;
    private String sifraDelatnosti;
    private String poslovnoIme;
    private String kontakt;
    private List<Bransa> branse;

    public Kompanija() {
    }

    public Kompanija(int kompanijaID, String regBr, String sifraDelatnosti, String poslovnoIme, String kontakt, List<Bransa> branse) {
        this.kompanijaID = kompanijaID;
        this.regBr = regBr;
        this.sifraDelatnosti = sifraDelatnosti;
        this.poslovnoIme = poslovnoIme;
        this.kontakt = kontakt;
        this.branse = branse;
    }
    
    
    
    @Override
    public String vratiImeTabele() {
        return "kompanije";
    }

    @Override
    public String vratiParametre() {
        return String.format("0, '%s', '%s', '%s', '%s'", regBr, sifraDelatnosti, poslovnoIme, kontakt);
    }

    @Override
    public String vratiPK() {
        return "kompanijaID";
    }

    @Override
    public int vratiVrednostPK() {
        return kompanijaID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        AbstractObject kompanija;
        List<AbstractObject> kompanije = new ArrayList<>();
        try {
            while(rs.next()) {
                int kompanijaID = rs.getInt("kompanijaID");
                String regBr = rs.getString("regBr");
                String sifraDelatnosti = rs.getString("sifraDelatnosti");
                String poslovnoIme = rs.getString("poslovnoIme");
                String kontakt = rs.getString("kontakt");
                
                kompanija = new Kompanija(kompanijaID, regBr, sifraDelatnosti, poslovnoIme, kontakt, null);
                kompanije.add(kompanija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kompanija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kompanije;
    }

    @Override
    public String vratiUpdate() {
        return String.format("regBr='%s',sifraDelatnosti='%s',poslovnoIme='%s',kontakt='%s'", regBr, sifraDelatnosti, poslovnoIme, kontakt);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        kompanijaID = pk;
    }

    public int getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(int kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public String getRegBr() {
        return regBr;
    }

    public void setRegBr(String regBr) {
        this.regBr = regBr;
    }

    public String getSifraDelatnosti() {
        return sifraDelatnosti;
    }

    public void setSifraDelatnosti(String sifraDelatnosti) {
        this.sifraDelatnosti = sifraDelatnosti;
    }

    public String getPoslovnoIme() {
        return poslovnoIme;
    }

    public void setPoslovnoIme(String poslovnoIme) {
        this.poslovnoIme = poslovnoIme;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public List<Bransa> getBransa() {
        return branse;
    }

    public void setBransa(List<Bransa> branse) {
        this.branse = branse;
    }

    public List<Bransa> getBranse() {
        return branse;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if(o instanceof Kompanija) {
            Kompanija k = (Kompanija) o;
            
            if(k.regBr.equals(this.regBr)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Reg. br: " + regBr + ", Sifra delatnosti: " + sifraDelatnosti + ", Ime: " + poslovnoIme + "kontakt: " +kontakt;
     }
    
    
    
    
}
