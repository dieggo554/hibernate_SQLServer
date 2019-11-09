package POJOS;

import java.util.ArrayList;
import java.util.Collection;

/**
 * * @author María José Galán López
 */
public class Proxecto implements java.io.Serializable {

    private int numProxecto;
    private String nomeProxecto;
    private String lugar;
    private Departamento numdepartcontrola;
    private Collection<Empregado> empregados = new ArrayList();

    public Collection<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Collection<Empregado> empregados) {
        this.empregados = empregados;
    }

    public Departamento getNumdepartcontrola() {
        return numdepartcontrola;
    }

    public void setNumdepartcontrola(Departamento numdepartcontrola) {
        this.numdepartcontrola = numdepartcontrola;
    }

    public Proxecto() {
    }

    public Proxecto(int numProxecto, String nomeProxecto, String lugar) {
        this.numProxecto = numProxecto;
        this.nomeProxecto = nomeProxecto;
        this.lugar = lugar;
    }

    public int getNumProxecto() {
        return this.numProxecto;
    }

    public void setNumProxecto(int numProxecto) {
        this.numProxecto = numProxecto;
    }

    public String getNomeProxecto() {
        return this.nomeProxecto;
    }

    public void setNomeProxecto(String nomeProxecto) {
        this.nomeProxecto = nomeProxecto;
    }

    public String getLugar() {
        return this.lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
