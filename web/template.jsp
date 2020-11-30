<%-- 
    DOCUMENTO PARA COPIAR CONTENIDO GENÉRICO EN TODOS LOS JSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Título TAB</title>
        
        
        <!--CSS-->  
        <link rel="stylesheet" href="css/styles.css">
        <!--<link rel="stylesheet" href="css/css"> <!--es la referencia de mas abajo (fonts.googleapis)-->
        <!--<link rel="stylesheet" href="css/font-awesome.min.css"> --> <!--es la referencia de mas abajo (cdnjs.cloudflare)  


        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"><!--es el styles.css  -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--Javascript-->
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
        
        
        
        
        <script src="js/jquery-3.5.1.js" type="text/javascript"></script>
        <link href="css/secciones.css" rel="stylesheet" type="text/css"/>
        <script src="js/seccionesUsuarios.js" type="text/javascript"></script>
        
        
    </head>
    
    <body class="w3-light-grey">
        
        
        
        
        <script>
            
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

            // Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
            
            
             
             
             
            
            
        </script>
        
        
        
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
            <span class="w3-bar-item w3-right">LogoEmpresa</span>
        </div>
        
        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src="resources/avatar3.png" class="w3-circle w3-margin-right" style="width:46px">
                </div>
                <div class="w3-col s8 w3-bar">
                    <span>Bienvenido, <strong>NombrePersonaEmpresa</strong></span><br> <!-- CAMBIAR POR NOMBRE DE PERSONA DE LA EMPRESA -->
                    <!-- ICONOS DEBAJO DE PERFIL DE USUARIO -->
                        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i></a>
                        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cogs"></i></a>
                    
                </div>
            </div>

            <hr>
            <!-- TÍTULO DE MENÚ LATERAL 
                <div class="w3-container">
                    <h5>Dashboard</h5>
                </div>
            -->
            
            <div class="w3-bar-block">
                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>&nbsp; Cerrar Menu</a>
                <a href="manejoUsuarios.jsp" class="w3-bar-item w3-button w3-padding w3-blue-grey"><i class="fa fa-users fa-fw"></i>&nbsp; Usuarios</a>
                <a href="manejoClientes.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-address-card fa-fw"></i>&nbsp; Clientes</a>
                <a href="manejoPaquetes.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-cubes fa-fw"></i>&nbsp; Paquetes</a>
                <a href="manejoSuscripciones.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-suitcase fa-fw"></i>&nbsp; Suscripciones</a>
                <a href="manejoDispositivos.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-video-camera fa-fw"></i>&nbsp; Dispositivos</a>
                <a href="exportarPlanillas.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Exportar planillas</a>
                <a href="envioNotificacionesApp.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-bell fa-fw"></i>&nbsp; Enviar notificaciones</a>
                <a href="asignarCuentasSecundarias.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-user-plus fa-fw"></i>&nbsp; Asignar cuentas secundarias</a>
                <a href="reporteGraficas.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-line-chart fa-fw"></i>&nbsp; Tablero de gráficas</a>
                <hr>
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a><br><br>
            </div>

        </nav>
        
        
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        
        
        
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-users"></i> Título de la página </b></h5>
            </header>


            












        </div>
        
        
        
        
        
        
        
    </body>
    
</html>
