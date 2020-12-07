package Modelo;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import javax.imageio.ImageIO;



public class Funciones {
    
    /*HTML*/
        public static String lista(boolean multiple,String id ,ArrayList opciones){
        String lista = "<select " + " class='comboBox nb-input' onchange='changeItemSelected()' " + (multiple?" multiple ":"") +  " id='" + id+ "'>";
        String optionId = "";
        String value ="";
        boolean primero = true;
        
        for(Object obj:opciones){
            
            if(obj instanceof Pais){
                Pais p = (Pais) obj;
                optionId = p.getCodigo();
                value = p.getNombre();
            }
            if(obj instanceof TipoUsuario){
                TipoUsuario t = (TipoUsuario) obj;
                optionId = value = t.getNombre();
            }
            
            if(primero){
                lista+= "<option value='" + optionId + "' name= 'itemSeleccionado' >" + value + "</option>";
                primero = false;
            }else{
                lista+= "<option value='" + optionId + "'>" + value + "</option>";
            }
        }
        lista+="</select>";
        return lista;
    
    }
    /*HTML*/   
        
    public static String sanitizarCampo(String campo){
        if(campo == null || campo.equals("")){
            return campo;
        }
        campo = campo.replace(";", "");
        campo = campo.replace(":", "");
        campo = campo.replace("'", "");
        campo = campo.replace("\"", "");
        campo = campo.replace("INSERT", "");
        campo = campo.replace("insert", "");
        campo = campo.replace("SELECT", "");
        campo = campo.replace("select", "");
        campo = campo.replace("UPDATE", "");
        campo = campo.replace("update", "");
        campo = campo.replace("DELETE", "");
        campo = campo.replace("delete", "");
        campo = campo.replace("DROP", "");
        campo = campo.replace("drop", "");
        campo = campo.replace("CREATE", "");
        campo = campo.replace("create", "");
        return campo;
    }      
    public static boolean isNumeric(String cadena) {

        boolean resultado = false;
        if(cadena.equals("")){
           return true;
        }
        
        try {
            for(char c: cadena.toCharArray()){
                Integer.parseInt(c+"");
            }
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
            
        }

        return resultado;
    }
    public static String generarCadenaAleatoria(int longitud) {
        //Banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, banco.length()); //ThreadLocalRandom.current().nextInt() nos dá un número aleatorio en el rango puesto, el limite superior es exclusivo asi que se suma 1
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
    public static String FirstLetterUpperCase(String campo){
        if(campo == null || campo.equals("")){
            return campo;
        }
        return campo.substring(0, 1).toUpperCase() + campo.substring(1).toLowerCase();
    }
    public static byte[] getArrayBytes(String ruta) throws FileNotFoundException, IOException{
        BufferedImage img = ImageIO.read(new File(ruta));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = ruta.split("\\.").length;
        String ext = ruta.split("\\.")[len - 1];
        ImageIO.write(img, ext, baos);
        return baos.toByteArray();
    }
    public static String formatearTelefono(String campo, String prefijo){
        if(campo==null || campo.equals(""))
                return campo;
        if(campo.substring(0, 1).equals("0")){
            campo = campo.substring(1);
        }
        return prefijo+campo;
    }
}
