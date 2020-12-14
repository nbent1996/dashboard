$(document).ready(load);
var modal = $("#divMensajeEmergente");
//var enlaceModal = $(".cerrarMensajeEmergente")[0];
function load(){
    /*EVENTOS*/
    $("#selTipoCliente").on("change", changeTipoCliente);
    $("#chkVerPasswordAltaUsuario").click(mostrarOcultarPassword);
    /*EVENTOS*/
    modificarVisibilidad(new Array("#divPrincipal", "#divSecundario"), "ocultar");
    modificarVisibilidad(new Array("#divPrincipal"), "mostrar");
    var f = new Date();
    var fechaActual = f.getDate() + "-"+ f.getMonth()+ "-" +f.getFullYear();
    $("#spanFechaInicio").html(fechaActual);
    //enlaceModal.click(ocultarModal);
    $(window).click(windowClickEvent);
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
function mostrarOcultarPassword(){
    $('#txtbxPasswordUsuarioAlta').attr('type', $(this).is(':checked') ? 'text' : 'password');
    
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
function invocarModal(texto){
    $("#pMensaje").html("");
    $("#pMensaje").html(texto);
    modal.css("display", "block");
}
function ocultarModal(){
    modal.css("display", "none");
}
function windowClickEvent(){
    modal.css("display", "none");
}
/*Funciones de Validación*/
function validarAltaUsuario(form){
    var resultado="";  
    //Largo caracteres
    if($("#txtbxUserUsuarioAlta").length>35){
        resultado+="El usuario no puede tener más de 35 caracteres.\n";
    }
    if($("#txtbxNombreCompletoUsuarioAlta").length>50){
        resultado+="El nombre completo no puede tener más de 50 caracteres.\n";
    }
    
    //Campos numericos
    
    if(resultado!=""){
        form.preventDefault();
        invocarModal(resultado);
        return false;
    }
    return true;
}
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
        resultado+="El email no puede tener más de 45 caracteres.\n";
    }
    if($("#txtbxTelefonoClienteAlta").length>50){
        resultado+="El teléfono no puede tener más de 50 caracteres.\n";
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
    if(resultado!==""){
        invocarModal(resultado);
        form.preventDefault();
        return false;
    }
    return true;
}
function validarAltaDispositivo(form){
    var resultado = "";
    
    //Largo caracteres
        if($("#txtbxNroSerieDispositivoAlta").length>20){
        resultado+="El número de serie no puede tener más de 20 caracteres";
        }
    //Campos numericos
    
    if(resultado!=""){
        form.preventDefault();
        invocarModal(resultado);
        return false;
    }
    return true;
}
function validarAltaSuscripcion(form){
    var resultado="";
    //Largo caracteres
    
    //Campos expresamente numericos
    
    if(resultado!=""){
        form.preventDefault();
        invocarModal(resultado);
        return false;
    }
    return true;
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