package Modelo;
public class Pais {
/*Estado*/
private String codigo;
private String nombre;
/*Estado*/

/*Constructores*/
public Pais(String codigo, String nombre){
    this.codigo = codigo;
    this.nombre = nombre;
}
public Pais(String codigo){
    this.codigo = codigo;
    this.nombre = "";
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/*Getters y Setters*/


}
