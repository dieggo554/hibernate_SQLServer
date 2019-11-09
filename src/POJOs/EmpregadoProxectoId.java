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
public class EmpregadoProxectoId implements Serializable{
    private String nssEmpregado;
    private int numProxecto;

    public EmpregadoProxectoId() {
    }

    public EmpregadoProxectoId(String nssEmpregado, int numProxecto) {
        this.nssEmpregado = nssEmpregado;
        this.numProxecto = numProxecto;
    }

    public String getNssEmpregado() {
        return nssEmpregado;
    }

    public void setNssEmpregado(String nssEmpregado) {
        this.nssEmpregado = nssEmpregado;
    }

    public int getNumProxecto() {
        return numProxecto;
    }

    public void setNumProxecto(int numProxecto) {
        this.numProxecto = numProxecto;
    }
}
