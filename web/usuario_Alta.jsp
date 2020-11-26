
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String msg = request.getParameter("msg");
   
%>

<% String alertCombos = request.getParameter("errorCombos"); %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de Usuario</title>
        
        <link href="css/seccionesUsuarios.css" rel="stylesheet" type="text/css"/>
        <script src="js/seccionesUsuarios.js" type="text/javascript"></script>
        
        
    </head>
    <body>
        <script src="js/jquery-3.5.1.js" type="text/javascript"></script>
        
        
        
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
                
               /*function prueba(){
                $.get("ManejoUsuariosServlet?accion=prueba", function(data){
                    //document.getElementById("combo-paises").innerHTML=data;
                    console.log(data);
                });
                
            }*/
     
                
            
       
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
        
        
        
        
        <div>
            <h1 class="titulos">Alta de Usuario</h1>
        </div>
        
        <div class="usuarios-page">
            
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
                    
                    
                    <!-- ESTO ES PARA ERROR EN LA CARGA DE COMBOS. PROBAR -->
                    <%if (alertCombos != null) {%>
                        alert(alertCombos);
                    <%}%>
                    
                    <!--
                        <select name="pais" id="pais">
                            <option value="uru">Uruguay</option>
                            <option value="arg">Argentina</option>
                            <option value="bra">Brasil</option>
                        </select>
                        <select name="tipoUsuario" id="tipoUsuario">
                            <option value="operador">Operador</option>
                            <option value="administrador">Administrador</option>
                        </select>
                    -->
                    <input type="submit" class="submitAlta" value="crear">
                    
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
