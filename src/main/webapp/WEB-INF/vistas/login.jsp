<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Iniciar Sesion</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="eCommerce HTML Template Free Download" name="keywords">
        <meta content="eCommerce HTML Template Free Download" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/slick/slick.css" rel="stylesheet">
        <link href="lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style_theme_blue.css" rel="stylesheet">
    </head>

    <body>
        <!-- Top bar Start -->
        <jsp:include page="menuCliente.jsp"></jsp:include>
        <!-- Nav Bar End -->      
        
        <!-- Bottom Bar Start -->
        
        <!-- Bottom Bar End --> 
        
        
        
        <!-- Login Start -->
        <div class="login">
            <div class="container-fluid">
            <c:if test="${sessionScope.MENSAJE!=null}">
			<div class="alert alert-warning alert-dismissible fade show" role="alert" id="success-alert">
			  <strong></strong> ${sessionScope.MENSAJE}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>
			</c:if>
			<c:remove var="MENSAJE"/>
                <div class="row">
                    <div class="col-md-3 mx-auto" style="width: 200px;">
                        <form class="login-form" action="" method="post" id="formLogin">
                            <div class="block text-left">
                                <div class="col-md-12">
                                    <label>Correo:</label>
                                    <input class="form-control" type="text" id="idCorreo" placeholder="Correo" name="username"/>
                                </div>
                                <div class="col-md-12">
                                    <label>Contraseña:</label>
                                    <input class="form-control" type="password" id="idClave" placeholder="Contraseña" name="password"/>
                                    <input class="form-control" hidden="" id="idGrantType" value="password" name="grant_type"/>
                                </div>
                                <div class="col-md-12 text-center">
	                                <div class="col-md-12">
	                                    <div class="custom-control custom-checkbox">	                                    	
	                                		<label class="">¿Estas registrado? <a href="verRegistroCliente">Registrate aquí</a></label>
	                                        <!-- <input type="checkbox" class="custom-control-input" id="newaccount">
	                                        <label class="custom-control-label" for="newaccount">Keep me signed in</label> -->
	                                    </div>
	                                </div>
	                                <div class="col-md-12">
	                                    <button class="btn border" id="btnLogin" type="button">Iniciar Sesion</button>
	                                </div>                                
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Login End -->
        
        <!-- Footer Start -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Get in Touch</h2>
                            <div class="contact-info">
                                <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                                <p><i class="fa fa-envelope"></i>email@example.com</p>
                                <p><i class="fa fa-phone"></i>+123-456-7890</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Follow Us</h2>
                            <div class="contact-info">
                                <div class="social">
                                    <a href=""><i class="fab fa-twitter"></i></a>
                                    <a href=""><i class="fab fa-facebook-f"></i></a>
                                    <a href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a href=""><i class="fab fa-instagram"></i></a>
                                    <a href=""><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Company Info</h2>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Terms & Condition</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Purchase Info</h2>
                            <ul>
                                <li><a href="#">Pyament Policy</a></li>
                                <li><a href="#">Shipping Policy</a></li>
                                <li><a href="#">Return Policy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="row payment align-items-center">
                    <div class="col-md-6">
                        <div class="payment-method">
                            <h2>We Accept:</h2>
                            <img src="img/payment-method.png" alt="Payment Method" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="payment-security">
                            <h2>Secured By:</h2>
                            <img src="img/godaddy.svg" alt="Payment Security" />
                            <img src="img/norton.svg" alt="Payment Security" />
                            <img src="img/ssl.svg" alt="Payment Security" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
        
        <!-- Footer Bottom Start -->
        <div class="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 copyright">
                        <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
                    </div>

                    <div class="col-md-6 template-by">
                        <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->       
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/slick/slick.min.js"></script>
        
        <script type="text/javascript" src="js/carrito_js.js"></script>
        <script type="text/javascript" src="js/verCarrito.js"></script>
        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script type="text/javascript">
        
        	$(document).ready(function(){
        		$("#success-alert").fadeTo(2000,500).slideUp(500,function(){
        			$("#success-alert").slideUp(500);	
        		});
        		

        	    $("#btnLogin").click(function(){
        	    	/*var obj={
        	    		username : $("#idCorreo").val(),
        	    		password : $("#idClave").val(),
        	    		grant_type: $("#idGrantType").val()
        	    		Authorization:"Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZHJvbCI6MSwidXNlcl9uYW1lIjoiam9yZ2UuZGlhekBnbWFpbC5jb20iLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiYXBlbGxpZG8iOiJEaWF6IiwiY29ycmVvIjoiam9yZ2UuZGlhekBnbWFpbC5jb20iLCJleHAiOjE2MjQyNTk1OTgsIm5vbWJyZSI6IkpvcmdlIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9DTElFTlRFIl0sImp0aSI6IjA4Nzg5Y2MyLTk0MTktNDU4Mi1hYzRjLTg5MDNkMGEzMjBmZiIsImNsaWVudF9pZCI6ImNsaWVudGVkc3ciLCJpZHVzdWFyaW8iOjU2fQ.Yh9ZGZ3063gkqecCVXy0GfrBtLatAOkGCBY-5_QMTjCaKcIGB8xg4J-2sKDhgwxFeE7s8ffHHwR8LMZ-ltyAD8YtvDErVuTkejj942boQhAyTNdgMlDNk6bMTVeFoRBgE38EJ3SoiExr7TQuaThoQZfPMI1e1DoKGsfs_kkvBvV2xwbnoSgWnBbuVWEuwOFBO1Nhc0Sa5pOGy6YSfPPQaR0Ps9e_TAtKkgJyJkikeCT9uK9NMCuf1E2gmC81sck5dfKlUsFHWejulqk1BV7RCEMSSwbnbEVwOnT8Cdxb0US-A19V6i0kVnK7UZVrL1dByG8s5nCURCNMOkpVO09aeg", 
        	    		Cookie:"JSESSIONID=08789cc2-9419-4582-ac4c-8903d0a320ff"
        	    	};
        	    	alert(JSON.stringify(obj));*/
        	    	//alert("Hola");
        	    
        	    	var url="http://localhost:8090/oauth/token?username="+$("#idCorreo").val()+"&password="+
        	    			$("#idClave").val()+"&grant_type="+$("#idGrantType").val();
        	    		var settings = {
        	  	  		  "url": url,
        	  	  		  "method": "POST",
        	  	  		  "timeout": 0,
        	  	  		  "headers": {
        	  	  			"Authorization":"Basic Y2xpZW50ZWRzdzpkc3c",
            	    		"Content-Type": "application/json"
        	  	  		  }
        	  	  		};
        	    		
        	    		$.ajax(settings)
        	    			.done(function (response) {
	        	    		  
	        	    		  var userToken=response;
	        	    		  var url2 = "http://localhost:8090/usuario/traerEnlaces/"+response.idusuario;
	        	    		  var token1 = response.access_token;
	        	    		  var cookie = response.jti;
		        	    		  $.ajax(leerLogin(url2,"GET","",token1,cookie))
		        	    			.done(function (lista) {
				        	    		  var listado=lista;
			        	    		  console.log(listado);
			        	    		  console.log(userToken);
			        	    		  //$(location).attr('href',"/verInicio?token="+response+"&opcion="+lista);
			        	    		  
			        	    		  $.ajax({
			        	  				url:"usuario/token",
			        	  				type:"POST",
			        	  				data:{token : JSON.stringify(userToken), opcion : JSON.stringify(listado)}, 
			        	  				success: function(result){
			        	  					$(location).attr('href',"/");
			        	  				},
			        	  				error: function(error){
			        	  					alert("No funciona");
			        	  				}
			        	  			});
			        	    		  //var userToken=response;
			        	    		  //$(location).attr('href',"/verInicio?");
		        	    			})
		        	    			.fail(function(mensaje) {
						    			mostrarMensaje(MSG_ERROR);
									});
	        	    		  //$(location).attr('href',"/verInicio?");
        	    			})
        	    			.fail(function(mensaje) {
				    			mostrarMensaje(MSG_ERROR);
							});
        	    		
        	    		
        	    		/*
        		    	$.ajax({
        		    		  type: "POST",
        			          url: "usuario/login", 
        			          data: $("#formLogin").serialize(),
        			          //contentType: "application/json",
        			          success: function(data){
        			        	 mostrarMensaje("Inicio de Sesion correcto");
        		        		 //$(location).attr('href',"/verLogin");
        			        	// limpiarFormCliente();
        			          },
        			          error: function(message){
        			        	  console.log(message);
        			        	  mostrarMensaje(message.responseJSON.detail);
        			          }
        			     });*/
        					    
        		 });
        	    
        	    function leerLogin(url,method,json,token,cookie){
        	    	var settings = {
        	  		  "url": url,
        	  		  "method": method,
        	  		  "timeout": 0,
        	  		  "headers": {
        	  		    "Authorization": "Bearer "+token,
        				"Content-Type": "application/json",
        	  		    "Cookie": "JSESSIONID="+cookie
        	  		  },
        	  		  "data": JSON.stringify(json),
        	  		};
        			 return settings;
        		}
        		
        	});
        
        </script>
        
    </body>
</html>
