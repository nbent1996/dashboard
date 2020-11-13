package Modelo;
public class Principal extends Cliente {
/*Estado*/
private String nroDocumento;
private boolean servicioActivo;
private TipoDocumento tipoDocumento;
/*Estado*/

/*Constructores*/
    /*FULL*/
public Principal(String usuarioSistema, String nombreCompleto, Empresa empresaAsociada, Pais paisResidencia, int nroCliente, String email, String nroDocumento, boolean servicioActivo, TipoDocumento tipoDocumento){
    this.usuarioSistema = usuarioSistema;
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.empresaAsociada = empresaAsociada;
    this.paisResidencia = paisResidencia;
    this.nroDocumento = nroDocumento;
    this.servicioActivo = servicioActivo;
    this.tipoDocumento = tipoDocumento;
}
/*SIN EMPRESA, PAIS*/
public Principal(String usuarioSistema, String nombreCompleto, int nroCliente, String email, String nroDocumento, boolean servicioActivo, TipoDocumento tipoDocumento){
    this.usuarioSistema = usuarioSistema;
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.nroDocumento = nroDocumento;
    this.servicioActivo = servicioActivo;
    this.tipoDocumento = tipoDocumento;
}
/*SOLO USUARIO SISTEMA*/
public Principal(String nroDocumento){
    this.nroDocumento = nroDocumento;
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public boolean getServicioActivo() {
        return servicioActivo;
    }

    public void setServicioActivo(boolean servicioActivo) {
        this.servicioActivo = servicioActivo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
/*Getters y Setters*/

    
}
