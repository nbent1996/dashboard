
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg = request.getParameter("msg");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alfacom Platform</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
            
        </script>
       <div class="w3-bar w3-top w3-black w3-large" id="divBarraSuperior">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> &nbsp;Menu</button>
            <span class="w3-bar-item w3-right">LogoEmpresa</span>
        </div>
        
        <!-- Sidebar/menu -->
         <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src="resources/avatar3.png" class="w3-circle w3-margin-right" id="imgPerfil">
                </div>
                <div class="w3-col s8 w3-bar">
                    <span>Bienvenido, <strong>NombrePersonaEmpresa</strong></span><br> <!-- CAMBIAR POR NOMBRE DE PERSONA DE LA EMPRESA -->
                    <!-- ICONOS DEBAJO DE PERFIL DE USUARIO -->
                        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-sign-out"></i></a>
                        <a href="#" class="w3-bar-item w3-button"><i class="fa fa-cogs"></i></a>
                    
                </div>
            </div>

            <hr>
          
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
        <!-- !PAGE CONTENT! -->
        <div class="ABMContainer">
            <!-- Header -->
            <header class="w3-container estilosHeader">
                <h5><b><i class="fa fa-dashboard"></i> Dashboard NombreEmpresa</b></h5>
            </header>
            <div class="form">
            <div class="w3-row-padding w3-margin-bottom">
                <div class="w3-quarter">
                    <div class="w3-container w3-light-blue w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-handshake-o w3-xxlarge"></i></div>
                        <div class="w3-right">
                            <h3>52</h3> <!-- Cantidad suscripciones -->
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Suscripciones</h4>
                    </div>
                </div>
                <div class="w3-quarter">
                    <div class="w3-container w3-light-blue w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-user-times w3-xxlarge"></i></div>
                        <div class="w3-right">
                            <h3>3</h3> <!-- Cantidad clientes morosos -->
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Clientes Morosos</h4>
                    </div>
                </div>
                <div class="w3-quarter">
                    <div class="w3-container w3-light-blue w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-users w3-xxlarge"></i></div>
                        <div class="w3-right">
                            <h3>420</h3> <!-- Cantidad clientes totales -->
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Clientes totales</h4>
                    </div>
                </div>
                <div class="w3-quarter">
                    <div class="w3-container w3-light-blue w3-text-white w3-padding-16">
                        <div class="w3-left"><i class="fa fa-user-plus w3-xxlarge"></i></div>
                        <div class="w3-right">
                            <h3>8</h3> <!-- Cantidad nuevos clientes -->
                        </div>
                        <div class="w3-clear"></div>
                        <h4>Nuevos clientes</h4>
                    </div>
                </div>
            </div>

            <div class="w3-panel">
                <div class="w3-row-padding">

                    <div class="w3-twothird">
                        <h5>Últimas interacciones</h5>
                        <table class="w3-table w3-striped w3-white">
                            <tbody><tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                                <tr>
                                    <td><i class="fa fa-user w3-text-blue w3-large"></i></td>
                                    <td>Nombre Cliente</td>
                                    <td><i>Tiempo última interacción</i></td>
                                </tr>
                            </tbody></table>
                    </div>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <h5>Nuevos Clientes</h5>
                <ul class="w3-ul w3-card-4 w3-white">
                    <li class="w3-padding-16">
                        <span class="w3-xlarge">Nombre último cliente creado</span><br>
                    </li>
                    <li class="w3-padding-16">
                        <span class="w3-xlarge">Nombre penúltimo cliente creado</span><br>
                    </li>
                    <li class="w3-padding-16">
                        <span class="w3-xlarge">Nombre antepenúltimo cliente creado</span><br>
                    </li>
                </ul>
            </div>
            <hr>
            <br>
            <div class="w3-container w3-dark-grey w3-padding-32">
                <div class="w3-row">
                    <div class="w3-container w3-third">
                        <h5 class="w3-bottombar w3-border-green">Demographic</h5>
                        <p>Language</p>
                        <p>Country</p>
                        <p>City</p>
                    </div>
                    <div class="w3-container w3-third">
                        <h5 class="w3-bottombar w3-border-red">System</h5>
                        <p>Browser</p>
                        <p>OS</p>
                        <p>More</p>
                    </div>
                    <div class="w3-container w3-third">
                        <h5 class="w3-bottombar w3-border-orange">Target</h5>
                        <p>Users</p>
                        <p>Active</p>
                        <p>Geo</p>
                        <p>Interests</p>
                    </div>
                </div>
            </div>
            <!-- End page content -->
        </div>
            </div>
    </body>
</html>
