/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author FILIP
 */
public class Praksa extends AbstractObject {

    private int praksaID;
    private Kompanija kompanija;
    private Student student;
    private java.util.Date datumOd;
    private java.util.Date datumDo;
    private String komentarPoslodavca;
    private int ocena;
    private Bransa bransa;

    public Praksa() {
    }

    public Praksa(int praksaID, Kompanija kompanija, Student student, java.util.Date datumOd, java.util.Date datumDo, String komentarPoslodavca, int ocena, Bransa bransa) {
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
        return "prakse";
    }

    @Override
    public String vratiParametre() {
        return String.format("0, '%s', '%s', '%s', '%s', '%s', '%s', '%s'", student.getStudentID(), kompanija.getKompanijaID(), new Timestamp(datumOd.getTime()), new Timestamp(datumDo.getTime()), komentarPoslodavca, ocena, bransa.getBransaID());
    }

    @Override
    public String vratiPK() {
        return "praksaID";
    }

    @Override
    public int vratiVrednostPK() {
        return praksaID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        AbstractObject praksa;
        List<AbstractObject> prakse = new ArrayList<>();
        try {
            while(rs.next()) {
                int praksaID = rs.getInt("praksaID");
                int studentID = rs.getInt("studentID");
                int kompanijaID = rs.getInt("kompanijaID");
                String datumOd = rs.getString("datumOd");
                String datumDo = rs.getString("datumDo");
                String komentar = rs.getString("komentarPoslodavca");
                int ocena = rs.getInt("ocena");
                int bransaID = rs.getInt("bransaID");
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                praksa = new Praksa(praksaID, new Kompanija(kompanijaID), new Student(studentID), sdf.parse(datumOd), sdf.parse(datumDo), komentar, ocena, new Bransa(bransaID, null));
                
                prakse.add(praksa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Kompanija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Praksa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prakse;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(int pk) {
        praksaID = pk;
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

    public java.util.Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(java.util.Date datumOd) {
        this.datumOd = datumOd;
    }

    public java.util.Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(java.util.Date datumDo) {
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

    @Override
    public String toString() {
        return student.toString() + " " + kompanija.toString() + " " + bransa.getImeBranse() + ", Ocena " + ocena;
    }
    
    
}
