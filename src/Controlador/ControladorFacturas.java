/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import Modelo.FacturasCab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class ControladorFacturas {

    Session ss;
    Transaction tx;

    public ControladorFacturas() {
    }

    public boolean anadirCabecera(FacturasCab c) {
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

    public boolean borrarCabecera(FacturasCab c) {
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

    public boolean modificarCabecera(FacturasCab c) {
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

    public List<FacturasCab> filtrarCabecera(List<FacturasCab> lista, String filtro) {
        List<FacturasCab> listaFiltrada = new ArrayList();
        for (FacturasCab c : lista) {
            if (Long.toString(c.getNumfac()).toUpperCase().startsWith(filtro.toUpperCase())) {
                listaFiltrada.add(c);
            }
        }
        return listaFiltrada;
    }

    public int ultimoNumFac(){
        Connection conexion;
        int idmax;
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(numfac)+1 AS numero FROM FACTURAS_CAB");
            rs.next();
            idmax=rs.getInt("numero");
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return -1;
        }
        return idmax;
    }
    
    public int ultimoNumLinFac(FacturasCab f){
        Connection conexion;
        int idmax;
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(lineafac)+1 AS numero FROM FACTURAS_LIN WHERE NUMFAC = "+f.getNumfac());
            rs.next();
            idmax=rs.getInt("numero");
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return -1;
        }
        return idmax;
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
