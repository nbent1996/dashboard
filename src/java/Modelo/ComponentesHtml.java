package Modelo;


import java.util.ArrayList;



public class ComponentesHtml {
    
//    public static String lista(boolean multiple,String id,ArrayList opciones){
//        String lista = "<select " + (multiple?" multiple ":"") +  " id='" + id+ "'>";
//        int x=0;
//        for(Object obj:opciones){
//            lista+= "<option id='" + x + "'>" + obj + "</option>";
//            x++;
//        }
//        lista+="</select>";
//        return lista;
//    }
    
        public static String lista(boolean multiple,String id ,ArrayList opciones){
        String lista = "<select " + "onChange='seleccionado()'" + (multiple?" multiple ":"") +  " id='" + id+ "'>";
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
                lista+= "<option id='" + optionId + "' name= 'itemSeleccionado' >" + value + "</option>";
                primero = false;
            }else{
                lista+= "<option id='" + optionId + "'>" + value + "</option>";
            }
        }
        lista+="</select>";
        return lista;
    }
}
