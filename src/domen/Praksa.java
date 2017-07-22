/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FILIP
 */
public class Praksa extends AbstractObject {

    private int praksaID;
    private Kompanija kompanija;
    private Student student;
    private Date datumOd;
    private Date datumDo;
    private String komentarPoslodavca;
    private int ocena;
    private Bransa bransa;

    public Praksa() {
    }

    public Praksa(int praksaID, Kompanija kompanija, Student student, Date datumOd, Date datumDo, String komentarPoslodavca, int ocena, Bransa bransa) {
        this.praksaID = praksaID;
        this.kompanija = kompanija;
        this.student = student;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.komentarPoslodavca = komentarPoslodavca;
        this.ocena = ocena;
        this.bransa = bransa;
    }
    
    
    
    @Override
    public String vratiImeTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(int pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPraksaID() {
        return praksaID;
    }

    public void setPraksaID(int praksaID) {
        this.praksaID = praksaID;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public String getKomentarPoslodavca() {
        return komentarPoslodavca;
    }

    public void setKomentarPoslodavca(String komentarPoslodavca) {
        this.komentarPoslodavca = komentarPoslodavca;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Bransa getBransa() {
        return bransa;
    }

    public void setBransa(Bransa bransa) {
        this.bransa = bransa;
    }
    
    
}
