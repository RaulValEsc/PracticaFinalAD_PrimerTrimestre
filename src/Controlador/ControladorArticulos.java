/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raulv
 */
public class ControladorArticulos {

    Session ss;
    Transaction tx;

    public ControladorArticulos() {
    }

    public boolean anadirArticulos(Articulos a) {
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

    public boolean borrarArticulos(Articulos a) {
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

    public boolean modificarArticulos(Articulos a) {
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

    public List<Articulos> filtrarArticulos(List<Articulos> lista, int campo, String filtro) {
        List<Articulos> listaFiltrada = new ArrayList();
        switch (campo) {
            case 0: {
                for (Articulos a : lista) {
                    if (a.getReferencia().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(a);
                    }
                }
            }
            case 1: {
                for (Articulos a : lista) {
                    if (a.getDescripcion().toUpperCase().startsWith(filtro.toUpperCase())) {
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
