
$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});


function validarCamposAltaUsr(form){
    var usuario = form.usuario;
    var nombreCompleto = form.nombreCompleto;
    var nombreEmpresa = form.nombreEmpresa;
    var nombrePais = form.nombrePais;
    var tipoUsuario = form.tipoUsuario;
    
    
    if (usuario.value == ""){
        alert("Debe escribir un nombre de usuario");
        usuario.select();
        usuario.focus();
        return false;
    }
    
    if (nombreCompleto.value == ""){
        alert("Debe escribir un nombre completo");
        nombreCompleto.select();
        nombreCompleto.focus();
        return false;
    }

    if (nombreEmpresa.value == ""){
        alert("Debe escribir una empresa");
        nombreEmpresa.select();
        nombreEmpresa.focus();
        return false;
    }

    if (nombrePais.value == ""){
        alert("Debe escribir un pais");
        nombrePais.select();
        nombrePais.focus();
        return false;
    }

    if (tipoUsuario.value == ""){
        alert("Debe escribir un tipo de usuario");
        tipoUsuario.select();
        tipoUsuario.focus();
        return false;
    }
    
    
    return true;
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