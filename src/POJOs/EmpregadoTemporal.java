/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class EmpregadoTemporal extends Empregado {
    
    private Date datainicio;
    private Date datafin;
    private float costehora;
    private float numhoras;

    public EmpregadoTemporal(Date datainicio, Date datafin, float costehora, float numhoras, String nss, String nome, String apelido1, String apelido2, Date dataNacemento, Double salario, char sexo) {
        super(nss, nome, apelido1, apelido2, dataNacemento, salario, sexo);
        this.datainicio = datainicio;
        this.datafin = datafin;
        this.costehora = costehora;
        this.numhoras = numhoras;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafin() {
        return datafin;
    }

    public void setDatafin(Date datafin) {
        this.datafin = datafin;
    }

    public float getCostehora() {
        return costehora;
    }

    public void setCostehora(float costehora) {
        this.costehora = costehora;
    }

    public float getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(float numhoras) {
        this.numhoras = numhoras;
    }
}
