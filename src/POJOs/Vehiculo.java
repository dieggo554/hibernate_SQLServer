package POJOS;
// Generated 01-abr-2014 21:28:42 by Hibernate Tools 3.2.1.GA

import java.util.Date;


/** * @author María José Galán López */
public class Vehiculo implements java.io.Serializable {
    private String nss;
    private String matricula;
    private String marca;
    private String modelo;
    private Date datacompra;
    private Empregado empregado;

    public Vehiculo() {
    }
    //Métodos setter e getter
    
    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmp(Empregado emp) {
        this.empregado = emp;
    }

    public Vehiculo(String matricula, String marca, String modelo, Date dataCompra) {

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.datacompra = dataCompra;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }

    public String getNss() {
        return this.nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDatacompra() {
        return this.datacompra;
    }

    public void setDatacompra(Date dataCompra) {
        this.datacompra = dataCompra;
    }
}
