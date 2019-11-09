/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOs;

import java.util.Date;

/**
 *
 * @author usuario
 */

//9A1
public class Vehiculo {
    private String NSS_Propietario;
    private String matricula;
    private String marca;
    private String modelo;
    private Date dataCompra;
    private Empregado empregado;

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }
    

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String marca, String modelo, Date dataCompra) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.dataCompra = dataCompra;
    }

    public void setNSS_Propietario(String NSS_Propietario) {
        this.NSS_Propietario = NSS_Propietario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getNSS_Propietario() {
        return NSS_Propietario;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }
}
