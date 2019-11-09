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
public class EmpregadoFixo extends Empregado {
    
    private Date dataalta;
    private float salario;
    private String categoria;

    public EmpregadoFixo(Date dataalta, String categoria, String nss, String nome, String apelido1, String apelido2, Date dataNacemento, Double salario, char sexo) {
        super(nss, nome, apelido1, apelido2, dataNacemento, salario, sexo);
        this.dataalta = dataalta;
        this.categoria = categoria;
    }

    public Date getDataalta() {
        return dataalta;
    }

    public void setDataalta(Date dataalta) {
        this.dataalta = dataalta;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
