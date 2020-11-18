<%-- 
    Document   : bajaUsuario
    Created on : 12/11/2020, 08:16:30 PM
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
        <title>Baja de Usuario</title>
        
        <link href="css/seccionesUsuarios.css" rel="stylesheet" type="text/css"/>
        <script src="js/seccionesUsuarios.js" type="text/javascript"></script>
        
    </head>
    <body>
        
        <div>
            <h1>Baja de Usuario</h1>
        </div>
        
        <div class="usuarios-page">
            <div class="form">
                <!--<form class="register-form">
                    <input type="text" placeholder="name"/>
                    <input type="password" placeholder="password"/>
                    <input type="text" placeholder="email address"/>
                    <button>create</button>
                    <p class="message">Already registered? <a href="#">Sign In</a></p>
                </form>-->
                <form name="formBajaUsuario" action="ManejoUsuariosServlet" method="post" onsubmit="return validarCamposBajaUsr(this)">
                    <input type="text" id="txtUsuarioBaja" name="usuarioBaja" placeholder="usuario" required="true"/>
                    <input type="hidden" name="parametroOculto" value="formBaja">
                    
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
                    
                    <input type="submit" class="submitBaja" value="borrar" >
                    
                    <%if (msg != null) {%>
                    <div>
                        <p class="message"><%=msg%></p>                        
                    </div>
                    <%}%>
                    
                    <!--<p class="message">Not registered? <a href="#">Create an account</a></p>-->
                </form>
            </div>
        </div>
        
        
        
    </body>
</html>
