package Modelo;


import java.util.ArrayList;



public class ComponentesHtml {
    
    public static String lista(boolean multiple,String id,ArrayList opciones){
        String lista = "<select " + (multiple?" multiple ":"") +  " id='" + id+ "'>";
        int x=0;
        for(Object obj:opciones){
            lista+= "<option id='" + x + "'>" + obj + "</option>";
            x++;
        }
        lista+="</select>";
        return lista;
    }
}
