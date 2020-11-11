package Modelo;
public class Privilegio {
/*Estado*/
private int idPrivilegio;
private String nombrePrivilegio;
/*Estado*/

/*Constructores*/
    /*FULL*/
public Privilegio(int idPrivilegio, String nombrePrivilegio){
    this.idPrivilegio = idPrivilegio;
    this.nombrePrivilegio = nombrePrivilegio;
}
/*ID -1*/
public Privilegio(String nombrePrivilegio){
    this.idPrivilegio = -1;
    this.nombrePrivilegio = nombrePrivilegio;
}
/*Constructores*/

/*Comportamiento*/

/*Comportamiento*/

/*Getters y Setters*/
    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public String getNombrePrivilegio() {
        return nombrePrivilegio;
    }

    public void setNombrePrivilegio(String nombrePrivilegio) {
        this.nombrePrivilegio = nombrePrivilegio;
    }
/*Getters y Setters*/


}
