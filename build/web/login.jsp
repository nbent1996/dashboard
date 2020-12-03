
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String msg = request.getParameter("msg");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Alfacom Platform</title>
        <!--CSS<>-->  
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/stylesCustom.css">
        <link rel="stylesheet" href="css/font-awesome.min.css"> 

        <!--Javascript-->
        <script src="js/jquery-3.5.1.js" type="text/javascript"></script>
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
    </head>
<<<<<<< HEAD



=======
>>>>>>> e08c26aa95f7516e3d9bc38101ddc7ae22e8f22b
    <body class="fondoLogin" oncontextmenu='return false'>
        <div class="espaciador">
            <div class="loginContainer">
                <div class="logoLoginContainer">
                    <img class="logoLogin" src="resources/logoLogin.png"></img>
                </div>
                <form id="idFormLogin" name="formLogin" action="LoginServlet" method="post" onsubmit="return login(this)"> 
                    <div><label for="txtbxUsuario">Usuario</label></div>
                    <div ><input type="text" id="txtbxUsuario" name="txtbxUsuario" class="nb-input" required="true"></div>
                    <div class="margin-top20"><label for="txtbxPassword">Contraseña</label></div>
                    <div><input type="password" id="txtbxPassword" name="txtbxPassword" class="nb-input" required="true"></div>
                    <div class="margin-top20"><input type="submit" value="Ingresar" class="w3-button w3-light-blue"/></div>
                        <%if (msg != null) {%>
                            <div>
                                Error: <%=msg%>
                            </div>
                        <%}%>                    
                    <div class="margin-top20"><a href="#"> Olvide mi contraseña</a></div>
                </form>
            </div>
<<<<<<< HEAD

        </div>

=======
            </div>
>>>>>>> e08c26aa95f7516e3d9bc38101ddc7ae22e8f22b
    </body>
</html>
