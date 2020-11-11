package Modelo;
public class Secundario extends Cliente{
/*Estado*/
private Principal principalAsociado;
/*Estado*/

/*Constructores*/
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
/*Getters y Setters*/


}
