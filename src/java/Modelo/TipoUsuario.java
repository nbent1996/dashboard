package Modelo;

import java.util.ArrayList;

public class TipoUsuario{
/*Estado*/
private String nombre;
private ArrayList<Privilegio> listaPrivilegios;
/*Estado*/

/*Constructores*/
public TipoUsuario(String nombre, ArrayList<Privilegio> listaPrivilegios){
    this.nombre = nombre;
    this.listaPrivilegios = listaPrivilegios;
}
public TipoUsuario(String nombre){
    this.nombre = nombre;
    this.listaPrivilegios = new ArrayList<>();
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Privilegio> getListaPrivilegios() {
        return listaPrivilegios;
    }

    public void setListaPrivilegios(ArrayList<Privilegio> listaPrivilegios) {
        this.listaPrivilegios = listaPrivilegios;
    }
/*Getters y Setters*/


    
}
