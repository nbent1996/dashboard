package Modelo;
public class Privilegio implements Comparable<Privilegio> {
/*Estado*/
private String nombrePrivilegio;
/*Estado*/

/*Constructores*/
    /*FULL*/
public Privilegio(String nombrePrivilegio){
    this.nombrePrivilegio = nombrePrivilegio;
}
/*Constructores*/

/*Comportamiento*/
    @Override
    public int compareTo(Privilegio o) {
        int resultado = 0;
        if(this.getNombrePrivilegio().compareTo(o.getNombrePrivilegio())==-1){
            resultado = -1;
        }
        if(this.getNombrePrivilegio().compareTo(o.getNombrePrivilegio())==1){
            resultado = 1;
        }
        return resultado;
    }
/*Comportamiento*/

/*Getters y Setters*/

    public String getNombrePrivilegio() {
        return nombrePrivilegio;
    }

    public void setNombrePrivilegio(String nombrePrivilegio) {
        this.nombrePrivilegio = nombrePrivilegio;
    }
/*Getters y Setters*/




}
