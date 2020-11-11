package Modelo;
public class TieneTP {
/*Estado*/
private int cantidadDispositivos;
private TipoDispositivo tipoDispositivo;
/*Estado*/

/*Constructores*/
 public TieneTP(int cantidadDispositivos, TipoDispositivo tipoDispositivo) {
        this.cantidadDispositivos = cantidadDispositivos;
        this.tipoDispositivo = tipoDispositivo;
    }

    public TieneTP(int cantidadDispositivos) {
        this.cantidadDispositivos = cantidadDispositivos;
    }
/*Constructores*/
/*Comportamiento*/
/*Comportamiento*/
/*Getters y Setters*/
    public int getCantidadDispositivos() {
        return cantidadDispositivos;
    }

    public void setCantidadDispositivos(int cantidadDispositivos) {
        this.cantidadDispositivos = cantidadDispositivos;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }
/*Getters y Setters*/

   
}
