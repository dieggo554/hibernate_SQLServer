/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Hibernate.HibernateUtil;
import POJOs.Empregado;
import POJOs.Telefono;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class Ejercicio7 {

    public static void main(String[] args) {
////        7A4
//        Set<String> telefonos = new HashSet<>();
//        telefonos.add("123456789");
//        telefonos.add("987654321");
//        Empregado emp = new Empregado("6666666B", "Maria", "Abichuela", "Clasmeldeles", new Date(1992, 4, 15), 1000.0, 'M');
//        crearEmpregado(emp, telefonos);
//
////        7A5
//        engadirTelefono("6666666B", "789456123"); //si o numero e repetido non se produce ningun erro
//
////        7A6
//        borrarEmpregado("6666666B");
//        
////        7A7
//        engadirTelefonoEInformacion("6666666B", "32165497", "movil");
//        
////        7B2
//        Empregado emp = new Empregado("7777777C", "Arturo", "Abichuela", "Clasmeldeles", new Date(1992, 4, 15), 1000.0, 'H');
//        Map<String, String> telefonos = new HashMap<>();
//        telefonos.put("963852741", "Casa");
//        telefonos.put("147258369", "Movil");
//        engadirEmpregado(emp, telefonos);
//        
////        7B3
//        Map<String, String> mapaTelefonos = new HashMap<>();
//        mapaTelefonos.put("963852741", "Casa");
//        mapaTelefonos.put("147258369", "Movil");
//        
//        engadirTelefono("5555555A", mapaTelefonos);

////        7C2
//        Empregado emp = new Empregado("8888888D", "Lucia", "Abichuela", "Clasmeldeles", new Date(1992, 4, 15), 1000.0, 'M');
//        Collection<Telefono> telefonos = new ArrayList<>();
//        telefonos.add(new Telefono("951623847", "Casa"));
//        telefonos.add(new Telefono("159263487", "Movil"));
//        engadirEmpregado(emp, telefonos);
//        
////        7C3
//        borrarTelefono("6666666B", "123456789");
//        
////        7D2
//        Empregado emp = new Empregado("9999999D", "Juana", "Abichuela", "Clasmeldeles", new Date(1992, 4, 15), 1000.0, 'M');
//        List<Telefono> telefonos = new ArrayList<>();
//        telefonos.add(new Telefono("968357241", "Casa"));
//        telefonos.add(new Telefono("142753869", "Movil"));
//        
//        engadirEmpregado(emp, telefonos);
//        
////        7D3
//        engadirTelefono("9999999D", new Telefono("11111111", "Oficina"));
//        
//        7E4
        engadirHoras("9999999D", new Date(2019, 1, 03), 4);
    }
//
//    //        7A4
//    private static void crearEmpregado(Empregado empregado, Set<String> telefonos) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = null;
//        
//        empregado.setTelefonos(telefonos);
//
//        for (String string : telefonos) {
//            System.out.println(string);
//        }
//
//        try {
//
//            tr = sesion.beginTransaction();
//            sesion.save(empregado);
//            tr.commit();
//            System.out.println("Empregado insertado con exito");
//
//        } catch (HibernateException ex) {
//            System.out.println("Erro ao insertar un novo empregado:" + ex.getMessage());
//            if (tr != null) {
//                tr.rollback();
//            }
//        } finally {
//            sesion.close();
//        }
//    }
//
////        7A5
//    private static void engadirTelefono(String nss, String telefono) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = null;
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//
//        if (emp != null) {
//            try {
//
//                tr = sesion.beginTransaction();
//                Set<String> lista = emp.getTelefonos();
//                lista.add(telefono);
//                tr.commit();
//                System.out.println("Numero engadido con exito");
//
//            } catch (HibernateException ex) {
//                System.out.println("Erro ao engadir o numero ao empregado:" + ex.getMessage());
//                if (tr != null) {
//                    tr.rollback();
//                }
//            }
//        } else {
//            System.out.println("Non existe o empregado: " + nss);
//        }
//        sesion.close();
//    }
//    
////        7A6
//    private static void borrarEmpregado(String nss) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = null;
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//
//        if (emp != null) {
//            try {
//
//                tr = sesion.beginTransaction();
//                sesion.delete(emp);
//                tr.commit();
//                System.out.println("Empregado borrado con exito");
//
//            } catch (HibernateException ex) {
//                System.out.println("Erro ao borrar o empregado:" + ex.getMessage());
//                if (tr != null) {
//                    tr.rollback();
//                }
//            }
//        } else {
//            System.out.println("Non existe o empregado: " + nss);
//        }
//        sesion.close();
//    }
//
////        7A7
//    private static void engadirTelefonoEInformacion(String nss, String telefono, String descripcion) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = null;
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//        
//        if (nss != null){
//            try {
//                tr = sesion.beginTransaction();
//                Set<Telefono> lista = emp.getTelefonos();
//                lista.add(new Telefono(telefono, descripcion));
//                tr.commit();
//                System.out.println("Numero e informacion engadidos con exito");
//
//            } catch (HibernateException ex) {
//                System.out.println("Erro ao engadir o numero coa informacion ao empregado:" + ex.getMessage());
//                if (tr != null) {
//                    tr.rollback();
//                }
//            }
//        }else {
//            System.out.println("Non existe o empregado: " + nss);
//        }
//        sesion.close();
//    }
//    
////      7B2
//
//    private static void engadirEmpregado(Empregado emp, HashMap<String, String> telefonos) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        emp.setTelefonos(telefonos);
//        Transaction tx = sesion.beginTransaction();
//
//        try {
//            sesion.save(emp);
//            tx.commit();
//            System.out.println("Empleado con telefonos engadido correctamente");
//        } catch (HibernateException ex) {
//            tx.rollback();
//            System.out.println("Erro o engadir");
//        } finally {
//            if (sesion != null) {
//                sesion.close();
//            }
//        }
//    }
//
////    7B3
//    private static void engadirTelefono(String nss, Map<String, String> telefonos) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//        Map tlfActuales = emp.getTelefonos();
//        emp.setTelefonos(mezclarTelefonos(tlfActuales, telefonos));
//        Transaction tx = sesion.beginTransaction();
//
//        try {
//            tx.commit();
//            System.out.println("Telefonos engadidos correctamente");
//        } catch (HibernateException ex) {
//            tx.rollback();
//            System.out.println("Erro o engadir");
//        } finally {
//            if (sesion != null) {
//                sesion.close();
//            }
//        }
//    }
//
//    private static Map<String, String> mezclarTelefonos(Map tlfActuales, Map<String, String> telefonos) {
//        for (Map.Entry<String, String> entry : telefonos.entrySet()) {
//            String string = entry.getKey();
//            String string1 = entry.getValue();
//            tlfActuales.put(string, string1);
//        }
//        return tlfActuales;
//    }
//    
////    7C2
//    private static void engadirEmpregado(Empregado emp, Collection<Telefono> telefonos) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        emp.setTelefonos(telefonos);
//        Transaction tx = sesion.beginTransaction();
//
//        try {
//            sesion.save(emp);
//            tx.commit();
//            System.out.println("Empleado con telefonos engadido correctamente");
//        } catch (HibernateException ex) {
//            tx.rollback();
//            System.out.println("Erro o engadir");
//        } finally {
//            if (sesion != null) {
//                sesion.close();
//            }
//        }
//    }
//
////    7C2
//
//    private static void borrarTelefono(String nss, String tlf) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Transaction tr = null;
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//
//        if (nss != null) {
//            try {
//                tr = sesion.beginTransaction();
//
//                recorrerYborrarTelefono(emp.getTelefonos(), tlf);
//                
//                tr.commit();
//                System.out.println("Numero e informacion engadidos con exito");
//
//            } catch (HibernateException ex) {
//                System.out.println("Erro ao engadir o numero coa informacion ao empregado:" + ex.getMessage());
//                if (tr != null) {
//                    tr.rollback();
//                }
//            }
//        } else {
//            System.out.println("Non existe o empregado: " + nss);
//        }
//        sesion.close();
//    }
//
//    private static void recorrerYborrarTelefono(Collection<Telefono> telefonos, String tlf) {
//        Iterator iterador = telefonos.iterator();
//        boolean encontrado = false;
//        Telefono telefono;
//        while(encontrado == false && iterador.hasNext()){
//            telefono =(Telefono) iterador.next();
//            if (telefono.getTelefono().equalsIgnoreCase(tlf)){
//                iterador.remove();
//                encontrado = true;
//            }
//        }
//    }
//
////    7D2
//    private static void engadirEmpregado(Empregado emp, List<Telefono> telefonos) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        emp.setTelefonos(telefonos);
//        Transaction tx = sesion.beginTransaction();
//
//        try {
//            sesion.save(emp);
//            tx.commit();
//            System.out.println("Empleado con telefonos engadido correctamente");
//        } catch (HibernateException ex) {
//            tx.rollback();
//            System.out.println("Erro o engadir");
//        } finally {
//            if (sesion != null) {
//                sesion.close();
//            }
//        }
//    }
//
////    7D3
//    private static void engadirTelefono(String nss, Telefono telefono) {
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//        Empregado emp = (Empregado) sesion.get(Empregado.class, nss);
//        if (emp != null) {
//            emp.getTelefonos().add(telefono);
//            Transaction tx = sesion.beginTransaction();
//
//            try {
//                tx.commit();
//                System.out.println("Telefonos engadidos correctamente");
//            } catch (HibernateException ex) {
//                tx.rollback();
//                System.out.println("Erro o engadir, confirme que o telefono non está repetido para o empregado");
//            }
//        } else {
//            System.out.println("Non existe o empregado");
//        }
//        if (sesion != null) {
//            sesion.close();
//        }
//    }
//    
//    7E4
    private static void engadirHoras(String d, Date date, int i) {
//        AQUI!!
    }
}
//
////TABLA TELEFONO 7A1
//CREATE TABLE TELEFONO(
//    NSS varchar(15) not null,
//    telefono char(9),
//    CONSTRAINT FK_TELEFONO_EMPREGADO FOREIGN KEY (NSS) REFERENCES EMPREGADO (NSS),
//    CONSTRAINT PK_TELEFONO_NSS_Telefono PRIMARY KEY (NSS, telefono)
//);
//
////7A7
//ALTER TABLE TELEFONO
//ADD informacion varchar(30) null;
//
////7D1
//ALTER TABLE TELEFONO
//DROP CONSTRAINT PK_TELEFONO_NSS_Telefono
//
//DELETE FROM TELEFONO
//
//ALTER TABLE TELEFONO
//ADD id INTEGER not null
//
//ALTER TABLE TELEFONO
//ADD CONSTRAINT PK_TELEFONO_NSS_id PRIMARY KEY (NSS, id)
//
//ALTER TABLE TELEFONO
//ADD CONSTRAINT U_TELEFONO_NSS_TELEFONO UNIQUE (NSS, TELEFONO)
//
////  7E2
//CREATE TABLE HORASEXTRA (
//    id int not null,
//    NSS varchar(15) not null,
//    data date not null,
//    horas float not null,
//    CONSTRAINT PK_HORASEXTRA_ID PRIMARY KEY (id),
//    CONSTRAINT FK_HORASEXTRA_EMPREGADO FOREIGN KEY (NSS) REFERENCES EMPREGADO (NSS),
//    CONSTRAINT U_HORASEXTRA_NSS_DATA UNIQUE (NSS, data))

