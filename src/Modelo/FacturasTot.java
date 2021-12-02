package Modelo;
// Generated 29-nov-2021 20:41:28 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * FacturasTot generated by hbm2java
 */
public class FacturasTot  implements java.io.Serializable {


     private long numfac;
     private FacturasCab facturasCab;
     private BigDecimal baseimp;
     private BigDecimal impDto;
     private BigDecimal impIva;
     private BigDecimal totalfac;

    public FacturasTot() {
    }

	
    public FacturasTot(FacturasCab facturasCab) {
        this.facturasCab = facturasCab;
    }
    public FacturasTot(FacturasCab facturasCab, BigDecimal baseimp, BigDecimal impDto, BigDecimal impIva, BigDecimal totalfac) {
       this.facturasCab = facturasCab;
       this.baseimp = baseimp;
       this.impDto = impDto;
       this.impIva = impIva;
       this.totalfac = totalfac;
    }
   
    public long getNumfac() {
        return this.numfac;
    }
    
    public void setNumfac(long numfac) {
        this.numfac = numfac;
    }
    public FacturasCab getFacturasCab() {
        return this.facturasCab;
    }
    
    public void setFacturasCab(FacturasCab facturasCab) {
        this.facturasCab = facturasCab;
    }
    public BigDecimal getBaseimp() {
        return this.baseimp;
    }
    
    public void setBaseimp(BigDecimal baseimp) {
        this.baseimp = baseimp;
    }
    public BigDecimal getImpDto() {
        return this.impDto;
    }
    
    public void setImpDto(BigDecimal impDto) {
        this.impDto = impDto;
    }
    public BigDecimal getImpIva() {
        return this.impIva;
    }
    
    public void setImpIva(BigDecimal impIva) {
        this.impIva = impIva;
    }
    public BigDecimal getTotalfac() {
        return this.totalfac;
    }
    
    public void setTotalfac(BigDecimal totalfac) {
        this.totalfac = totalfac;
    }




}

