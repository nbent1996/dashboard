$(document).ready(load);
function load(){
    /*EVENTOS*/
    /*GENERALES*/
    $("#spanBtnCerrar").click(eventoCerrarModal);
    /*GENERALES*/
    
    /*ALTAS*/
    
    /*usuario_Alta.jsp*/   
    $("#btnAltaUsuario").click(eventoAltaUsuario);
    $("#chkVerPasswordAltaUsuario").click(mostrarOcultarPassword);
    /*usuario_Alta.jsp*/
    
    /*cliente_Alta.jsp*/
    $("#btnConfirmarAltaCliente").click(eventoAltaCliente);
    $("#selTipoCliente").on("change", changeTipoCliente);
    modificarVisibilidad(new Array("#divPrincipal", "#divSecundario"), "ocultar");
    modificarVisibilidad(new Array("#divPrincipal"), "mostrar");
    
    /*cliente_Alta.jsp*/
    
    /*paquete_Alta.jsp*/
    
    /*paquete_Alta.jsp*/
    
    
    /*suscripcion_Alta.jsp*/
    var f = new Date();
    var fechaActual = f.getDate() + "-"+ f.getMonth()+ "-" +f.getFullYear();
    $("#spanFechaInicio").html(fechaActual);
    /*suscripcion_Alta.jsp*/
    
    /*dispositivo_Alta.jsp*/
    
    /*dispositivo_Alta.jsp*/
    /*ALTAS*/
    
    /*BAJAS*/
    /*usuario_Baja.jsp*/
    $("#btnBorrarUsuariosSeleccionados").click(eventoBorrarUsuarioBaja);
    /*usuario_Baja.jsp*/
    /*cliente_Baja.jsp*/
    $("#btnBorrarClientesSeleccionados").click(eventoBorrarClienteBaja);
    /*cliente_Baja.jsp*/
    
    /*paquete_Baja.jsp*/
    $("#btnBuscarPaquetesBaja").click(eventoBuscarPaquetesBaja);
    $("#btnBorrarPaquetesSeleccionados").click(eventoBorrarPaqueteBaja);
    
    /*paquete_Baja.jsp*/
    /*suscripcion_Baja.jsp*/
    
    /*suscripcion_Baja.jsp*/
    /*dispositivo_Baja.jsp*/
    $("#btnBorrarDispositivosSeleccionados").click(eventoBorrarDispositivoBaja);
    /*dispositivo_Baja.jsp*/
    /*BAJAS*/
    /*MODIFICACIONES*/
    
    /*usuario_Modificacion.jsp*/
    
    /*usuario_Modificacion.jsp*/
    /*cliente_Modificacion.jsp*/
    
    /*cliente_Modificacion.jsp*/
    
    /*paquete_Modificacion.jsp*/
    
    /*paquete_Modificacion.jsp*/
    /*suscripcion_Modificacion.jsp*/
    
    /*suscripcion_Modificacion.jsp*/
    /*dispositivo_Modificacion.jsp*/
    
    /*dispositivo_Modificacion.jsp*/
    /*MODIFICACIONES*/
    
    /*index.jsp*/
  
    /*index.jsp*/
    
    /*login.jsp*/
   
    /*login.jsp*/
    
    /*reporteGrafica.jsp*/
    
    /*reporteGrafica.jsp*/
    
    /*envioNotificacionesApp.js*/
    
    /*envioNotificacionesApp.js*/
    
    /*EVENTOS*/


}

function abrirModal(){
    $("#divModal").css("display","block");
    $("#mySidebar").css("z-index", "0");
}
function eventoCerrarModal(){
    $("#mySidebar").css("z-index", "4");
    $("#divModal").css("display","none");
    
}
function eventoBuscarPaquetesBaja(){
    buscarPaquetesBaja();
}
function eventoBorrarUsuarioBaja(){
    borrarUsuariosSeleccionados();   
    abrirModal();
}

function eventoAltaCliente(){
    altaCliente();
    abrirModal();
}

function eventoAltaUsuario(){
    altaUsuario();
    abrirModal();
}

function eventoBorrarClienteBaja(){
    borrarClientesSeleccionados();
    abrirModal();
}
function eventoBorrarPaqueteBaja(){
    borrarPaquetesSeleccionados();
    abrirModal();
}

function eventoBorrarDispositivoBaja(){
    borrarDispositivosSeleccionados();
    abrirModal();
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











