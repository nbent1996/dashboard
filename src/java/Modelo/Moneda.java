package Modelo;
public class Moneda {
/*Estado*/
private String codigo;
private String nombreMoneda;
private String simbolo;
/*Estado*/

/*Constructores*/
    public Moneda(String codigo, String nombreMoneda, String simbolo) {
        this.codigo = codigo;
        this.nombreMoneda = nombreMoneda;
        this.simbolo = simbolo;
    }
        public Moneda(String codigo) {
        this.codigo = codigo;
        this.nombreMoneda = "";
        this.simbolo = "";
    }
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
 public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
/*Getters y Setters*/

   


}
