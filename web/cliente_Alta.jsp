<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String msg = request.getParameter("msg");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Cliente</title>
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
            mostrarTiposDocumento();
               function mostrarTiposDocumento(){
                $.get("ManejoClientesServlet?accion=comboTiposDocumento", function(data){
                    document.getElementById("selTiposDocumentoClienteAlta").innerHTML=data;
                });
            }
            mostrarPaises();
               function mostrarPaises(){
                $.get("ManejoClientesServlet?accion=comboPaises", function(data){
                    document.getElementById("selPaisesResidenciaClienteAlta").innerHTML=data;
                });
            }
            /*    mostrarUsuarioSistema();
                function mostrarUsuarioSistema(){
                $.get("ManejoClientesServlet?accion=generarUsuario", function(data){
                    document.getElementById("lblUsuarioSistema").innerHTML=data;
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
        <div class="ABMContainer">

            <!-- Header -->
            <header class="w3-container estilosHeader">
                <h5><b><i class="fa fa-address-card"></i> Alta de Clientes</b></h5>
            </header>
                <div class="form">
                    <form id="formAltaCliente" name="formAltaCliente" onsubmit="return validarAltaCliente(this)"  action="ManejoClientesServlet" method="post">
                        <!--<div><label>Usuario Sistema: <span id="lblUsuarioSistema" class='spanUsuario' name="generarUsuario"></span></div>-->
                        <div class="margin-top20"><label for="txtbxNroDocumentoClienteAlta">N&uacute;mero de Documento:</label>
                        <input type="text" id="txtbxNroDocumentoClienteAlta" class="nb-input" name="txtbxNroDocumentoClienteAlta" required="true"/></div>
                        
                        <div class="margin-top20"><label for="selTiposDocumentoClienteAlta">Tipo de documento:</label>
                        <span id="selTiposDocumentoClienteAlta" name="comboTiposDocumento"></span></div>
                        
                        <div class="margin-top20"><label for="txtbxNombreCompletoClienteAlta">Nombre completo:</label>
                        <input type="text" id="txtbxNombreCompletoClienteAlta" class="nb-input" name="txtbxNombreCompletoClienteAlta" required="true"/></div>
                        
                        <div class="margin-top20"><label for="selPaisesResidenciaClienteAlta">Pais de nacionalidad:</label>
                        <span id="selPaisesResidenciaClienteAlta" name="comboPaises"></span></div>
                        
                        <div class="margin-top20"><label for="txtbxEmailClienteAlta">Email:</label>
                        <input type="email" id="txtbxEmailClienteAlta" class="nb-input" name="txtbxEmailClienteAlta" required="true"/></div>
                        
                        <div class="margin-top20"><label for="txtbxTelefonoClienteAlta" >Telefono:</label>
                        <input type="text" id="txtbxTelefonoClienteAlta" class="nb-input" name="txtbxTelefonoClienteAlta" required="true"/></div>
                        <div class="borderDiv margin-top20">
                        <div><label for="selTipoCliente">Tipo de cliente</label></div>
                        <select id="selTipoCliente" class="nb-input" name="selTipoCliente">
                                <option value="Principal" selected="true">Titular</option>
                                <option value="Secundario">Cuenta secundaria</option>
                        </select>
                                <div id="divPrincipal">
                                    <input type="checkbox" class="w3-check" id="chkServicioActivoClienteAlta" name="chkServicioActivo">
                                    <label for="chkServicioActivoClienteAlta"> Servicio activo</label>
                                </div>
                                <div id="divSecundario">
                                    <label for="txtbxNroDocPrincipalClienteAlta">N&uacute;mero de Documento cuenta Titular:</label>
                                    <input type="text" id="txtbxNroDocPrincipalClienteAlta" class="nb-input" name="txtbxNroDocPrincipalClienteAlta"/>
                                </div>
                        </div>
                        <hr>        
                        <div class="botoneraAlta">
                        <input type="submit" class="submitAlta" value="confirmar">
                        <input type="reset" class="limpiarCampos" value="Limpiar campos">    
                        </div>
                        
                        <span id="mensajeAlta"></span>
                        <input type="hidden" name="accion" value="formAltaCliente">
                        <div id="divMensajeEmergente" class="modal">
                            <div class="modal-content">
                                <a class="cerrarMensajeEmergente" onclick="ocultarModal()">&times;</a>
                            <p id="pMensaje" class="message"></p>         
                            </div>
                        </div>
                        <%if (msg != null) {%>
                        <div id="divMensajeEmergenteBackEnd" class="modal">
                            <div class="modal-content">
                                <a class="cerrarMensajeEmergenteBackEnd">&times;</a>
                                <p id="pMensajeBackEnd" class="message"><%=msg%></p>         
                            </div>
                        </div>    
                        <%}%>
                    </form>
                </div>

            </div>
        </div>
    </body>
</html>
