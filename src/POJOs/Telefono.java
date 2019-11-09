/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

/**
 *
 * @author usuario
 */
////7A7
public class Telefono {
    private String telefono;
    private String informacion;

    public Telefono() {
    }
    
    public Telefono(String telefono, String informacion) {
        this.telefono = telefono;
        this.informacion = informacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getInformacion() {
        return informacion;
    }
}
