/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Clientes;
import Modelo.FacturasCab;
import Modelo.FacturasLin;
import com.sun.xml.internal.txw2.Document;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

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

    public int ultimoNumFac() {
        Connection conexion;
        int idmax;
        try {
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "AD_TEMA_03_FACTURAS", "AD_TEMA_03_FACTURAS");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(numfac)+1 AS numero FROM FACTURAS_CAB");
            rs.next();
            idmax = rs.getInt("numero");
            s.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            return -1;
        }
        if (idmax > 0) {
            return idmax;
        } else {
            return 1;
        }
    }

    public int ultimoNumLinFac(List<FacturasLin> lista) {
        Connection conexion;
        int idmax =0;
        for(FacturasLin f : lista){
            if(f.getId().getLineafac()>idmax){
                idmax = Integer.parseInt(Long.toString(f.getId().getLineafac()));
            }
        }    
        idmax++;
        return idmax;
        
    }

    public List<FacturasCab> filtrarFacturas(List<FacturasCab> lista, int campo, String filtro) {
        List<FacturasCab> listaFiltrada = new ArrayList();
        switch (campo) {
            case 0: {
                for (FacturasCab a : lista) {
                    if (Long.toString(a.getNumfac()).toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(a);
                    }
                }
            }
            case 1: {
                for (FacturasCab a : lista) {
                    if (a.getClientes().getDnicif().toUpperCase().startsWith(filtro.toUpperCase())) {
                        listaFiltrada.add(a);
                    }
                }
            }
        }
        return listaFiltrada;
    }

    public String generarJSONOfertas(List<FacturasCab> lista) {
        JSONArray listaFac = new JSONArray();
        for (FacturasCab f : lista) {
            JSONObject jsn = new JSONObject();
            jsn.put("numfac", f.getNumfac());
            jsn.put("fechafac", f.getFechafac());
            jsn.put("DNI", f.getClientes().getDnicif());
            jsn.put("NombreCli", f.getClientes().getNombrecli());

            JSONArray jsnArray = new JSONArray();
            Iterator i = f.getFacturasLins().iterator();
            while (i.hasNext() == true) {
                FacturasLin fl = (FacturasLin) i.next();
                JSONObject jsnLin = new JSONObject();
                jsnLin.put("LineaFactura", fl.getId().getLineafac());
                jsnLin.put("Referencia", fl.getArticulos().getReferencia());
                jsnLin.put("Descripcion", fl.getArticulos().getDescripcion());
                jsnLin.put("Precio", fl.getPrecio());
                jsnLin.put("Cantidad", fl.getCantidad());
                jsnLin.put("Descuento", fl.getDtolinea());
                Double subtotal = 0.0;
                if (Double.parseDouble(fl.getDtolinea().toString()) > 0) {
                    subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString()) * (Double.parseDouble(fl.getDtolinea().toString()) / 100);
                } else {
                    subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString());
                }
                jsnLin.put("Subtotal", subtotal);

                jsnArray.add(jsnLin);

            }
            jsn.put("LineasFactura", jsnArray);
            JSONArray jsnTotal = new JSONArray();
            JSONObject baseTotal = new JSONObject();
            JSONObject DescuentoTotal = new JSONObject();
            JSONObject IvaTotal = new JSONObject();
            JSONObject Total = new JSONObject();

            baseTotal.put("BaseTotal", f.getFacturasTot().getBaseimp());
            DescuentoTotal.put("DescuentoTotal", f.getFacturasTot().getImpDto());
            IvaTotal.put("IvaTotal", f.getFacturasTot().getImpIva());
            Total.put("Total", f.getFacturasTot().getTotalfac());
            jsnTotal.add(baseTotal);
            jsnTotal.add(DescuentoTotal);
            jsnTotal.add(IvaTotal);
            jsnTotal.add(Total);
            jsn.put("Totales", jsnTotal);
            listaFac.add(jsn);
        }
        return listaFac.toJSONString();
    }

    public String generarJSON(FacturasCab f) {
        JSONObject jsn = new JSONObject();
        jsn.put("numfac", f.getNumfac());
        jsn.put("fechafac", f.getFechafac());
        jsn.put("DNI", f.getClientes().getDnicif());
        jsn.put("NombreCli", f.getClientes().getNombrecli());

        JSONArray jsnArray = new JSONArray();
        Iterator i = f.getFacturasLins().iterator();
        while (i.hasNext() == true) {
            FacturasLin fl = (FacturasLin) i.next();
            JSONObject jsnLin = new JSONObject();
            jsnLin.put("LineaFactura", fl.getId().getLineafac());
            jsnLin.put("Referencia", fl.getArticulos().getReferencia());
            jsnLin.put("Descripcion", fl.getArticulos().getDescripcion());
            jsnLin.put("Precio", fl.getPrecio());
            jsnLin.put("Cantidad", fl.getCantidad());
            jsnLin.put("Descuento", fl.getDtolinea());
            Double subtotal = 0.0;
            if (Double.parseDouble(fl.getDtolinea().toString()) > 0) {
                subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString()) * (Double.parseDouble(fl.getDtolinea().toString()) / 100);
            } else {
                subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString());
            }
            jsnLin.put("Subtotal", subtotal);

            jsnArray.add(jsnLin);

        }
        jsn.put("LineasFactura", jsnArray);
        JSONArray jsnTotal = new JSONArray();
        JSONObject baseTotal = new JSONObject();
        JSONObject DescuentoTotal = new JSONObject();
        JSONObject IvaTotal = new JSONObject();
        JSONObject Total = new JSONObject();

        baseTotal.put("BaseTotal", f.getFacturasTot().getBaseimp());
        DescuentoTotal.put("DescuentoTotal", f.getFacturasTot().getImpDto());
        IvaTotal.put("IvaTotal", f.getFacturasTot().getImpIva());
        Total.put("Total", f.getFacturasTot().getTotalfac());
        jsnTotal.add(baseTotal);
        jsnTotal.add(DescuentoTotal);
        jsnTotal.add(IvaTotal);
        jsnTotal.add(Total);
        jsn.put("Totales", jsnTotal);

        System.out.println(jsn.toJSONString());
        return jsn.toJSONString();
    }

    public void generarXML(FacturasCab f, String ruta) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            org.w3c.dom.Document documento = implementation.createDocument(null, "Raiz", null);
            documento.setXmlVersion("1.0");
            Element facturas = documento.createElement("Facturas");
            Element factCab = documento.createElement("FacturasCab");
            Element factLin = documento.createElement("FacturasLinea");
            Element factTot = documento.createElement("FacturasTotal");
            Element numfac = documento.createElement("Numfac");
            Text txtNumf = documento.createTextNode(String.valueOf(f.getNumfac()));
            factCab.appendChild(numfac);
            Element fechaFac = documento.createElement("FechaFac");
            Text txtFecha = documento.createTextNode(String.valueOf(f.getFechafac()));
            factCab.appendChild(fechaFac);
            Element dni = documento.createElement("Dni");
            Text txtDni = documento.createTextNode(String.valueOf(f.getClientes().getDnicif()));
            factCab.appendChild(dni);
            Element nombre = documento.createElement("NombreCliente");
            Text txtNom = documento.createTextNode(String.valueOf(f.getClientes().getNombrecli()));
            factCab.appendChild(nombre);
            numfac.appendChild(txtNumf);
            fechaFac.appendChild(txtFecha);
            dni.appendChild(txtDni);
            nombre.appendChild(txtNom);
            facturas.appendChild(factCab);
            Iterator i = f.getFacturasLins().iterator();
            while (i.hasNext() == true) {
                FacturasLin fl = (FacturasLin) i.next();
                Element linea = documento.createElement("LineaFactura");
                Element lineaF = documento.createElement("Linea");
                Text txtLinea = documento.createTextNode(String.valueOf(fl.getId().getLineafac()));
                lineaF.appendChild(txtLinea);
                linea.appendChild(lineaF);
                factLin.appendChild(linea);
                Element referencia = documento.createElement("Referencia");
                Text txtRef = documento.createTextNode(String.valueOf(fl.getArticulos().getReferencia()));
                referencia.appendChild(txtRef);
                linea.appendChild(referencia);
                Element desc = documento.createElement("Descripcion");
                Text txtDesc = documento.createTextNode(String.valueOf(fl.getArticulos().getDescripcion()));
                desc.appendChild(txtDesc);
                linea.appendChild(desc);
                Element precio = documento.createElement("Precio");
                Text txtPrecio = documento.createTextNode(String.valueOf(fl.getPrecio()));
                precio.appendChild(txtPrecio);
                linea.appendChild(precio);
                Element cantidad = documento.createElement("Cantidad");
                Text txtCantidad = documento.createTextNode(String.valueOf(fl.getCantidad()));
                cantidad.appendChild(txtCantidad);
                linea.appendChild(cantidad);
                Element descuetno = documento.createElement("Descuento");
                Text txtDescuento = documento.createTextNode(String.valueOf(fl.getDtolinea()));
                descuetno.appendChild(txtDescuento);
                linea.appendChild(descuetno);
                Double subtotal = 0.0;
                if (Double.parseDouble(fl.getDtolinea().toString()) > 0) {
                    subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString()) * (Double.parseDouble(fl.getDtolinea().toString()) / 100);
                } else {
                    subtotal = Double.parseDouble(fl.getPrecio().toString()) * Double.parseDouble(fl.getCantidad().toString());
                }
                Element subtotal2 = documento.createElement("Subtotal");
                Text txtSubtotal = documento.createTextNode(subtotal.toString());
                subtotal2.appendChild(txtSubtotal);
                linea.appendChild(subtotal2);
                facturas.appendChild(factLin);
            }
            Element base = documento.createElement("BaseTotas");
            Text txtBase = documento.createTextNode(f.getFacturasTot().getBaseimp().toString());
            base.appendChild(txtBase);
            factTot.appendChild(base);
            Element descTotal = documento.createElement("DescuentoTotal");
            Text txtDsct = documento.createTextNode(f.getFacturasTot().getImpDto().toString());
            descTotal.appendChild(txtDsct);
            factTot.appendChild(descTotal);
            Element iva = documento.createElement("IvaTotal");
            Text txtIva = documento.createTextNode(f.getFacturasTot().getImpIva().toString());
            iva.appendChild(txtIva);
            factTot.appendChild(iva);
            Element total = documento.createElement("Total");
            Text txtTotal = documento.createTextNode(f.getFacturasTot().getTotalfac().toString());
            total.appendChild(txtTotal);
            factTot.appendChild(total);
            facturas.appendChild(factTot);
            documento.getDocumentElement().appendChild(facturas);
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File(ruta));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
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
