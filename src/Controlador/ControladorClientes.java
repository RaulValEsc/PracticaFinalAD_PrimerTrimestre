package Controlador;

import Modelo.Clientes;
import Modelo.EstadisticasClientes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raulv
 */
public class ControladorClientes {

    Session ss;
    Transaction tx;

    public ControladorClientes() {
    }

    public boolean anadirClientes(Clientes c) {
        try {
            iniciaOperacion();
            ss.save(c);
        } catch (HibernateException he) {
            System.out.println("Error = " + he.getMessage());
            return false;
        } finally {
            cerrarOperacion();
        }
        return true;
    }

    public boolean borrarClientes(Clientes c) {
        try {
            iniciaOperacion();
            ss.delete(c);
        } catch (HibernateException he) {
            System.out.println("Error = " + he.getMessage());
            return false;
        } finally {
            cerrarOperacion();
        }
        return true;
    }

    public boolean modificarClientes(Clientes c) {
        try {
            iniciaOperacion();
            ss.update(c);
        } catch (HibernateException he) {
            System.out.println("Error = " + he.getMessage());
            return false;
        } finally {
            cerrarOperacion();
        }
        return true;
    }

    public List<Clientes> filtrarClientes(List<Clientes> lista, int campo, String filtro) {
        List<Clientes> listaFiltrada = new ArrayList();
        switch (campo) {
            case 0: {
                for (Clientes c : lista) {
                    if (c.getDnicif().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(c);
                    }
                }
            }
            case 1: {
                for (Clientes c : lista) {
                    if (c.getNombrecli().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(c);
                    }
                }
            }
        }
        return listaFiltrada;
    }
    
    public List<EstadisticasClientes> filtrarEstadisticas(List<EstadisticasClientes> lista, int campo, String filtro) {
        List<EstadisticasClientes> listaFiltrada = new ArrayList();
        switch (campo) {
            case 0: {
                for (EstadisticasClientes c : lista) {
                    if (Long.toString(c.getId().getAnio()).toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(c);
                    }
                }
            }
            case 1: {
                for (EstadisticasClientes c : lista) {
                    if (c.getClientes().getDnicif().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(c);
                    }
                }
            }
        }
        return listaFiltrada;
    }
    
    public boolean generarEstadisticas(Clientes c1, Clientes c2, Date fecha1, Date fecha2){
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            String ins = "{call p_GenerarEstadisticas(?,?,?,?)}";
            CallableStatement sentencia = con.prepareCall(ins);
            sentencia.setString(1, c1.getDnicif());
            sentencia.setString(2, c2.getDnicif());
            sentencia.setDate(3, fecha1);
            sentencia.setDate(4, fecha2);
            int i = sentencia.executeUpdate();  
            System.out.println(i);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void iniciaOperacion() throws HibernateException {
        ss = NewHibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
    }

    private void cerrarOperacion() throws HibernateException {
        tx.commit();
        ss.close();
    }
}