
import POJOS.Departamento;
import POJOS.Empregado;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
public class Ejercicio1 {

    public static void main(String[] args) {
////        1A
//        getEmpleadoSalario1(100);
////        1B
//        getEmpleadoSalario2(100
////        2A1
//        getDepartamentos();
////        2B
//        getDepartamentoSueldo(100.0);
////        3A
//        getEmpregadosProxectos();
////        3B
//        getEmpregadosConProxectos();
////        4A
//        aumentarSalariosMaisAltos(15);
//        4B
//        aumentarSalariosMaisProxectos(7);
////        5
//        listarEmpregadosSNTelefono();
////        6A
//        consultarProxectosDepart(1);
////        6B
//        consultarProxectosDepart("TÉCNICO");
//        7
        listarVaronesSupervisores(2500.0, 7000.0);
    }

//        1A
    private static void getEmpleadoSalario1(float salario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("FROM Empregado WHERE salario > :salario");

        consulta.setFloat("salario", salario);

        List<Empregado> lista = consulta.list();

        for (Empregado empregado : lista) {
            System.out.println(empregado.toString());
        }
    }

//    1B
    private static void getEmpleadoSalario2(float salario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("FROM Empregado WHERE salario > :salario");

//        select e.nss, e.nome||' '||e.apelido1||' '||isnull(e.apelido2,''), count(distinct t.telefono), count(distinct p.numProxecto)
//        from Empregado e
//        left join e.telefonos t left join e.proxectos p
//        where e.salario > :salario
//        group by e.nss,e.nome,e.apelido1,e.apelido2
        consulta.setFloat("salario", salario);

        List<Empregado> lista = consulta.list();

        System.out.println("NSS\t\tNombre Completo\t\tnum de telefono\t\tnum de proxecto");
        for (Empregado empregado : lista) {
            System.out.println(empregado.getNss() + "\t\t" + empregado.getNome() + " " + empregado.getApelido1() + " " + empregado.getApelido2() + "\t\t" + empregado.getTelefonos().size() + "\t\t" + empregado.getProxectos().size());
        }
    }

//    2A
    private static void getDepartamentos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT d.numDepartamento, d.nomeDepartamento, size(d.empregados) "
                + "FROM Departamento d "
                + "GROUP BY numDepartamento, nomeDepartamento "
                + "ORDER BY 3 desc ");

        System.out.println("Numero\tNombre\tNum de empleados");
        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.println(fila[0] + "\t" + fila[1] + "\t" + fila[2]);
        }
    }

    //    2B
    private static void getDepartamentoSueldo(Double sueldo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT d.numDepartamento, d.nomeDepartamento, size(e), sum(e.salario) "
                + "FROM Departamento d "
                + "INNER JOIN d.empregados e "
                + "GROUP BY d.numDepartamento, d.nomeDepartamento "
                + "HAVING sum(e.salario)>:salario "
                + "ORDER BY 3 desc");

        consulta.setParameter("salario", sueldo);
        System.out.printf("%5s %14s %25s %15s\n", "Numero", "Nombre", "num de empleados", "total sueldo");

        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%5s %14s %25s %15s\n", fila[0], fila[1], fila[2], fila[3]);
        }
    }

//    3A
    private static void getEmpregadosProxectos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT emp.nss, pro.nomeProxecto "
                + "FROM Empregado emp "
                + "LEFT JOIN emp.proxectos pro ");

        System.out.printf("%-10s %-50s\n", "NSS", "Proxectos");

        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%-10s %-50s\n", fila[0], (fila[1] != null) ? fila[1] : "no tiene proxectos");
        }
    }

//    3B
    private static void getEmpregadosConProxectos() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT emp.nss, pro.nomeProxecto "
                + "FROM Empregado emp "
                + "INNER JOIN emp.proxectos pro "
                + "WHERE size(emp.proxectos) > 1 ");

        System.out.printf("%-10s %-50s\n", "NSS", "Proxectos");

        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%-10s %-50s\n", fila[0], (fila[1] != null) ? fila[1] : "no tiene proxectos");
        }
    }

//    4A
    private static void aumentarSalariosMaisAltos(double porcentaxe) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        int filasAfectadas = 0;
        mostrarNssSalario(sesion);

        try {
            tr = sesion.beginTransaction();

            Query consulta = sesion.createQuery("UPDATE Empregado  "
                    + "                SET salario = salario + (salario * (:porcentaxe/100.0))  "
                    + "                WHERE salario >=ALL (  "
                    + "                SELECT salario "
                    + "                FROM Empregado)");
            consulta.setParameter("porcentaxe", porcentaxe);
            filasAfectadas = consulta.executeUpdate();

            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
        }

        System.out.println("Filas afectadas = " + filasAfectadas);
        mostrarNssSalario(sesion);
    }

    private static void mostrarNssSalario(Session sesion) throws HibernateException {
        Query consulta;
        consulta = sesion.createQuery("SELECT nss, salario "
                + "FROM Empregado "
                + "ORDER BY salario DESC");
        System.out.printf("%-10s %-50s\n", "NSS", "Salario");
        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%-10s %-50s\n", fila[0], (fila[1]));
        }
    }
//    4B

    private static void aumentarSalariosMaisProxectos(double porcentaxe) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        int filasAfectadas = 0;
        mostrarNssSalario(sesion);

        try {
            tr = sesion.beginTransaction();

            Query consulta = sesion.createQuery("UPDATE Empregado e\n"
                    + "SET salario = (salario + (salario * :porcentaxe/100))\n"
                    + "WHERE nss IN (SELECT emp.nss\n"
                    + "FROM Empregado emp\n"
                    + "INNER JOIN emp.proxectos\n"
                    + "GROUP BY emp.nss\n"
                    + "HAVING count(nss) >= ALL (\n"
                    + "	SELECT count(em.nss)\n"
                    + "	FROM Empregado em\n"
                    + "	INNER JOIN em.proxectos\n"
                    + "	GROUP BY em.nss))");
            consulta.setParameter("porcentaxe", porcentaxe);
            filasAfectadas = consulta.executeUpdate();

            tr.commit();
        } catch (Exception ex) {
            tr.rollback();
        }

        System.out.println("Filas afectadas = " + filasAfectadas);
        mostrarNssSalario(sesion);
    }
//  5

    private static void listarEmpregadosSNTelefono() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT emp.nss "
                + "FROM Empregado emp "
                + "INNER JOIN emp.telefonos "
                + "WHERE size(emp.telefonos) < 1 ");

        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%-10s %-50s\n", fila[0]);
        }
    }
//    6A

    private static void consultarProxectosDepart(int numDep) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Departamento dep = (Departamento) sesion.get(Departamento.class, numDep);
        if (dep != null) {

            Query consulta = sesion.createQuery("SELECT pro.numProxecto, pro.nomeProxecto "
                    + "FROM Proxecto pro "
                    + "WHERE pro.numdepartcontrola.numDepartamento = :numDep ");
            consulta.setParameter("numDep", numDep);

            for (Iterator it = consulta.iterate(); it.hasNext();) {
                Object[] fila = (Object[]) it.next();
                System.out.printf("%-10s %-50s\n", fila[0], fila[1]);
            }
        } else {
            System.out.println("Non existe o departamento con codigo " + numDep);
        }
    }
//    6B

    private static void consultarProxectosDepart(String nomeDep) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT numDepartamento "
                + "FROM Departamento "
                + "WHERE nomeDepartamento = :nomeDep ");
        consulta.setParameter("nomeDep", nomeDep);

        Iterator it = consulta.iterate();
        if (it.hasNext()) {
            int numDep = (int) it.next();

            consulta = sesion.createQuery("SELECT pro.numProxecto, pro.nomeProxecto "
                    + "FROM Proxecto pro "
                    + "WHERE pro.numdepartcontrola.numDepartamento = :numDep ");
            consulta.setParameter("numDep", numDep);

            for (it = consulta.iterate(); it.hasNext();) {
                Object[] fila = (Object[]) it.next();
                System.out.printf("%-10s %-50s\n", fila[0], fila[1]);
            }
        } else {
            System.out.println("No existe el departamento " + nomeDep);
        }
    }
//    7

    private static void listarVaronesSupervisores(Double minSueldo, Double maxSueldo) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Query consulta = sesion.createQuery("SELECT emp.nss, emp.sexo, emp.salario "
                + "FROM Empregado emp "
                + "INNER JOIN emp.supervisados "
                + "WHERE emp.sexo = 'H' "
                + "AND emp.salario "
                + "between :minSueldo "
                + "AND :maxSueldo "
                + "GROUP BY emp.nss, emp.sexo, emp.salario ");
        consulta.setParameter("minSueldo", minSueldo);
        consulta.setParameter("maxSueldo", maxSueldo);

        for (Iterator it = consulta.iterate(); it.hasNext();) {
            Object[] fila = (Object[]) it.next();
            System.out.printf("%-10s %-5s %-10s\n", fila[0], fila[1], fila[2]);
        }
    }
}
