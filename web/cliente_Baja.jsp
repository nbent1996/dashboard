<%-- 
    Document   : cliente_Baja
    Created on : 01/12/2020, 11:10:29 AM
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
        <title>Baja Cliente</title>
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
            
            mostrarTablaClientes();    
            
                function mostrarTablaClientes(){
                    $.get("ManejoClientesServlet?accion=mostrarTablaClientesInicio", function(data){
                        document.getElementById("tblClientesFiltrados").innerHTML=data;
                    });               
                }
                
                function buscarClienteBaja(){
                          
                        var nroCliente = $("#txtbNroClienteBaja").val();
                        var emailCliente = $("#txtbEmailClienteBaja").val();
                        var nombreCompletoCliente = $("#txtbNombreCompletoBajaCli").val();
                        $.get("ManejoClientesServlet?accion=buscarClientesBaja&nroCliente=" + nroCliente + "&emailCliente=" + emailCliente + "&nombreCompletoCliente=" + nombreCompletoCliente, function (data) {
                            document.getElementById("tblClientesFiltrados").innerHTML = data;
                            document.getElementById("spanMensaje").innerHTML = ""; //MÉTODO PARA LIMPIAR CAMPO
                        });
                    }
                    
                    
                function borrarClientesSeleccionados(){
                    var listaClientesSeleccionados = new Array();
                    $("input:checkbox:checked").each(   
                        function() {
                            listaClientesSeleccionados.push($(this).val());
                            //alert("El checkbox con valor " + $(this).val() + " está seleccionado");
                        }
                    );
                        $.get("ManejoClientesServlet?accion=borrarClientes&listaClientes=" + listaClientesSeleccionados, function (data) {

                        document.getElementById("spanMensaje").innerHTML = data; //muestro mensaje modal
                        mostrarTablaClientes();//Refresco tabla
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
                <h5><b><i class="fa fa-address-card"></i> Baja de Clientes</b></h5>
            </header>
            <div class="form">
                <!--LAS BÚSQUEDAS SE HACEN POR AJAX CON BUTTONS, NO SE USAN FORMS-->
                <div><h5 class="nb-title-left">Ingrese los filtros por los que desea buscar</h5></div>
                <!--NUMERO DE CLIENTE, EMAIL (CLIENTE), NOMBRE COMPLETO (PERSONA)-->
                    <div class="margin-top20"><label for="txtbNroClienteBaja">Número de cliente: </label><input type="text" class="nb-input" id="txtbNroClienteBaja" name="nroClienteBaja"/></div>
                    <div class="margin-top20"><label for="txtbEmailClienteBaja">Email: </label><input type="text" class="nb-input" id="txtbEmailClienteBaja" name="emailClienteBaja"/></div>
                    <div class="margin-top20"><label for="txtbNombreCompletoBajaCli">Nombre y/o Apellido: </label><input type="text" class="nb-input" id="txtbNombreCompletoBajaCli" name="nombreCompletoBajaCli"/></div>                        
                    <div class="botonera">
                        <input type="button" class ="submitSearch" onclick="buscarClienteBaja()" id="btnBuscarClienteBaja" value="Buscar">
                        <input type="reset" class="limpiarCampos" value="Limpiar campos">                            
                    </div>
                    <%if (msg != null) {%>
                    <div>
                        <p class="message"><%=msg%></p>                        
                    </div>
                    <%}%>
                    <div id="tablaClientes" >
                        <table class="w3-table-all">
                            <caption><h5 class="nb-title-center">Lista de Clientes</h5></caption>
                            <thead>
                                <tr>
                                    <th>Nro Cliente</th>
                                    <th>Nombre Completo</th>
                                    <th>Email</th>
                                    <th>Tipo Cliente</th>
                                    <th>Seleccionar</th>
                                    <!--Ver si mostrar tipo (principal o secundario)-->
                                </tr>
                            </thead>
                            <tbody id="tblClientesFiltrados">
                            </tbody>
                        </table>
                        <div class="margin-top20">
                            <div class="botonera">
                                <input type="button" onclick="borrarClientesSeleccionados()" class="submitBaja" id="btnBorrarClientesSeleccionados" value="Borrar">
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
                        </div>                   
                    </div>
            </div>
        </div>  
    </body>
</html>
