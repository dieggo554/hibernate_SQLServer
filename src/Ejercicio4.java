
import Hibernate.HibernateUtil;
import POJOs.Empregado;
import POJOs.EmpregadoFixo;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Ejercicio10 {
    public static void main(String[] args) {
        //("9999999E", "Pancharcho", "Habichuela", "Clasmeldeles", new Date(1992, 4, 15), 1000.0, 'H'
        EmpregadoFixo eFixo = new EmpregadoFixo(new Date(01/01/2019), "Becario", "1234567Z", "Json", "Fernandez", "Alfonsez", new Date(01/01/2000), 850.0, 'H');
        crearEmpregadoFixo(eFixo);
    }

    private static void crearEmpregadoFixo(EmpregadoFixo eFixo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;

        try {
            tr = sesion.beginTransaction();
            sesion.save(eFixo);
            tr.commit();
            System.out.println("Empregado insertado con exito");

        } catch (HibernateException ex) {
            System.out.println("Erro ao insertar un novo empregado:" + ex.getMessage());
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            sesion.close();
        }
    }
    
}

//ALTER TABLE EMPREGADO DROP COLUMN Salario
//
//CREATE TABLE EmpregadoFixo (
//    NSS varchar(15) not null,
//    dataalta Date,
//    salario float,
//    categoaria varchar(30),
//    CONSTRAINT FK_EMPREGADOFIXO_EMPREGADO FOREIGN KEY (NSS) REFERENCES EMPREGADO(NSS),
//    CONSTRAINT PK_EMPREGADOFIXO PRIMARY KEY (NSS))
//
//CREATE TABLE EmpregadoTemporal (
//    NSS varchar(15) not null,
//    datainicio Date,
//    datafin Date,
//    costehora float,
//    numhoras float,
//    CONSTRAINT FK_EMPREGADOTEMPORAL_EMPREGADO FOREIGN KEY (NSS) REFERENCES EMPREGADO(NSS),
//    CONSTRAINT PK_EMPREGADOTEMPORAL PRIMARY KEY (NSS))