package Modelo;
// Generated 29-nov-2021 20:41:28 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * EstadisticasClientes generated by hbm2java
 */
public class EstadisticasClientes  implements java.io.Serializable {


     private EstadisticasClientesId id;
     private Clientes clientes;
     private String mesNom;
     private String nombrecli;
     private BigDecimal sumaBase;
     private BigDecimal sumaDtos;
     private BigDecimal sumaIva;
     private BigDecimal sumaTotales;

    public EstadisticasClientes() {
    }

	
    public EstadisticasClientes(EstadisticasClientesId id, Clientes clientes, String mesNom, String nombrecli) {
        this.id = id;
        this.clientes = clientes;
        this.mesNom = mesNom;
        this.nombrecli = nombrecli;
    }
    public EstadisticasClientes(EstadisticasClientesId id, Clientes clientes, String mesNom, String nombrecli, BigDecimal sumaBase, BigDecimal sumaDtos, BigDecimal sumaIva, BigDecimal sumaTotales) {
       this.id = id;
       this.clientes = clientes;
       this.mesNom = mesNom;
       this.nombrecli = nombrecli;
       this.sumaBase = sumaBase;
       this.sumaDtos = sumaDtos;
       this.sumaIva = sumaIva;
       this.sumaTotales = sumaTotales;
    }
   
    public EstadisticasClientesId getId() {
        return this.id;
    }
    
    public void setId(EstadisticasClientesId id) {
        this.id = id;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public String getMesNom() {
        return this.mesNom;
    }
    
    public void setMesNom(String mesNom) {
        this.mesNom = mesNom;
    }
    public String getNombrecli() {
        return this.nombrecli;
    }
    
    public void setNombrecli(String nombrecli) {
        this.nombrecli = nombrecli;
    }
    public BigDecimal getSumaBase() {
        return this.sumaBase;
    }
    
    public void setSumaBase(BigDecimal sumaBase) {
        this.sumaBase = sumaBase;
    }
    public BigDecimal getSumaDtos() {
        return this.sumaDtos;
    }
    
    public void setSumaDtos(BigDecimal sumaDtos) {
        this.sumaDtos = sumaDtos;
    }
    public BigDecimal getSumaIva() {
        return this.sumaIva;
    }
    
    public void setSumaIva(BigDecimal sumaIva) {
        this.sumaIva = sumaIva;
    }
    public BigDecimal getSumaTotales() {
        return this.sumaTotales;
    }
    
    public void setSumaTotales(BigDecimal sumaTotales) {
        this.sumaTotales = sumaTotales;
    }




}


