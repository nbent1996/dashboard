<%-- 
    Document   : usuario_Modificacion
    Created on : 12/11/2020, 08:21:03 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String msg = request.getParameter("msg");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación de Usuario</title>
        
        <link href="css/seccionesUsuarios.css" rel="stylesheet" type="text/css"/>
        <script src="js/seccionesUsuarios.js" type="text/javascript"></script>
        
    </head>
    <body>
        
        
        <div>
            <h1 class="titulos">Modificación de Usuario</h1>
        </div>
        
        <div>
            <h2 class="subtitulos">Complete los campos que desea modificar</h2>
        </div>
        
        <div class="usuarios-page">
            <div class="form">
                
                <form name="formModificacionUsuario" action="ManejoUsuariosServlet" method="post" onsubmit="return validarCamposModificacionUsr(this)">
                    <input type="text" id="txtUsuarioMod" name="usuarioMod" placeholder="usuario"/>
                    <input type="text" id="txtNombreCompletoMod" name="nombreCompletoMod" placeholder="nombre completo"/>
                    <input type="text" id="txtNombreEmpresaMod" name="nombreEmpresaMod" placeholder="empresa"/>
                    <input type="text" id="txtNombrePaisMod" name="nombrePaisMod" placeholder="pais"/>
                    <input type="password" id="txtPasswordMod" name="passwordMod" placeholder="contraseña"/>
                    <input type="hidden" name="accion" value="formModificacion">
                    
                    <!--
                        <select name="pais" id="pais">
                            <option value="uru">Uruguay</option>
                            <option value="arg">Argentina</option>
                            <option value="bra">Brasil</option>
                        </select>
                        <select name="tipoUsuario" id="tipoUsuario">
                            <option value="operador">Operador</option>
                            <option value="administrador">Administrador</option>
                        </select>
                    -->
                    
                    <input type="submit" class="submitModificacion" value="modificar">
                    
                    <%if (msg != null) {%>
                    <div>
                        <p class="message"><%=msg%></p>                        
                    </div>
                    <%}%>
                    
                </form>
            </div>
        </div>
        
        
    </body>
</html>
