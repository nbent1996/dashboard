package Modelo;
public class Dispositivo {
/*Estado*/
private String nroSerie;
private String estado;
private TipoDispositivo tipoDispositivo;
private Empresa empresaAsociada;
private Cliente clienteAsociado;
/*Estado*/

/*Constructores*/
    /*SIN CLIENTE NI EMPRESA*/
public Dispositivo(String nroSerie, String estado, TipoDispositivo tipoDispositivo) {
        this.nroSerie = nroSerie;
        this.estado = estado;
        this.tipoDispositivo = tipoDispositivo;
    }

    /*FULL*/
    public Dispositivo(String nroSerie, String estado, TipoDispositivo tipoDispositivo, Empresa empresaAsociada, Cliente clienteAsociado) {
        this.nroSerie = nroSerie;
        this.estado = estado;
        this.tipoDispositivo = tipoDispositivo;
        this.empresaAsociada = empresaAsociada;
        this.clienteAsociado = clienteAsociado;
    }

    /*SIN cliente*/
    public Dispositivo(String nroSerie, String estado, TipoDispositivo tipoDispositivo, Empresa empresaAsociada) {
        this.nroSerie = nroSerie;
        this.estado = estado;
        this.tipoDispositivo = tipoDispositivo;
        this.empresaAsociada = empresaAsociada;
    }

/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/
    
/*Getters y Setters*/
    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public Empresa getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(Empresa empresaAsociada) {
        this.empresaAsociada = empresaAsociada;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }
/*Getters y Setters*/

    
}
