package POJOS;
/**author María José Galán López */
public class Telefono  implements java.io.Serializable {
     private String telefono;
     private String informacion;

    public Telefono() {
    }

    public Telefono(String telefono, String informacion) {
        this.telefono = telefono;
        this.informacion = informacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

}


