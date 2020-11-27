package Modelo;
public class Secundario extends Cliente{
/*Estado*/
private Principal principalAsociado;
/*Estado*/

/*Constructores*/
    /*FULL SIN USUARIO SISTEMA*/
public Secundario(String nombreCompleto, Empresa empresaAsociada, Pais paisResidencia, int nroCliente, String email, Principal principalAsociado){
    this.usuarioSistema ="";
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.empresaAsociada = empresaAsociada;
    this.paisResidencia = paisResidencia;
    this.principalAsociado = principalAsociado;
}
    /*FULL*/
public Secundario(String usuarioSistema, String nombreCompleto, Empresa empresaAsociada, Pais paisResidencia, int nroCliente, String email, Principal principalAsociado){
    this.usuarioSistema = usuarioSistema;
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.empresaAsociada = empresaAsociada;
    this.paisResidencia = paisResidencia;
    this.principalAsociado = principalAsociado;
}
/*SIN EMPRESA, PAIS*/
public Secundario(String usuarioSistema, String nombreCompleto, int nroCliente,String email, Principal principalAsociado){
    this.usuarioSistema = usuarioSistema;
    this.nombreCompleto = nombreCompleto;
    this.nroCliente = nroCliente;
    this.email = email;
    this.principalAsociado = principalAsociado;
}
/*SOLO USUARIO SISTEMA*/
public Secundario(String usuarioSistema){
    this.usuarioSistema = usuarioSistema;
}
/*SOLO NRO CLIENTE*/
public Secundario(int nroCliente){
    this.usuarioSistema ="";
    this.nroCliente = nroCliente;
    
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
    public Principal getPrincipalAsociado() {
        return principalAsociado;
    }

    public void setPrincipalAsociado(Principal principalAsociado) {
        this.principalAsociado = principalAsociado;
    }
        public int getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(int nroCliente) {
        this.nroCliente = nroCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*Getters y Setters*/




}
