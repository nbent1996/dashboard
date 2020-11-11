package Modelo;
public abstract class Persona {
/*Estado*/
protected String usuarioSistema;
protected String nombreCompleto;
protected Empresa empresaAsociada;
protected Pais paisResidencia;
/*Estado*/

/*Constructores*/
/*-Clase abstracta-*/
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
  public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Empresa getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(Empresa empresaAsociada) {
        this.empresaAsociada = empresaAsociada;
    }

    public Pais getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(Pais paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
/*Getters y Setters*/

  
}
