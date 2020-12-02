
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body>
            PROBANDO
        <form>
        
        </form>
        
=======
    <body class="fondoLogin" oncontextmenu='return false'>
            PRUEBA
            <div class="loginContainer">
                <figure>
                    <img class="logoLogin" src="resources/logoLogin.png"></img>
                </figure>
                <form id="idFormLogin" name="formLogin" action="LoginServlet" method="post" onsubmit="return login(this)">
                    <label for="txtbxUsuario">Usuario</label>
                    <input type="text" id="txtbxUsuario" name="txtbxUsuario">
                    <label for="txtbxPassword">Contraseña</label>
                    <input type="password" id="txtbxPassword" name="txtbxPassword">
                    
                </form>
            </div>
>>>>>>> 7809561610e9c0160c9956ec2b1c46aa77cf3b66
    </body>
</html>
