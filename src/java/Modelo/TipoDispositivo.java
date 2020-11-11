package Modelo;
public class TipoDispositivo {
/*Estado*/
private int idTipoDispositivo;
private String modelo;
private String nombre;
private String tipoComunicacion;
private Categoria categoria;
/*Estado*/

/*Constructores*/
/*FULL*/
public TipoDispositivo(int idTipoDispositivo, String modelo, String nombre, String tipoComunicacion, Categoria categoria){
    this.idTipoDispositivo = idTipoDispositivo;
    this.modelo = modelo;
    this.nombre = nombre;
    this.tipoComunicacion = tipoComunicacion;
    this.categoria = categoria;
}
/*ID-1 FULL*/
public TipoDispositivo(String modelo, String nombre, String tipoComunicacion, Categoria categoria){
    this.idTipoDispositivo = -1;
    this.modelo = modelo;
    this.nombre = nombre;
    this.tipoComunicacion = tipoComunicacion;
    this.categoria = categoria;
}
/*FULL SIN CATEGORIA*/
public TipoDispositivo(int idTipoDispositivo, String modelo, String nombre, String tipoComunicacion){
    this.idTipoDispositivo = idTipoDispositivo;
    this.modelo = modelo;
    this.nombre = nombre;
    this.tipoComunicacion = tipoComunicacion;
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
public int getIdTipoDispositivo() {
        return idTipoDispositivo;
    }

    public void setIdTipoDispositivo(int idTipoDispositivo) {
        this.idTipoDispositivo = idTipoDispositivo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoComunicacion() {
        return tipoComunicacion;
    }

    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
/*Getters y Setters*/

    
}
