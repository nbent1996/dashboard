<%-- 
    Document   : bajaUsuario
    Created on : 12/11/2020, 08:16:30 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <form class="login-form" action="">
                    <input type="text" id="txtUsuarioBaja" placeholder="usuario" required="true"/>
                    
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
                    
                    <button>borrar</button>
                    <!--<p class="message">Not registered? <a href="#">Create an account</a></p>-->
                </form>
            </div>
        </div>
        
        
        
    </body>
</html>
