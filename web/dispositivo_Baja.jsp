<%-- 
    Document   : dispositivo_Baja
    Created on : 29/11/2020, 07:35:26 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja de Dispositivo</title>
        <!--CSS-->  
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/stylesCustom.css">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"> 
        <!--Javascript-->
        <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
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
                <a href="index.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>&nbsp; Inicio</a><br><br>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa-users fa-fw"></i>&nbsp; Usuarios</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="usuario_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Usuario</a>
                        <a href="usuario_Baja.jsp" class="w3-bar-item w3-button w3-mobile">Baja de Usuario</a>
                        <a href="usuario_Modificacion.jsp" class="w3-bar-item w3-button w3-mobile">Modificación de Usuario</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa-address-card fa-fw"></i>&nbsp; Clientes</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="cliente_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Cliente</a>
                        <a href="cliente_Baja.jsp" class="w3-bar-item w3-button w3-mobile">Baja de Cliente</a>
                        <a href="cliente_Modificacion.jsp" class="w3-bar-item w3-button w3-mobile">Modificación de Cliente</a>
                        <a href="cliente_cuentasSecundarias.jsp" class="w3-bar-item w3-button w3-mobile">Asignar cuentas secundarias</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa fa-cubes fa-fw"></i>&nbsp; Paquetes</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="paquete_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Paquete</a>
                        <a href="paquete_Baja.jsp" class="w3-bar-item w3-button w3-mobile">Baja de Paquete</a>
                        <a href="paquete_Modificacion.jsp" class="w3-bar-item w3-button w3-mobile">Modificación de Paquete</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa fa-suitcase fa-fw"></i>&nbsp; Suscripciones</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="suscripcion_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Suscripci&oacute;n</a>
                        <a href="suscripcion_Baja.jsp" class="w3-bar-item w3-button w3-mobile">Baja de Suscripci&oacute;n</a>
                        <a href="suscripcion_Modificacion.jsp" class="w3-bar-item w3-button w3-mobile">Modificación de Suscripci&oacute;n</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa-video-camera fa-fw"></i>&nbsp; Dispositivos</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="dispositivo_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Dispositivo</a>
                        <a href="dispositivo_Baja.jsp" class="w3-bar-item w3-button w3-mobile">Baja de Dispositivo</a>
                        <a href="dispositivo_Modificacion.jsp" class="w3-bar-item w3-button w3-mobile">Modificación de Dispositivo</a>
                    </div>
                </div>
                <a href="exportarPlanillas.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Exportar planillas</a>
                <a href="envioNotificacionesApp.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-bell fa-fw"></i>&nbsp; Enviar notificaciones</a>
                <a href="reporteGraficas.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-line-chart fa-fw"></i>&nbsp; Tablero de gráficas</a>
                <hr>
            </div>

        </nav>
        
        
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        
        
        
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-users"></i> Baja de Dispositivos </b></h5>
            </header>


            <div class="ABMpage">

                <div class="form">

                    
                    <form name="formBajaDispositivo" action="ManejoDispositivosServlet" method="post" onsubmit="return validarCamposBajaDisp(this)">
                        
                        <input type="text" id="txtNroSerieBaja" name="nroSerieBaja" placeholder="nro serie" required="true"/>

                        <input type="submit" class="submitBaja" value="confirmar">
                        
                        
                        
                        <input type="hidden" name="accion" value="formBajaDispositivo">
                        
                    </form>


                </div>

            </div>

        </div>
        
        
        
        <script>
        
            
            
        </script>
        
        
        
        
    </body>
</html>