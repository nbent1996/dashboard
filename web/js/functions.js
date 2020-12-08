$(document).ready(load);
function load(){
    /*EVENTOS*/
    $("#selTipoCliente").on("change", changeTipoCliente);
    
    /*EVENTOS*/
    modificarVisibilidad(new Array("#divPrincipal", "#divSecundario"), "ocultar");
    modificarVisibilidad(new Array("#divPrincipal"), "mostrar");


}
function modificarVisibilidad(listaElementos, accion){
    switch(accion){
        case "mostrar":
            for(var contador=0; contador<=listaElementos.length-1;contador++){
                $(listaElementos[contador]).show();
            }
        break;
        
        case "ocultar":
            for(var contador=0; contador<=listaElementos.length-1;contador++){
                $(listaElementos[contador]).hide();
            }
        break;
    }

}
function changeItemSelected(){
    $(".comboBox option").attr("name", "");
    $(".comboBox option:selected").attr("name", "itemSeleccionado");
}
function changeTipoCliente(){
    modificarVisibilidad(new Array("#divPrincipal", "#divSecundario"), "ocultar");
    var itemSeleccionado = $("#selTipoCliente").val();
    switch(itemSeleccionado){
        case "Principal":
            modificarVisibilidad(new Array("#divPrincipal"), "mostrar");
        break;
        case "Secundario":
            modificarVisibilidad(new Array("#divSecundario"), "mostrar");
        break;
    }
}

/*Funciones de Validación*/
function validarAltaCliente(form){
    var resultado="";
    //No nulo
    if($("#selTipoCliente").val()=="Secundario" && $("#txtbxNroDocPrincipalClienteAlta").val()==""){
        resultado+="El número de documento de la cuenta principal es un campo obligatorio.\n";
    }
    //Largo Caracteres
    if($("#txtbxNombreCompletoClienteAlta").length>50){
        resultado+="El nombre completo no puede tener más de 50 caracteres.\n";
    }
    if($("#txtbxEmailClienteAlta").length>45){
        resultado+="El email no puede tener más de 45 caracteres.";
    }
    if($("#txtbxTelefonoClienteAlta").length>50){
        resultado+="El teléfono no puede tener más de 50 caracteres";
    }
    //Campos numéricos
    if(isNaN($("#txtbxNroDocumentoClienteAlta").val())){
        resultado+="El número de documento debe ser un campo numérico.\n";
    }
    if(isNaN($("#txtbxTelefonoClienteAlta").val())){
        resultado+="El teléfono debe ser un campo numérico.\n";
    }
    if($("#selTipoCliente").val()=="Secundario" && isNaN($("#txtbxNroDocPrincipalClienteAlta").val())){
        resultado+="El número de documento de la cuenta principal debe ser numérico.\n";
    }
    if(resultado!=""){
        form.preventDefault();
        alert(resultado);
    }
    return resultado;
}
/*Funciones de Validación*/











/*ANDRES*/
function validarCamposBajaUsr(form){
    var usuario = form.usuario;
    
    if(usuario.value == ""){
        alert("Debe escribir un nombre de usuario");
        usuario.select();
        usuario.focus();
        return false;
    }
    return true;
}


function validarCamposModificacionUsr(form){
    //VER SI SE TIENE QUE VALIDAR ALGUN CAMPO, YA QUE NINGUNO DE ELLOS ES REQUERIDO EN EL FORMULARIO
}