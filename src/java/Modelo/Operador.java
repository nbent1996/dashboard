package Modelo;

public class Operador extends Persona {

    /*Estado*/
    
    private String clave;
    private TipoUsuario tipoUsuario;

    /*Estado*/

 /*Constructores*/
    
    public Operador(String clave, String usuarioSistema, String nombreCompleto, Empresa empresaAsociada, Pais paisResidencia, TipoUsuario tipoUsuario) {
        this.clave = clave;
        this.usuarioSistema = usuarioSistema;
        this.nombreCompleto = nombreCompleto;
        this.empresaAsociada = empresaAsociada;
        this.paisResidencia = paisResidencia;
        this.tipoUsuario = tipoUsuario;
    }

    /*Constructores*/

 /*Comportamiento*/
    
    
    
    @Override
    public void validar() throws ProgramException {
        super.validar();//valida los campos de Persona
        String retorno = "";

        if (tipoUsuario == null) {
            retorno += "El tipo de usuario es nulo.\n";
        }
        
        if (tipoUsuario == null) {
            retorno += "El tipo de usuario es nulo.\n";
        }
        
        

        if (!retorno.equals("")) {
            throw new ProgramException(retorno);
        }
    }

    /*Comportamiento*/

    
    
    
    
    
    
 /*Getters y Setters*/
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    /*Getters y Setters*/

}
