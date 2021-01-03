<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = request.getParameter("msg");
    String tipoJSP = request.getParameter("tipo");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%if (tipoJSP.equals("baja")) {%>
        <title>Baja de Suscripci&oacute;n</title>
        <%} else if (tipoJSP.equals("modificacion")) {%>
        <title>Modificaci&oacute;n de Suscripci&oacute;n</title>
        <%}%> 
        <!--CSS-->  
        <link rel="stylesheet" href="css/styles.css">
        <link rel="stylesheet" href="css/stylesCustom.css">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"> 
        <!--Javascript-->
        <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/functions.js"></script>
        <script type="text/javascript" src="js/events.js"></script>
    </head>
    
    <body class="w3-light-grey">
        <script>
            
           mostrarTablaSuscripcionesSuscripcionBaja();
           
           function mostrarTablaSuscripcionesSuscripcionBaja(){
               $.get("ManejoSuscripcionesServlet?accion=generarTablaSuscripcionesBaja", function(data){
                  document.getElementById("spanSuscripcionesSuscripcionBaja").innerHTML=data; 
               });
               
            }
               
           function buscarSuscripcion(){
               
               var idSuscripcion = $("#txtbxIdSuscripcionBaja").val();
               var fechaInicioA = $("#calFechaInicioA").val();
               var fechaInicioB = $("#calFechaInicioB").val();
               var tiempoContrato = $("#selTiempoContratoSuscripcionBaja").val();
               var fechaFinA = $("#calFechaFinA").val();   
               var fechaFinB = $("#calFechaFinB").val(); 
               var activa = $("#selActivaSuscripcionBaja").val();

               $.get("ManejoSuscripcionesServlet?accion=generarTablaSuscripcionesBaja&idSuscripcion=" + idSuscripcion + "&fechaInicioA=" + fechaInicioA + 
                    "&fechaInicioB=" + fechaInicioB + "&tiempoContrato=" + tiempoContrato + "&fechaFinA=" + fechaFinA + "&fechaFinB=" + fechaFinB + "&activa=" + activa , function(data){
                            document.getElementById("spanSuscripcionesSuscripcionBaja").innerHTML = data;
                            document.getElementById("spanMensaje").innerHTML = ""; //MÉTODO PARA LIMPIAR CAMPO
               });
           }
               
               
           function borrarSuscripcionesSeleccionadas(){ //falta toda esta funcionalidad
               var listaSuscripcionesSeleccionadas = new Array();
                    $("input:checkbox:checked").each(   
                        function() {
                            listaSuscripcionesSeleccionadas.push($(this).val());
                            //alert("El checkbox con valor " + $(this).val() + " está seleccionado");
                        }
                    );
                        $.get("ManejoSuscripcionesServlet?accion=borrarSuscripciones&listaSuscripciones=" + listaSuscripcionesSeleccionadas, function (data) {

                        document.getElementById("spanMensaje").innerHTML = data; //muestro mensaje modal                  
                        mostrarTablaSuscripcionesSuscripcionBaja();//Refresco tabla
                    });
           }    
               
              
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
                        <a href="usuario_BajaModificacion.jsp?tipo=baja" class="w3-bar-item w3-button w3-mobile">Baja de Usuario</a>
                        <a href="usuario_BajaModificacion.jsp?tipo=modificacion" class="w3-bar-item w3-button w3-mobile">Modificación de Usuario</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa-address-card fa-fw"></i>&nbsp; Clientes</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="cliente_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Cliente</a>
                        <a href="cliente_BajaModificacion.jsp?tipo=baja" class="w3-bar-item w3-button w3-mobile">Baja de Cliente</a>
                        <a href="cliente_BajaModificacion.jsp?tipo=modificacion" class="w3-bar-item w3-button w3-mobile">Modificación de Cliente</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa fa-cubes fa-fw"></i>&nbsp; Paquetes</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="paquete_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Paquete</a>
                        <a href="paquete_BajaModificacion.jsp?tipo=baja" class="w3-bar-item w3-button w3-mobile">Baja de Paquete</a>
                        <a href="paquete_BajaModificacion.jsp?tipo=modificacion" class="w3-bar-item w3-button w3-mobile">Modificación de Paquete</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa fa-suitcase fa-fw"></i>&nbsp; Suscripciones</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="suscripcion_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Suscripci&oacute;n</a>
                        <a href="suscripcion_BajaModificacion.jsp?tipo=baja" class="w3-bar-item w3-button w3-mobile">Baja de Suscripci&oacute;n</a>
                        <a href="suscripcion_BajaModificacion.jsp?tipo=modificacion" class="w3-bar-item w3-button w3-mobile">Modificación de Suscripci&oacute;n</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-mobile">
                    <button class="w3-button"><i class="fa fa-video-camera fa-fw"></i>&nbsp; Dispositivos</button>
                    <div class="w3-dropdown-content w3-bar-block w3-dark-grey">
                        <a href="dispositivo_Alta.jsp" class="w3-bar-item w3-button w3-mobile">Alta de Dispositivo</a>
                        <a href="dispositivo_BajaModificacion.jsp?tipo=baja" class="w3-bar-item w3-button w3-mobile">Baja de Dispositivo</a>
                        <a href="dispositivo_BajaModificacion.jsp?tipo=modificacion" class="w3-bar-item w3-button w3-mobile">Modificación de Dispositivo</a>
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
                <%if (tipoJSP.equals("baja")) {%>
                <h5><b><i class="fa fa-suitcase"></i> Baja de Suscripci&oacute;n</b></h5>
                <%} else if (tipoJSP.equals("modificacion")) {%>
                <h5><b><i class="fa fa-suitcase"></i> Modificaci&oacute;n de Suscripci&oacute;n</b></h5>
                <%}%> 
            </header>
            <div class="form">
                <div><h5 class="nb-title-left">Ingrese los filtros por los que desea buscar</h5></div>
                <form>
                    <div>
                        <label for="txtbxIdSuscripcionBaja">Id Suscripcion: </label>
                        <input type="number" class="nb-input nb-input-number-sinFlechas" id="txtbxIdSuscripcionBaja" name="txtbxIdSuscripcionBaja">
                    </div>
                    <div class="margin-top20"><label>Fecha de inicio entre: </label>
                        <span id="spanFechasInicio">
                        <input type="date" class="nb-input-sinSize" id="calFechaInicioA" name="calFechaInicioA">
                        <label>&nbsp;&nbsp; y &nbsp;&nbsp;</label>
                        <input type="date" class="nb-input-sinSize" id="calFechaInicioB" name="calFechaInicioB">
                        </span>
                    </div>
                    <div class="margin-top20">
                        <label for="selTiempoContratoSuscripcionBaja">Tiempo de contrato:</label>
                            <select id="selTiempoContratoSuscripcionBaja" class="nb-input" name="selTiempoContratoSuscripcionBaja">
                                <option value="0.5" selected="true">6 meses</option>
                                <option value="1">1 año</option>
                                <option value="2">2 años</option>
                                <option value="3">3 años</option>
                                <option value="4">4 años</option>
                            </select>
                    </div>
                    <div class="margin-top20"><label>Fecha de fin entre: </label>
                        <span id="spanFechasFin">
                        <input type="date" class="nb-input-sinSize" id="calFechaFinA" name="calFechaFinA">
                        <label>&nbsp;&nbsp; y &nbsp;&nbsp;</label>
                        <input type="date" class="nb-input-sinSize" id="calFechaFinB" name="calFechaFinB">
                        </span>
                    </div>
                    <div class="margin-top20">
                        <label for="selActivaSuscripcionBaja">Activa? :</label>
                        <select id="selActivaSuscripcionBaja" class="nb-input" name="selActivaSuscripcionBaja">
                            <option value="true" selected="true">Si</option>
                            <option value="false">No</option>
                        </select>
                    </div>
                    <hr>
                    <div class="margin-top20">
                        <div class="botonera">
                            <input type="button" class ="submitSearch" onclick="buscarSuscripcion()" id="btnBuscarSuscripcion" value="Buscar">
                            <input type="reset" class="limpiarCampos" value="Limpiar campos">                            
                        </div>
                    </div>
                    <div class="margin-top20">
                        <div>
                            <h5 class="nb-title-center">Lista de Suscripciones</h5>
                        </div>
                        <span id="spanSuscripcionesSuscripcionBaja" name="generarTablaSuscripcionesBaja"></span>
                    </div>  
                    <div class="margin-top20">
                    <div class="botonera">
                                    <%
                                    if(tipoJSP.equals("baja")){%>
                                        <input type="button" class="submitBaja" id="btnBorrarSuscripcionesSeleccionadas" value="Borrar">                                      
                                    <%}else if(tipoJSP.equals("modificacion")){%>
                                        <input type="button" class="submitModificacion" id="btnModificarSuscripcionSeleccionada" value="Modificar">
                                    <%}%> 
                    </div>
                    </div>
                    <div id="divModal" class="w3-modal">
                        <div class="w3-modal-content w3-animate-zoom" >
                            <div class="w3-container">
                                <span id="spanBtnCerrar" class="w3-button w3-display-topright">&times;</span>
                                <br>
                                <span id="spanMensaje"></span>
                                <br>
                                <br>
                            </div>
                        </div>
                    </div>
                    
                     <%if (msg != null) {%>
                    <div>
                        <p class="message"><%=msg%></p>                        
                    </div>
                    <%}%>
                </form>
            </div>
        </div>
    </body>
</html>
