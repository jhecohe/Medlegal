/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jhecohe
 */
@ManagedBean
@RequestScoped
public class Hora {

    Date fecha;
    SimpleDateFormat formato;
    
    public Hora() {
        formato = new SimpleDateFormat("dd 'de 'MMMM 'de ' yyyy '- 'hh ':' mm");
    }

    public String getFecha() {
        fecha = new Date();
        String fech = formato.format(fecha); 
        return fech;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
