/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Articulos;
import Modelo.Clientes;
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
        String hql = "FROM Clientes AS C";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }
    
    public List<FacturasTot> cargarFacturas(){
        iniciaOperacion();
        String hql = "FROM FacturasTot AS F";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }
    
    /*public List<FacturasTot> cargarOfertas(){
        
    }*/
    
    private void iniciaOperacion() throws HibernateException {
        ss = NewHibernateUtil.getSessionFactory().openSession();
        tx = ss.beginTransaction();
    }

    private void cerrarOperacion() throws HibernateException {
        tx.commit();
        ss.close();
    }
}
