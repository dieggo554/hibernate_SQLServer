/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateUtil;
import POJOs.Departamento;
import POJOs.Empregado;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class Ejercicio6 {

    public static void main(String[] args) {
//        conexion();
//        insertarDepartamento("NovoDepartamento");
//        insertarEmpregado(new Empregado("5555555A", "Paco", "Abichuela", "Clasmeldeles", new Date(1992, 4, 15), 900.0, 'H'));
//        visualizarEmpregado("5555555A");
//        borrarDepartamento(1);
        cambiarNomeDepartamento(1, "Dep Renomeado");
    }

    public static void conexion() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (sesion == null) {
            System.out.println("Sesion creada con exito");
        } else {
            System.out.println("Fallo na creación da sesión");
        }
    }

    public static void insertarDepartamento(String nome_departamento) {
        Departamento nuevo = new Departamento();
        nuevo.setNomeDepartamento(nome_departamento);

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = sesion.beginTransaction();

        try {

            sesion.save(nuevo);

            tx.commit();

        } catch (HibernateException ex) {
            tx.rollback();
        }

        sesion.close();
    }

    public static void insertarEmpregado(Empregado empregado) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Transaction tx = sesion.beginTransaction();

        try {

            sesion.save(empregado);

            tx.commit();

        } catch (HibernateException ex) {
            tx.rollback();
        }

        sesion.close();
    }

    private static void visualizarEmpregado(String nss) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
        System.out.println(emp);
    }

    private static void borrarDepartamento(int id) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Transaction tr = sesion.beginTransaction();

        try {

            Departamento dep = (Departamento) sesion.get(Departamento.class, id);

            sesion.delete(dep);

            tr.commit();

        } catch (HibernateException ex) {
            tr.rollback();
        }
        
        sesion.close();
    }

    private static void cambiarNomeDepartamento(int id, String novoNome) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        Transaction tr = sesion.beginTransaction();
        
        try{
            
            Departamento dep = (Departamento) sesion.get(Departamento.class, id);
            
            if (dep != null){
                dep.setNomeDepartamento(novoNome);
                tr.commit();
            }
            
        }catch (HibernateException ex){
            tr.rollback();
        }
        
        sesion.close();
    }
}
