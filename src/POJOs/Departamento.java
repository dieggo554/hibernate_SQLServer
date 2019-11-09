package POJOS;
// Generated 01-abr-2014 18:24:58 by Hibernate Tools 3.2.1.GA

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * * @author María José Galán López
 */
public class Departamento implements java.io.Serializable {

    private int numDepartamento;
    private String nomeDepartamento;
    private Empregado director;
    private Set<Proxecto> proxectos = new HashSet();
    private Collection <Empregado> empregados = new ArrayList();

    public Set<Proxecto> getProxectos() {
        return proxectos;
    }

    public void setProxectos(Set<Proxecto> proxectos) {
        this.proxectos = proxectos;
    }

    public Empregado getDirector() {
        return director;
    }

    public void setDirector(Empregado director) {
        this.director = director;
    }

    public Departamento() {
    }

    public Departamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public Departamento(int numDepartamento, String nomeDepartamento) {
        this.numDepartamento = numDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getNumDepartamento() {
        return this.numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getNomeDepartamento() {
        return this.nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public Collection<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(Collection<Empregado> empregados) {
        this.empregados = empregados;
    }

 
}
