package Modelo;
public class TieneTP implements Comparable<TieneTP> {
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
    @Override
    public int compareTo(TieneTP o) {
        int resultado = 0;
        if (this.getTipoDispositivo().getIdTipoDispositivo()< (o.getTipoDispositivo().getIdTipoDispositivo())) {
            resultado = -1;
        }
        if (this.getTipoDispositivo().getIdTipoDispositivo() > (o.getTipoDispositivo().getIdTipoDispositivo())) {
            resultado = 1;
        }
        return resultado;
    }
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
