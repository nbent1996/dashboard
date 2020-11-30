
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String msg = request.getParameter("msg");
   
%>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de Usuario</title>
        
        
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
            
            mostrarTipos();
            //mostrarPaises();
            //prueba();
            
            
            function mostrarTipos(){
                $.get("ManejoUsuariosServlet?accion=comboTipos", function(data){
                    document.getElementById("combo-tipoUsuarios").innerHTML=data;
                    //document.getElementById("combo-paises").innerHTML=data;
                });
            }
            
            function mostrarPaises(){
                $.get("ManejoUsuariosServlet?accion=comboPaises", function(data){
                    document.getElementById("combo-paises").innerHTML=data;
                });
            }
              

                 /******Cargar el selet con las familias*******/
          /*function prueba() {
             $.ajax({
                    type: "POST",
                   //data: JSON.stringify(dto),
                    url: "ManejoUsuariosServlet?accion=prueba",
                    dataType: "json",
                    contentType: "application/json; charset=utf-8",
                 success: function (respuesta) {
                   console.log(respuesta);
                      },
                      error: function () {
                          alert("Error de Ajax cuando viaja a buscar familias");
                      }
                  });
              }*/
            
            
             
            
            
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
                <h5><b><i class="fa fa-users"></i> Alta de Usuario</b></h5>
            </header>


            <div class="ABMpage">

                <div class="form">

                    <form name="formAltaUsuario" action="ManejoUsuariosServlet" method="post" onsubmit="return validarCamposAltaUsr(this)">
                        <input type="text" id="txtUsuarioAlta" name="usuario" placeholder="usuario" required="true"/>
                        <input type="text" id="txtNombreCompletoAlta" name="nombreCompleto" placeholder="nombre completo" required="true"/>
                        <input type="text" id="txtNombreEmpresaAlta" name="nombreEmpresa" placeholder="empresa" required="true"/>
                        <!-- <input type="text" id="txtNombrePaisAlta" name="nombrePais" placeholder="pais" required="true"/> -->
                        <!-- <input type="text" id="txtTipoUsuarioAlta" name="tipoUsuario" placeholder="tipo usuario" required="true"/> -->
                        <input type="hidden" name="accion" value="formAlta">

                        <span id="combo-paises"></span> <br><br>
                        <span id="combo-tipoUsuarios"></span> <br><br>


                        <input type="submit" class="submitAlta" value="confirmar">

                        <%if (msg != null) {%>
                        <div>
                            <p class="message"><%=msg%></p>                        
                        </div>
                        <%}%>


                    </form>
                </div>
            </div>












        </div>
        
        
        
        
        
        
        
    </body>
</html>
