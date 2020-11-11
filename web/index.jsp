
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alfacom Platform</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">


        <!--CSS-->  
        <link rel="stylesheet" href="css/styles.css">
        <!--<link rel="stylesheet" href="css/css"> <!--es la referencia de mas abajo (fonts.googleapis)-->
        <!--<link rel="stylesheet" href="css/font-awesome.min.css"> --> <!--es la referencia de mas abajo (cdnjs.cloudflare)  


        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"><!--es el styles.css  -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--Javascript-->
        <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>


        <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
        </style>


    </head>
    <body class="w3-light-grey">
        
        <script>
            
            <!--   funciones de llamadas a los servlets   -->
            
        </script>
        
        
        <!-- Top container -->
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
                <a href="altaUsuario.jsp" class="w3-bar-item w3-button w3-padding w3-pale-red"><i class="fa fa-users fa-fw"></i>&nbsp; Usuarios</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-address-card fa-fw"></i>&nbsp; Clientes</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-cubes fa-fw"></i>&nbsp; Paquetes</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-suitcase fa-fw"></i>&nbsp; Suscripciones</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-video-camera fa-fw"></i>&nbsp; Dispositivos</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-file-text-o fa-fw"></i>&nbsp; Exportar planillas</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-bell fa-fw"></i>&nbsp; Enviar notificaciones</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa fa-user-plus fa-fw"></i>&nbsp; Asignar cuentas secundarias</a>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-line-chart fa-fw"></i>&nbsp; Tablero de gráficas</a>
                <hr>
                <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a><br><br>
            </div>

        </nav>
        
        
        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <!-- Header -->
            <header class="w3-container" style="padding-top:22px">
                <h5><b><i class="fa fa-dashboard"></i> Dashboard NombreEmpresa</b></h5>
            </header>

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
                <div class="w3-row-padding" style="margin:0 -16px">

                    <!-- PANEL IZQUIERDO CON MAPA REGIÓN
                        <div class="w3-third">
                            <h5>Regions</h5>
                            <img src="resources/region.jpg" style="width:100%" alt="Google Regional Map">
                        </div>
                    -->

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

            <!-- SECCIÓN BARRAS DE ESTADÍSTICAS

            <div class="w3-container">
                <h5>General Stats</h5>
                <p>New Visitors</p>
                <div class="w3-grey">
                    <div class="w3-container w3-center w3-padding w3-green" style="width:25%">+25%</div>
                </div>

                <p>New Users</p>
                <div class="w3-grey">
                    <div class="w3-container w3-center w3-padding w3-orange" style="width:50%">50%</div>
                </div>

                <p>Bounce Rate</p>
                <div class="w3-grey">
                    <div class="w3-container w3-center w3-padding w3-red" style="width:75%">75%</div>
                </div>
            </div>
            <hr>

            -->



            <!-- SECCIÓN TABLA PAÍSES

            <div class="w3-container">
                <h5>Countries</h5>
                <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
                    <tbody><tr>
                            <td>United States</td>
                            <td>65%</td>
                        </tr>
                        <tr>
                            <td>UK</td>
                            <td>15.7%</td>
                        </tr>
                        <tr>
                            <td>Russia</td>
                            <td>5.6%</td>
                        </tr>
                        <tr>
                            <td>Spain</td>
                            <td>2.1%</td>
                        </tr>
                        <tr>
                            <td>India</td>
                            <td>1.9%</td>
                        </tr>
                        <tr>
                            <td>France</td>
                            <td>1.5%</td>
                        </tr>
                    </tbody></table><br>
                <button class="w3-button w3-dark-grey">More Countries &nbsp;<i class="fa fa-arrow-right"></i></button>
            </div>
            <hr>

            -->


            <div class="w3-container">
                <h5>Nuevos Clientes</h5>
                <ul class="w3-ul w3-card-4 w3-white">
                    <li class="w3-padding-16">
                        <img src="resources/avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                        <span class="w3-xlarge">Nombre último cliente creado</span><br>
                    </li>
                    <li class="w3-padding-16">
                        <img src="resources/avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                        <span class="w3-xlarge">Nombre penúltimo cliente creado</span><br>
                    </li>
                    <li class="w3-padding-16">
                        <img src="resources/avatar2.png" class="w3-left w3-circle w3-margin-right" style="width:35px">
                        <span class="w3-xlarge">Nombre antepenúltimo cliente creado</span><br>
                    </li>
                </ul>
            </div>
            <hr>

            <!-- SECCIÓN COMENTARIOS RECIENTES

            <div class="w3-container">
                <h5>Recent Comments</h5>
                <div class="w3-row">
                    <div class="w3-col m2 text-center">
                        <img class="w3-circle" src="resources/avatar3.png" style="width:96px;height:96px">
                    </div>
                    <div class="w3-col m10 w3-container">
                        <h4>John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12 PM</span></h4>
                        <p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
                    </div>
                </div>

                <div class="w3-row">
                    <div class="w3-col m2 text-center">
                        <img class="w3-circle" src="resources/avatar1.png" style="width:96px;height:96px">
                    </div>
                    <div class="w3-col m10 w3-container">
                        <h4>Bo <span class="w3-opacity w3-medium">Sep 28, 2014, 10:15 PM</span></h4>
                        <p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p><br>
                    </div>
                </div>
            </div>

            -->

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

            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <h4>FOOTER</h4>
                <p>Powered by <a href="fi.ort.edu.uy" target="_blank">ORT</a></p>
            </footer>

            <!-- End page content -->
        </div>
        
        
        <script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
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
        
 
    </body>
</html>
