/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jacs
 */
@ManagedBean
@RequestScoped
public class TestBean {
    
    private String saludo;

    /** Creates a new instance of TestBean */
    public TestBean() {
    }
    
    public String aceptar(){
        return "test";
    }
    
    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
