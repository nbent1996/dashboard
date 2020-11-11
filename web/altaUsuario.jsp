<%-- 
    Document   : altaUsuario
    Created on : 10/11/2020, 06:58:39 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--CSS-->  
        <link rel="stylesheet" href="css/registroUsuario.css">
        <link href="bootstrap-4.5.2-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!--Javascript-->
        <script type="text/javascript" src="js/jquery-3.5.1.js"></script>
        <script type="text/javascript" src="bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
        <script src="bootstrap-4.5.2-dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway"> 
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        
        
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card card-signin flex-row my-5">
                        <div class="card-img-left d-none d-md-flex">
                            <!-- Background image for card set in CSS! -->
                        </div>
                        <div class="card-body">
                            <h5 class="card-title text-center">Registro de Usuario</h5>
                            <form class="form-signin" method="post" action="">
                                
                                <div class="form-label-group">
                                    <input type="text" id="txtNombreUsuario" class="form-control" placeholder="Usuario" required autofocus>
                                    <label for="lblNombreUsuario">Usuario</label>
                                </div>
                                
                                <div class="form-label-group">
                                    <input type="password" id="txtPassword" class="form-control" placeholder="Contraseña" required>
                                    <label for="lblPassword">Contraseña</label>
                                </div>

                                <div class="form-label-group">
                                    <input type="text" id="txtNombreCompleto" class="form-control" placeholder="Nombre completo" required>
                                    <label for="lblNombreCompleto">Nombre completo</label>
                                </div>
                                
                                <div class="form-label-group">
                                    <input type="text" id="txtNombreEmpresa" class="form-control" placeholder="Nombre empresa" required>
                                    <label for="lblNombreEmpresa">Nombre empresa</label>
                                </div>
                                
                                <div class="form-label-group">
                                    <select name="pais" id="pais">
                                        <option value="uru">Uruguay</option>
                                        <option value="ven">Venezuela</option>
                                        <option value="per">Perú</option>
                                        <option value="par">Paraguay</option>
                                        <option value="ecu">Ecuador</option>
                                        <option value="col">Colombia</option>
                                        <option value="bra">Brasil</option>
                                        <option value="bol">Bolivia</option>
                                        <option value="arg">Argentina</option>
                                        
                                    </select>
                                    <label for="lblPais">País</label>
                                </div>
                                
                                <div class="form-label-group">
                                    <select name="tipoUsuario" id="tipoUsuario" required>
                                        <option value="operador">Operador</option>
                                        <option value="administrador">Administrador</option>                                       
                                    </select>
                                    <label for="lblNombreEmpresa">Tipo usuario</label>
                                </div>
                                
                                <hr>

                                <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Registrar</button>
                                <a class="d-block text-center mt-2 small" href="#">Iniciar sesión</a>
                                <hr class="my-4">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
        
    </body>
</html>
