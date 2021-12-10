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
import Modelo.FacturasLin;
import Modelo.FacturasLinId;
import Modelo.FacturasTot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author raulv
 */
public class ControladorBD {

    Session ss;
    Transaction tx;

    public ControladorBD() {
    }

    public List<Articulos> cargarArticulos() {
        iniciaOperacion();
        String hql = "FROM Articulos AS A ORDER BY referencia";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }

    public List<Clientes> cargarClientes() {
        iniciaOperacion();
        String hql = "FROM Clientes AS C ORDER BY dnicif";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }

    public List<FacturasCab> cargarFacturas() {
        iniciaOperacion();
        String hql = "FROM FacturasCab AS F ORDER BY numfac";
        Query query = ss.createQuery(hql);
        List results = query.list();
        ss.close();
        return results;
    }

    private String leerFichero() {
        String json = "";
        FileReader reader = null;
        File f = new File("Ofertas.json");
        if (f.exists()) {
            try {
                List<FacturasCab> lista = new ArrayList<>();
                reader = new FileReader(f);
                StringBuilder sb = new StringBuilder();
                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                json = sb.toString();
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error : " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Error : " + ex.getMessage());
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println("Error : " + ex.getMessage());
                }
            }
        }
        return json;
    }

    public List<FacturasCab> cargarOfertas() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String json = leerFichero();
        if (json.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<FacturasCab> lista = new ArrayList<>();

            JSONArray jsonArray = new JSONArray(json);
            for (int x = 0; x < jsonArray.length(); x++) {

                JSONObject fact = jsonArray.getJSONObject(x);

                String nombre = fact.getString("NombreCli");
                JSONObject total = fact.getJSONObject("Totales");
                Long desctTotal = total.getLong("DescuentoTotal");
                Long baseTot = total.getLong("BaseTotal");
                Long totalFac = total.getLong("Total");
                Long ivaTot = total.getLong("IvaTotal");
                String dni = fact.getString("DNI");
                Long numFac = fact.getLong("numfac");
                String fecha = fact.getString("fechafac");
                FacturasTot ft = new FacturasTot();
                ft.setBaseimp(new BigDecimal(baseTot));
                ft.setImpDto(new BigDecimal(desctTotal));
                ft.setImpIva(new BigDecimal(ivaTot));
                ft.setTotalfac(new BigDecimal(totalFac));

                FacturasCab f = new FacturasCab();
                f.setNumfac(numFac);
                f.setClientes(new Clientes(dni, nombre));
                f.setFacturasTot(ft);
                try {
                    f.setFechafac(formato.parse(fecha));
                } catch (ParseException ex) {
                    System.out.println("Error : " + ex.getMessage());
                }

                List<FacturasLin> listaLineas = new ArrayList<>();
                JSONArray facLin = fact.getJSONArray("LineasFactura");
                for (Object o : facLin) {
                    FacturasLin fl = new FacturasLin();
                    JSONObject lin = (JSONObject) o;
                    Long linea = lin.getLong("LineaFactura");
                    Long cant = lin.getLong("Cantidad");
                    Long desc = lin.getLong("Descuento");
                    Long subtotal = lin.getLong("Subtotal");
                    String descripcion = lin.getString("Descripcion");
                    String ref = lin.getString("Referencia");
                    Long precio = lin.getLong("Precio");
                    FacturasLinId id = new FacturasLinId(f.getNumfac(), linea);
                    fl.setId(id);
                    Articulos a = new Articulos();
                    a.setReferencia(ref);
                    a.setDescripcion(descripcion);
                    a.setPrecio(new BigDecimal(precio));
                    fl.setArticulos(a);
                    fl.setFacturasCab(f);
                    fl.setCantidad(new BigDecimal(cant));
                    fl.setPrecio(new BigDecimal(precio));
                    fl.setDtolinea(new BigDecimal(desc));
                    listaLineas.add(fl);
                }
                Set<FacturasLin> setFact = new HashSet<>(listaLineas);
                f.setFacturasLins(setFact);
                lista.add(f);
            }
            return lista;
        }
    }

    public List<EstadisticasClientes> cargarEstadisticas() {
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
