package Modelo;
public class Empresa {
/*Estado*/
private String identificacionTributaria;
private String nombre;
private String razonSocial;
private float impuestos;
private Idioma idiomaAsociado;
private Pais paisAsociado;
/*Estado*/

/*Constructores*/
    public Empresa(String identificacionTributaria, String nombre, String razonSocial, float impuestos, Idioma idiomaAsociado, Pais paisAsociado) {
        this.identificacionTributaria = identificacionTributaria;
        this.razonSocial = razonSocial;
        this.impuestos = impuestos;
        this.idiomaAsociado = idiomaAsociado;
        this.paisAsociado = paisAsociado;
        this.nombre = nombre;
    }
    public Empresa(String identificacionTributaria){
        this.identificacionTributaria = identificacionTributaria;
    }
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
public String getIdentificacionTributaria() {
        return identificacionTributaria;
    }

    public void setIdentificacionTributaria(String identificacionTributaria) {
        this.identificacionTributaria = identificacionTributaria;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public float getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(float impuestos) {
        this.impuestos = impuestos;
    }

    public Idioma getIdiomaAsociado() {
        return idiomaAsociado;
    }

    public void setIdiomaAsociado(Idioma idiomaAsociado) {
        this.idiomaAsociado = idiomaAsociado;
    }

    public Pais getPaisAsociado() {
        return paisAsociado;
    }

    public void setPaisAsociado(Pais paisAsociado) {
        this.paisAsociado = paisAsociado;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*Getters y Setters*/



    

}
