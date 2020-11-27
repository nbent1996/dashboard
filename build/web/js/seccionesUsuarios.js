//
//$('.message a').click(function(){
//   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
//});


function seleccionado(){
    
    $(document).ready(function () {
        $("#lstPaises").change(function () {
            var x = $("#lstPaises").length;            
//            for (var i = 0; i < x; i++) {
//                $("#lstPaises")[i].removeProp("name");
//            }
            $("#lstPaises option:selected").attr("name", "itemSeleccionado"); //modifica el name de cada option, pero es necesario limpiar los demás
            //alert($('#lstPaises option:selected').html());
        });
    });
    
    
}






function validarCamposAltaUsr(form){
    //var usuario = form.usuario;
//    var nombreCompleto = form.nombreCompleto;
//    var nombreEmpresa = form.nombreEmpresa;
////    var nombrePais = form.nombrePais;
////    var tipoUsuario = form.tipoUsuario;
//    var pais = $("#lstPaises").val();
//    var tipo = $("#lstTipos").val();
//    
//    var comboPais = $("#lstPaises");
//    //var paisSeleccionado = comboPais.options[comboPais.selectedIndex].text;
//    
////    var comboTipo = form.document.getElementById("lstTipos");
////    var tipoSeleccionado = comboTipo.options[comboTipo.selectedIndex].text;
//    
//    alert(pais, comboPais, paisSeleccionado);
////    
//////    
////    if (usuario.value == ""){
////        alert("Debe escribir un nombre de usuario");
////        usuario.select();
////        usuario.focus();
////        return false;
////    }
////    
////    if (nombreCompleto.value == ""){
////        alert("Debe escribir un nombre completo");
////        nombreCompleto.select();
////        nombreCompleto.focus();
////        return false;
////    }
////
////    if (nombreEmpresa.value == ""){
////        alert("Debe escribir una empresa");
////        nombreEmpresa.select();
////        nombreEmpresa.focus();
////        return false;
////    }
////    
////    
////    
////    
////
//////    if (nombrePais.value == ""){
//////        alert("Debe escribir un pais");
//////        nombrePais.select();
//////        nombrePais.focus();
//////        return false;
//////    }
//////
//////    if (tipoUsuario.value == ""){
//////        alert("Debe escribir un tipo de usuario");
//////        tipoUsuario.select();
//////        tipoUsuario.focus();
//////        return false;
//////    }
////    
////    
//    return true;


}


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