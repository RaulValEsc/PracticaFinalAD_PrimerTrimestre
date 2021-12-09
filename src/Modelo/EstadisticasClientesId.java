package Modelo;
// Generated 29-nov-2021 20:41:28 by Hibernate Tools 4.3.1

/**
 * EstadisticasClientesId generated by hbm2java
 */
public class EstadisticasClientesId implements java.io.Serializable {

    private long anio;
    private long mesNum;
    private String dnicif;

    public EstadisticasClientesId() {
    }

    public EstadisticasClientesId(long anio, long mesNum, String dnicif) {
        this.anio = anio;
        this.mesNum = mesNum;
        this.dnicif = dnicif;
    }

    public long getAnio() {
        return this.anio;
    }

    public void setAnio(long anio) {
        this.anio = anio;
    }

    public long getMesNum() {
        return this.mesNum;
    }

    public void setMesNum(long mesNum) {
        this.mesNum = mesNum;
    }

    public String getDnicif() {
        return this.dnicif;
    }

    public void setDnicif(String dnicif) {
        this.dnicif = dnicif;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }
        if ((other == null)) {
            return false;
        }
        if (!(other instanceof EstadisticasClientesId)) {
            return false;
        }
        EstadisticasClientesId castOther = (EstadisticasClientesId) other;

        return (this.getAnio() == castOther.getAnio())
                && (this.getMesNum() == castOther.getMesNum())
                && ((this.getDnicif() == castOther.getDnicif()) || (this.getDnicif() != null && castOther.getDnicif() != null && this.getDnicif().equals(castOther.getDnicif())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (int) this.getAnio();
        result = 37 * result + (int) this.getMesNum();
        result = 37 * result + (getDnicif() == null ? 0 : this.getDnicif().hashCode());
        return result;
    }

}
