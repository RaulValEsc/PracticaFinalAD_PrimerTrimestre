package Controlador;

import Modelo.Articulos;
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

    public boolean anadirClientes(Clientes a) {
        try {
            iniciaOperacion();
            ss.save(a);
        } catch (HibernateException he) {
            System.out.println("Error = " + he.getMessage());
            return false;
        } finally {
            cerrarOperacion();
        }
        return true;
    }

    public boolean borrarClientes(Clientes a) {
        try {
            iniciaOperacion();
            ss.delete(a);
        } catch (HibernateException he) {
            System.out.println("Error = " + he.getMessage());
            return false;
        } finally {
            cerrarOperacion();
        }
        return true;
    }

    public boolean modificarClientes(Clientes a) {
        try {
            iniciaOperacion();
            ss.update(a);
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
                for (Clientes a : lista) {
                    if (a.getReferencia().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(a);
                    }
                }
            }
            case 1: {
                for (Clientes a : lista) {
                    if (a.getDescripcion().startsWith(filtro)) {
                        listaFiltrada.add(a);
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
