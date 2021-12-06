package Controlador;

import Modelo.Clientes;
import java.util.ArrayList;
import java.util.List;
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

    private void iniciaOperacion() throws HibernateException {
        ss = NewHibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
    }

    private void cerrarOperacion() throws HibernateException {
        tx.commit();
        ss.close();
    }
}