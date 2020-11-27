package Modelo;
public class Principal extends Cliente implements IObject<Principal>  {
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
    adaptarCampos();
}
/*FULL SIN USUARIOSISTEMA, QUE VA A SER AUTOGENERADO*/
public Principal(String nombreCompleto, Empresa empresaAsociada, Pais paisResidencia, int nroCliente, String email, String nroDocumento, boolean servicioActivo, TipoDocumento tipoDocumento){
    this.usuarioSistema = "";
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.empresaAsociada = empresaAsociada;
    this.paisResidencia = paisResidencia;
    this.nroDocumento = nroDocumento;
    this.servicioActivo = servicioActivo;
    this.tipoDocumento = tipoDocumento;
    adaptarCampos();
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
    adaptarCampos();
}
/*SOLO USUARIO SISTEMA*/
public Principal(String nroDocumento){
    this.usuarioSistema = "";
    this.nroDocumento = nroDocumento;
    adaptarCampos();
}
/*SOLO NROCLIENTE*/
public Principal(int nroCliente){
    this.usuarioSistema = "";
    this.nroCliente = nroCliente;
    adaptarCampos();
}
/*Constructores*/

/*Comportamiento*/
    @Override
    public void adaptarCampos() {
        /*Sanitizar campos*/
        Funciones.sanitizarCampo(this.usuarioSistema);
        Funciones.sanitizarCampo(this.nombreCompleto);
        Funciones.sanitizarCampo(this.email);
        Funciones.sanitizarCampo(this.nroDocumento);
        if(this.tipoDocumento!=null){
            Funciones.sanitizarCampo(this.tipoDocumento.getCodDocumento());
        }
        /*Sanitizar campos*/
        
    }

    @Override
    public String toString(int modo) throws ProgramException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void validar() throws ProgramException{
        
    }
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
