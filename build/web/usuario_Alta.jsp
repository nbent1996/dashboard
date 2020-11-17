
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String msg = request.getParameter("msg");
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de Usuario</title>
        
        <link href="css/seccionesUsuarios.css" rel="stylesheet" type="text/css"/>
        <script src="js/seccionesUsuarios.js" type="text/javascript"></script>
        
        
    </head>
    <body>
        
        <div>
            <h1>Alta de Usuario</h1>
        </div>
        
        <div class="usuarios-page">
            <div class="form">
                
                <form name="formAltaUsuario" action="ManejoUsuariosServlet" method="post" onsubmit="return validarCamposAltaUsr(this)">
                    <input type="text" id="txtUsuarioAlta" name="usuario" placeholder="usuario" required="true"/>
                    <input type="text" id="txtNombreCompletoAlta" name="nombreCompleto" placeholder="nombre completo" required="true"/>
                    <input type="text" id="txtNombreEmpresaAlta" name="nombreEmpresa" placeholder="empresa" required="true"/>
                    <input type="text" id="txtNombrePaisAlta" name="nombrePais" placeholder="pais" required="true"/>
                    <input type="text" id="txtTipoUsuarioAlta" name="tipoUsuario" placeholder="tipo usuario" required="true"/>
                    
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
                    <input type="submit" class="submitAlta" value="crear" >
                    <!--<button>crear</button>-->
                    
                    
                    <%if (msg != null) {%>
                    <div>
                        <p class="message"><%=msg%></p>                        
                    </div>
                    <%}%>
                    
                    <p class="message">Not registered? <a href="#">Create an account</a></p>
                </form>
            </div>
        </div>
        
        
        
    </body>
</html>
