/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author usuario
 */
public class EmpregadoProxecto implements Serializable{
    private EmpregadoProxectoId id;
    private int horas;
    private Empregado empregado;
    private Proxecto proxecto;

    public EmpregadoProxecto() {
    }
    
    public EmpregadoProxecto(int horas) {
        this.horas = horas;
    }
  
    public EmpregadoProxectoId getId() {
        return id;
    }

    public void setId(EmpregadoProxectoId id) {
        this.id = id;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public Proxecto getProxecto() {
        return proxecto;
    }

    public void setProxecto(Proxecto proxecto) {
        this.proxecto = proxecto;
    }
}
