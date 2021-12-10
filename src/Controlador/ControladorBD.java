/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
import Modelo.Clientes;
import Modelo.EstadisticasClientes;
import Modelo.FacturasCab;
import Modelo.FacturasTot;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author raulv
 */
public class ControladorBD {
    Session ss;
    Transaction tx;
    
    public ControladorBD() {}
    
    public List<Articulos> cargarArticulos(){
        iniciaOperacion();
        String hql = "FROM Articulos AS A ORDER BY referencia";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }
    
    public List<Clientes> cargarClientes(){
        iniciaOperacion();
        String hql = "FROM Clientes AS C ORDER BY dnicif";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }
    
    public List<FacturasCab> cargarFacturas(){
        iniciaOperacion();
        String hql = "FROM FacturasCab AS F ORDER BY numfac";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }
    
    /*public List<FacturasCab> cargarOfertas(){
        
    }*/
    
    public List<EstadisticasClientes> cargarEstadisticas(){
        iniciaOperacion();
        String hql = "FROM EstadisticasClientes AS E";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
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
