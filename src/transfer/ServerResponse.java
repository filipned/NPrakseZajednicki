/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author FILIP
 */
public class ServerResponse implements Serializable {
    private Object podaci;
    private int uspesnost;
    private Exception exception;

    public ServerResponse() {
    }
    
    public ServerResponse(Object podaci, int uspesnost, Exception exception) {
        this.podaci = podaci;
        this.uspesnost = uspesnost;
        this.exception = exception;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(int uspesnost) {
        this.uspesnost = uspesnost;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
    
}
