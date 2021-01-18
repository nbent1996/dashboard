<%@page contentType="application/vnd.ms-excel" pageEncoding="UTF-8"%>
<%@page import="Modelo.Funciones, Datos.OpPersona"%>
<%
    OpPersona op = new OpPersona("loginUser");
    String nombreArchivo = "listaClientesTitulares.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Clientes titulares</title>
    </head>
    
    <body class="w3-light-grey">  
        <div class="form">
            <div class="margin-top20">
                <div>
                    <h1 class="nb-title-center">Lista de Dispositivos</h1>
                </div>
                <span id="spanDispositivosPlanilla"><%= Funciones.tablaClientes(op.buscar(null, "Modelo.Principal"), true)%></span>
            </div>  
        </div>
    </body>
</html>
