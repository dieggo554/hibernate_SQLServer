
import Hibernate.HibernateUtil;
import POJOs.Departamento;
import POJOs.Empregado;
import POJOs.EmpregadoProxecto;
import POJOs.EmpregadoProxectoId;
import POJOs.Proxecto;
import POJOs.Vehiculo;
import java.util.Set;
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
public class Ejercicio9 {

    public static void main(String[] args) {
////  9A2
//        Vehiculo vehiculo = new Vehiculo("3456ABC", "Peugueot", "406", new Date(2018, 2, 4));
//        asignarVehiculo("9999999D", vehiculo);

////  9A3
//        borrarEmpregado("5555555A");
////   9B1 proba
//        designarDirector("7777777C", 2);
////  9C2
//        mostrarProxectos(1);
////  9D2
//        asignarEmpregadoProxecto("7777777C", 1);
//  9D5
        asignarHoras("7777777C", 2, 4);

    }
//
//  9A2

    private static void asignarVehiculo(String nss, Vehiculo vehiculo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empregado empregado = (Empregado) sesion.get(Empregado.class, nss);

        if (empregado != null) {
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();

//                POJO con dynamic-update en Vehiculo.hbm !!!
//                if (empregado.getVehiculo() == null) {
                empregado.setVehiculo(vehiculo);
                vehiculo.setEmpregado(empregado);

//                    Si la relacion no esta en CASCADE hay que guardar ambos objetos
//                    sesion.save(vehiculo);
//                } else {
//                    Vehiculo vehiculoActual = empregado.getVehiculo();
//                    if (vehiculo.getMatricula().equalsIgnoreCase(vehiculoActual.getMatricula())){
//                        vehiculoActual.setMatricula(vehiculo.getMatricula());
//                    }
//                    if (vehiculo.getMarca().equalsIgnoreCase(vehiculoActual.getMarca())){
//                        vehiculoActual.setMarca(vehiculo.getMarca());
//                    }
//                    if (vehiculo.getModelo().equalsIgnoreCase(vehiculoActual.getModelo())){
//                        vehiculoActual.setModelo(vehiculo.getModelo());
//                    }
//                    if (vehiculo.getDataCompra() == vehiculoActual.getDataCompra()){
//                        vehiculoActual.setDataCompra(vehiculo.getDataCompra());
//                    }
//                }
                tr.commit();
                System.out.println("Vehiculo actualizado");
            } catch (HibernateException ex) {
                System.out.println("Erro ao insertar o vehiculo:" + ex.getMessage());
                if (tr != null) {
                    tr.rollback();
                }
            }
        } else {
            System.out.println("Non existe o empregado");
        }
        if (sesion != null) {
            sesion.close();
        }
    }
//    
//  9A3

    private static void borrarEmpregado(String nss) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empregado empregado = (Empregado) sesion.get(Empregado.class, nss);
        Vehiculo vehiculo = null;

        if (empregado != null) {
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();
                //non e necesario comprobar e borrar o vehiculo por cascade="all"
                sesion.delete(empregado);
                tr.commit();
                System.out.println("Empregado eliminado");
            } catch (HibernateException ex) {
                System.out.println("Erro ao borrar o empregado:" + ex.getMessage());
                if (tr != null) {
                    tr.rollback();
                }
            }
        } else {
            System.out.println("Non existe o empregado");
        }
        if (sesion != null) {
            sesion.close();
        }
    }

//    9B2
    private static void designarDirector(String nss, int numDepartamento) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Empregado empregado = (Empregado) sesion.get(Empregado.class, nss);
        Departamento departamento = (Departamento) sesion.get(Departamento.class, numDepartamento);

        if (empregado != null && departamento != null) {
            Transaction tr = null;
            try {
                tr = sesion.beginTransaction();

                departamento.setEmpregado(empregado);

                tr.commit();
                System.out.println("Empregado eliminado");
            } catch (HibernateException ex) {
                System.out.println("Erro ao borrar o empregado:" + ex.getMessage());
                if (tr != null) {
                    tr.rollback();
                }
            }
        } else {
            System.out.println("Non existe o empregado ou o departamento");
        }

        departamento.setEmpregado(empregado);
    }

//    9C2
    private static void mostrarProxectos(int num_departamento) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Departamento departamento = (Departamento) sesion.get(Departamento.class, num_departamento);

        Set<Proxecto> proxectos = departamento.getProxectos();
        for (Proxecto proxecto : proxectos) {
            System.out.println(proxecto.toString());
        }
    }
//
////    9D2
//    private static void asignarEmpregadoProxecto(String nss, int num_proxecto) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Empregado empregado = (Empregado) sesion.get(Empregado.class, nss);
//        Proxecto proxecto = (Proxecto) sesion.get(Proxecto.class, num_proxecto);
//        Transaction tr = null;
//
//        if (proxecto != null) {
//            if (empregado != null) {
//                try {
//                    tr = sesion.beginTransaction();
//
//            //por separado
//                    ////actualiza por donde esta el inverse="true"
//                    Set<Empregado> empregados = proxecto.getEmpregados();
//                    empregados.add(empregado);
//                    ////no funciona por el inverse true(esta en empregado)
//                    Collection<Proxecto> proxectos = empregado.getProxectos();
//                    proxectos.add(proxecto);
//            //
//
//                    tr.commit();
//                } catch (HibernateException ex) {
//                    System.out.println("Erro ao agregar o empregado:" + ex.getMessage());
//                    if (tr != null) {
//                        tr.rollback();
//                    }
//                }
//            } else {
//                System.out.println("Non existe o empregado");
//            }
//        } else {
//            System.out.println("Non existe o proxecto");
//        }
//        sesion.close();
//    }
//    
//    9D5

    private static void asignarHoras(String nss, int num_proxecto, int horas) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Proxecto proxecto = (Proxecto) sesion.get(Proxecto.class, num_proxecto);
        Transaction tr = null;

        if (proxecto != null) {
            Empregado empregado = (Empregado) sesion.get(Empregado.class, nss);
            if (empregado != null) {
                EmpregadoProxecto empregadoProxecto = null;
                try {
                    tr = sesion.beginTransaction();

                    //IMPORTANTISIMO!!!
                    empregadoProxecto = new EmpregadoProxecto(horas);
                    empregadoProxecto.setId(new EmpregadoProxectoId(nss, num_proxecto));

                    empregado.getProxectos().add(empregadoProxecto);
                    proxecto.getEmpregados().add(empregadoProxecto);

                    tr.commit();
                } catch (HibernateException ex) {
                    System.out.println("Erro ao agregar o empregado:" + ex.getMessage());
                    if (tr != null) {
                        tr.rollback();
                    }
                }
            } else {
                System.out.println("Non existe o empregado");
            }
        } else {
            System.out.println("Non existe o proxecto");
        }
        sesion.close();
    }

}
//
////  9A1
//CREATE TABLE VEHICULO (
//    NSS_Propietario varchar(15) not null,
//    Matricula varchar(7) not null,
//    Marca varchar(20) null,
//    Modelo varchar(20) null,
//    DataCompra Date null,
//    CONSTRAINT FK_VEHICULO_EMPREGADO FOREIGN KEY (NSS_Propietario) REFERENCES EMPREGADO (NSS),
//    CONSTRAINT U_VEHICULO UNIQUE (Matricula),
//    CONSTRAINT PK_VEHICULO PRIMARY KEY (NSS_Propietario))
//
//  9B1
//ALTER TABLE DEPARTAMENTO
//ADD Director VARCHAR(15) null
//
//ALTER TABLE DEPARTAMENTO
//ADD CONSTRAINT FK_DEPARTAMENTO_EMPREGADO FOREIGN KEY (Director) REFERENCES EMPREGADO (NSS)
//
//ALTER TABLE DEPARTAMENTO
//ADD CONSTRAINT U_DEPARTAMENTO_DIRECTOR UNIQUE (Director)
//
//9C1
//ALTER PROXECTO
//ADD Num_departamento INTEGER
//
//ALTER TABLE PROXECTO
//ADD CONSTRAINT FK_PROXECTO_CONTROLA FOREIGN KEY (Num_departamento) REFERENCES DEPARTAMENTO (Num_departamento)
//
//9D
//CREATE TABLE EMPREGADO_PROXECTO (
//    NSS_empregado varchar(15) not null,
//    Num_proxecto int not null,
//    CONSTRAINT FK_EMPREGADO_PROXECTO_EMPREGADO FOREIGN KEY (NSS_empregado) REFERENCES EMPREGADO (NSS),
//    CONSTRAINT FK_EMPREGADO_PROXECTO_PROXECTO FOREIGN KEY (Num_proxecto) REFERENCES PROXECTO (Num_proxecto),
//    CONSTRAINT PK_EMPREGADO_PROXECTO PRIMARY KEY (NSS_empregado, Num_proxecto))
//
//9D3
//ALTER TABLE EMPREGADO_PROXECTO
//DROP CONSTRAINT PK_EMPREGADO_PROXECTO
//
//DELETE FROM EMPREGADO_PROXECTO

//ALTER TABLE EMPREGADO_PROXECTO
//ADD id_empregado_proxecto int not null
//
//ALTER TABLE EMPREGADO_PROXECTO
//ADD CONSTRAINT PK_EMPREGADO_PROXECTO PRIMARY KEY (id_empregado_proxecto)
//
//ALTER TABLE EMPREGADO_PROXECTO
//ADD CONSTRAINT U_EMPREGADO_PROXECTO_Num_proxect_NSS_empregado UNIQUE (Num_proxecto, NSS_empregado)
//
//9D4
//DROP TABLE EMPREGADO_PROXECTO
//
//CREATE TABLE EMPREGADO_PROXECTO (
//    NSS_empregado varchar(15) not null,
//    Num_proxecto int not null,
//    CONSTRAINT FK_EMPREGADO_PROXECTO_EMPREGADO FOREIGN KEY (NSS_empregado) REFERENCES EMPREGADO (NSS),
//    CONSTRAINT FK_EMPREGADO_PROXECTO_PROXECTO FOREIGN KEY (Num_proxecto) REFERENCES PROXECTO (Num_proxecto),
//    CONSTRAINT PK_EMPREGADO_PROXECTO PRIMARY KEY (NSS_empregado, Num_proxecto))
//
//ALTER TABLE EMPREGADO_PROXECTO ADD Horas int
