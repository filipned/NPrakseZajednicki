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
public class ClientRequest implements Serializable{
    
    private int operacija;
    private Object object;

    public ClientRequest() {
    }
    
    public ClientRequest(int operacija, Object object) {
        this.operacija = operacija;
        this.object = object;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    
}
