/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

public class Enderezo {
     private String rua;
     private int numeroCalle;
     private String piso;
     private String cp;
     private String localidade;
     private String provincia;

    public Enderezo() {
    }

    public Enderezo(String rua, int numeroCalle, String piso, String cp, String localidade, String provincia) {
        this.rua = rua;
        this.numeroCalle = numeroCalle;
        this.piso = piso;
        this.cp = cp;
        this.localidade = localidade;
        this.provincia = provincia;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    
}
