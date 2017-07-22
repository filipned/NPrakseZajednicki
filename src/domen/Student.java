/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FILIP
 */
public class Student extends AbstractObject {

    private int studentID;
    private String ime;
    private String prezime;
    private String brIndeksa;
    private String godinaUpisa;
    private boolean pohadjaoPraksu;
    private Fakultet fakultet;

    public Student() {
    }

    public Student(int studentID, String ime, String prezime, String brIndeksa, String godinaUpisa, boolean pohadjaoPraksu, Fakultet fakultet) {
        this.studentID = studentID;
        this.ime = ime;
        this.prezime = prezime;
        this.brIndeksa = brIndeksa;
        this.godinaUpisa = godinaUpisa;
        this.pohadjaoPraksu = pohadjaoPraksu;
        this.fakultet = fakultet;
    }

    Student(int studentID) {
        this.studentID = studentID;
    }
    
    
    
    @Override
    public String vratiImeTabele() {
        return "studenti";
    }

    @Override
    public String vratiParametre() {
        return String.format("0, '%s', '%s', '%s', '%s', '%s', '%s'", ime, prezime, brIndeksa, godinaUpisa, 0, fakultet.vratiVrednostPK());
    }

    @Override
    public String vratiPK() {
        return "studentID";
    }

    @Override
    public int vratiVrednostPK() {
        return studentID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        
        List<AbstractObject> studenti = new ArrayList<>();
            
        try {
            while(rs.next()) {
                int studentID = rs.getInt("studentID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String brIndeksa = rs.getString("brIndeksa");
                String godinaUpisa = rs.getString("godinaUpisa");
                int fakultetID = rs.getInt("fakultetID");
                
                Student student = new Student(studentID, ime, prezime, brIndeksa, godinaUpisa, false, new Fakultet(fakultetID, null));
                studenti.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenti;
    }
 
    @Override
    public String vratiUpdate() {
        return String.format("ime='%s',prezime='%s',brIndeksa='%s',godinaUpisa='%s',fakultetID='%s' ", ime, prezime, brIndeksa, godinaUpisa, fakultet.getFakultetID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        studentID = pk;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public boolean isPohadjaoPraksu() {
        return pohadjaoPraksu;
    }

    public void setPohadjaoPraksu(boolean pohadjaoPraksu) {
        this.pohadjaoPraksu = pohadjaoPraksu;
    }

    public Fakultet getFakultet() {
        return fakultet;
    }

    public void setFakultet(Fakultet fakultet) {
        this.fakultet = fakultet;
    }

    public String getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(String brIndeksa) {
        this.brIndeksa = brIndeksa;
    }
    
    

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student) {
            Student s = (Student) o;
            if(s.brIndeksa.equals(this.brIndeksa) && s.getFakultet().getFakultetID() == this.getFakultet().getFakultetID()) {
                return true;
            }
            
        }
        return false;
    }

    @Override
    public String toString() {
        return "Ime: " + ime + ", Prezime: " + prezime + ", Indeks: " + brIndeksa + ", Godina Upisa: " + godinaUpisa + ", Fakultet: " +fakultet.getImeFakulteta();
    }
    
    
    
}
