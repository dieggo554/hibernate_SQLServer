package POJOS;
// Generated 01-abr-2014 18:24:58 by Hibernate Tools 3.2.1.GA

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author María José Galán López
 */
public class Empregado implements java.io.Serializable {

    private String nss;
    private String nome;
    private String apelido1;
    private String apelido2;
    private Date dataNacemento;
    private Double salario;
    private Character sexo;
    private Enderezo  enderezo;
    private SortedSet<HorasExtras> horasextras = new TreeSet();
    private Set<Telefono> telefonos = new HashSet(0);
    private Vehiculo vehiculo;
    private Set<Proxecto> proxectos = new HashSet();
    private Departamento deptpertenece;
    private Empregado jefe;
    private Collection <Empregado> supervisados = new ArrayList();

    public Empregado() {
    }

    public Empregado(String nss, String nome, String apelido1, String apelido2, Double salario, Character sexo, Enderezo enderezo, Vehiculo vehiculo) {
        this.nss = nss;
        this.nome = nome;
        this.apelido1 = apelido1;
        this.apelido2 = apelido2;
        this.salario = salario;
        this.sexo = sexo;
        this.enderezo = enderezo;
        this.vehiculo = vehiculo;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido1() {
        return apelido1;
    }

    public void setApelido1(String apelido1) {
        this.apelido1 = apelido1;
    }

    public String getApelido2() {
        return apelido2;
    }

    public void setApelido2(String apelido2) {
        this.apelido2 = apelido2;
    }

    public Date getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(Date dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Enderezo getEnderezo() {
        return enderezo;
    }

    public void setEnderezo(Enderezo enderezo) {
        this.enderezo = enderezo;
    }

    public SortedSet<HorasExtras> getHorasextras() {
        return horasextras;
    }

    public void setHorasextras(SortedSet<HorasExtras> horasextras) {
        this.horasextras = horasextras;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Set<Proxecto> getProxectos() {
        return proxectos;
    }

    public void setProxectos(Set<Proxecto> proxectos) {
        this.proxectos = proxectos;
    }

    public Departamento getDeptpertenece() {
        return deptpertenece;
    }

    public void setDeptpertenece(Departamento deptpertenece) {
        this.deptpertenece = deptpertenece;
    }

    public Empregado getJefe() {
        return jefe;
    }

    public void setJefe(Empregado jefe) {
        this.jefe = jefe;
    }

    public Collection<Empregado> getSupervisados() {
        return supervisados;
    }

    public void setSupervisados(Collection<Empregado> supervisados) {
        this.supervisados = supervisados;
    }

    @Override
    public String toString() {
        return "Empregado{" + "nss=" + nss + ", nome=" + nome + ", apelido1=" + apelido1 + ", apelido2=" + apelido2 + ", dataNacemento=" + dataNacemento + ", salario=" + salario + ", sexo=" + sexo + '}';
    }
}
