package Modelo;
public class TipoDocumento {
/*Estado*/
private String codDocumento;
private String nombreDocumento;
/*Estado*/

/*Constructores*/
public TipoDocumento(String codDocumento, String nombreDocumento){
    this.codDocumento = codDocumento;
    this.nombreDocumento = nombreDocumento;
}
public TipoDocumento(String codDocumento){
    this.codDocumento = codDocumento;
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
    public String getCodDocumento() {
        return codDocumento;
    }

    public void setCodDocumento(String codDocumento) {
        this.codDocumento = codDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }
/*Getters y Setters*/


}
