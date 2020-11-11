package Modelo;
public abstract class Cliente extends Persona {
/*Estado*/
protected int nroCliente;
protected String email;
protected TipoCliente tipoCliente;
/*Estado*/

/*Constructores*/
/*-Clase Abstracta-*/
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
/*Getters y Setters*/

   
}
