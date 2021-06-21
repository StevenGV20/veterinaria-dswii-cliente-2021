<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <c:if test="${sessionScope.objUsuario.idrol==null}">
    	<c:redirect url="/"/>
    </c:if>
    <c:if test="${sessionScope.objUsuario.idrol==1}">
    	<c:redirect url="/"/>
    </c:if>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Vendedor Admin - Servicios</title>
    
    <link rel="stylesheet" href="./css/reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="./css/main.css">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600|Open+Sans" rel="stylesheet"> 
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<link rel="stylesheet" href="css/estilos.css">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
    <!-- CSS only -->

 <style>
  	.forms input{
  		margin-bottom: 0px;
  	}
  	.forms select{
  		margin-bottom: 0px;
  	}
  	.forms fieldset{
  		margin-top: 10px;
  		display: flex;
  		flex-direction: column; 
  	}
  	section.forms{
  		margin-top:30px;
  		margin-bottom:10px;
  	}
  	.forms h2{
  		margin-bottom:0px;
  	}
  	small{
  		color:red;
  		margin-bottom: 10px;
  	}
  </style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="slidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
               	<jsp:include page="navbar.jsp"></jsp:include>
                <!--#include file="navbar.html"-->
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Lista del Personal de Trabajo</h1>
                    <p class="mb-4">En esta seccion podra registrar, ver y editar a los trabajadores de la Empresa.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Trabajadores</h6>
                        </div>
                        <div class="cont_mant ml-2">
							<button type="button" class="btn btn-info mt-4" onclick="$('#nuevo').modal('show')">Nuevo <i class="fa fa-plus-circle" aria-hidden="true"></i></button>  
						</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="tbPersonal" width="100%" cellspacing="0">
                                    <thead>
                                         <tr>
								            <th>ID</th>
								            <th>Nombre</th>
								            <th>Apellidos</th>
								            <th>Telefono</th>
								            <th>Dni</th>
								            <th>Correo</th>
								            <th>Distrito</th>
								            <th>Cargo</th>
								            <th></th>
								            <th></th>
								        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>ID</th>
								            <th>Nombre</th>
								            <th>Apellidos</th>
								            <th>Telefono</th>
								            <th>Dni</th>
								            <th>Correo</th>
								            <th>Distrito</th>
								            <th>Cargo</th>
								            <th></th>
								            <th></th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

<div class="modal fade bd-example-modal-lg" id="nuevo"  data-backdrop="static" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
 		 <section class="forms ml-4 mr-4 m-4">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <div class="section-heading">
                      <h2>Registrar Trabajador</h2>
                    </div>
                    <form  method="post" action="" id="idRegistrar" data-toggle="validator" class="mt-3 form-horizontal">
                      <div class="row">
                        <div class="col-md-6">
                          <fieldset class="form-group">
							<input type="text" class="input" hidden="" name="idusuario" value="0" id="idCodigo" placeholder="Ingresar nombre">
							<input type="text" class="input"  name="nombre" id="idNombre" placeholder="Ingresar nombre">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset class="form-group">
                         	
							<input type="text" class="input"  name="apellido" id="idApellido" placeholder="Ingresar apellidos">
                          </fieldset>
                        </div>
                        <div class="col-md-12">
                          <fieldset class="form-group">
                         	
							<input type="text" class="input"  name="direccion" id="idDireccion" placeholder="Ingresar direccion">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset class="form-group">
                         	
							<input type="text" class="input"  name="telefono" id="idTelefono" placeholder="Ingresar telefono">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset class="form-group">                         	
							<input type="text" class="input"  name="dni" id="idDni" placeholder="Ingresar dni">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>                           	
							<input type="text" class="input"  name="correo" id="idCorreo" placeholder="Ingresar Correo">
                          </fieldset>
                        </div>
                        <div class="col-md-6" id="idDivPassword">
                          <fieldset class="form-group">                         	
							<input type="password" class="input"  name="password" id="idPassword" placeholder="Ingresar password">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                          	<label>Sexo</label>
							<select id="idSexo"  class="input" name="sexo">	
								<option>[ Seleccione ]</option>
								<option value="MASCULINO">MASCULINO</option>
								<option value="FEMENINO">FEMENINO</option>
							</select>
						 </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                          	<label>Distrito:</label>
							<select id="idDistrito"  class="input" name="iddistrito">	
								<option>[ Seleccione ]</option>
							</select>
						 </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
                          	<label>Cargo:</label>
							<select id="idRol"  class="input" name="idrol">	
								<option>[ Seleccione ]</option>
							</select>
						 </fieldset>
                        </div>
                       
                        <div class="col-md-12 mt-2">
                          <button type="button" class="btn__submit" id="btnRegistrar">Registrar</button>  		
        				  <button type="button" class="btn__reset" id="btnCancelar" data-dismiss="modal">Cancelar</button>
                        </div>
                        
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </section>
      
    </div>
  </div>
</div>



<div class="modal fade bd-example-modal-lg" id="eliminar"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
    <div class="modal-content">
    <div class="modal-header">
      	 <h5 class="modal-title" id="exampleModalLabel">¿Está seguro de eliminar?</h5>
      </div>
      <!-- Modal body -->
        <div class="modal-body">
        	¿Seguro de eliminar al Trabajador? 
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <form action="" method="post" name="formDelete" id="id_form_elimina">	
		  	  <input type="hidden" id="idEliminar" name="id">
	          <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
	          <button type="button" id="btn_eliminar" data-dismiss="modal" class="btn btn-primary">Eliminar</button>
            </form>
        </div>
        
    </div>
  </div>
</div>

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Maqueta V.01 &copy; Pagina echa 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">Ã</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>
    
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/transition.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/custom.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
    
    <script src="popup.js"></script>
    <script src="js/global.js"></script>
   <script type="text/javascript" src="//cdn.jsdelivr.net/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
    <script type="text/javascript">

    $(document).on("click","#btnEditar",(function(){
    	var cod=$(this).parents('tr').find("td")[0].innerHTML;
    	$("#idDivPassword").hide();
    	$("#idCorreo").parent().parent().attr("class","col-md-12");
    	$.ajax( settingsRegistro("http://localhost:8090/usuario/buscaUsuarioXID?id="+cod,"GET","",
				"<c:out value="${sessionScope.objUsuario.access_token}"/>","<c:out value="${sessionScope.objUsuario.jti}"/>")
		).done(function (data) {
		  console.log(data);
			$("#idCodigo").val(data.idusuario);
			$("#idNombre").val(data.nombre);
			$("#idApellido").val(data.apellido);
			$("#idDireccion").val(data.direccion);
			$("#idTelefono").val(data.telefono);
			$("#idDni").val(data.dni);
			$("#idCorreo").val(data.correo);
			$("#idSexo").val(data.sexo);
			$("#idPassword").val(data.password);
			$("#idDistrito").val(data.iddistrito.iddistrito);
    		$("#idRol").val(data.idrol.idrol);
		})
    	
    }));

$(document).on("click","#btnEliminar",(function(){
	var cod=$(this).parents('tr').find("td")[0].innerHTML;
	$("#idEliminar").val(cod);
}));




function listarTablas(){
	$('#tbPersonal').DataTable().clear();
	 $('#tbPersonal').DataTable().destroy();
	$('#tbPersonal tbody').append('<tr><td class="loading text-center mb-5" colspan="10"><img src="img/cargando.gif" width="10%" alt="loading" /><br/>Un momento, por favor...</td> </tr>');
	
    $.ajax(settingsRegistro("http://localhost:8090/usuario/listaPersonalTrabajo","GET","",
			"<c:out value="${sessionScope.objUsuario.access_token}"/>","<c:out value="${sessionScope.objUsuario.jti}"/>")
	).done(function (response) {
		  console.log(response);
		  var editar="<button type='button' class='btn btn-success' id='btnEditar' data-toggle='modal'  data-target='#nuevo'>Editar</button>";
			var eliminar="<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#eliminar' id='btnEliminar'>Eliminar</button>";
			$("#tbPersonal tbody").empty();
			$.each(response,function(index,item){
				$("#tbPersonal tbody").append("<tr><td>"+item.idusuario+"</td><td>"+item.nombre+"</td><td>"+item.apellido+"</td><td>"+item.dni+
						"</td><td>"+item.telefono+"</td><td>"+item.correo+"</td><td>"+item.iddistrito.nombre+"</td><td>"+(item.idrol.nombre).split("_")[1]+
						"</td><td>"+editar+"</td><td>"+eliminar+"</td></tr>");
			})
		$("#tbPersonal").DataTable();
	});
}

function limpiarForm(){
	//bloquear(false);
	$("#idRegistrar").trigger("reset");
	$("#idRegistrar").data("bootstrapValidator").resetForm(true);
	$("#idDistrito").val("[ Seleccione ]");
	$("#idRol").val("[ Seleccione ]");
	$("#idSexo").val("[ Seleccione ]");
	$("#idCodigo").val("0");
	$("#idDivPassword").show();
	$("#idCorreo").parent().parent().attr("class","col-md-6");
}

$(document).ready( function () {

	
	$("#success-alert").fadeTo(2000,500).slideUp(500,function(){
		$("#success-alert").slideUp(500);	
	});
    
    //alert("Hola");
    
    listarTablas();
    $("#btnCancelar").click(function(){
    	limpiarForm();
    	$("#nuevo").modal("hide");
    });

    $.getJSON("http://localhost:8090/combo/distrito",{},function(data, q,t){
        console.log(data);
		$.each(data,function(index,item){
			$("#idDistrito").append("<option value='"+item.iddistrito+"'>"+item.nombre+"</option>");
		})
    })
    
    $.getJSON("http://localhost:8090/combo/rol",{},function(data, q,t){
        console.log(data);
		$.each(data,function(index,item){
			if(item.idrol!=1)
				$("#idRol").append("<option value='"+item.idrol+"'>"+(item.nombre).split("_")[1]+"</option>");
		})
    })

    $("#btnRegistrar").click(function(){
    	var validator = $('#idRegistrar').data('bootstrapValidator');
	    validator.validate();
	    if (validator.isValid()) {
	    	if($("#idCodigo").val()>0){
	    		actualiza();
	    	}else{
	    		registrar();
	    	}
	    	$("#nuevo").modal("hide");
		}
		    
	  });
    
    function registrar(){
    	$.ajax( 
       			settingsRegistro("http://localhost:8090/usuario/registrarUsuario","POST",leerUsuario(),
           				"<c:out value="${sessionScope.objUsuario.access_token}"/>","<c:out value="${sessionScope.objUsuario.jti}"/>")
        	).done(function (response) {
        		listarTablas();
            	mostrarMensaje("Se registro crorectamente el usuario "+response.idusuario);
            	limpiarForm();
            	$("#nuevo").modal("hide");
        	})
        	.fail(function(mensaje) {
    			mostrarMensaje(mensaje.responseJSON.detail);
    		});
    }
    
    function actualiza(){
    	
    	$.ajax( 
   			settingsRegistro("http://localhost:8090/usuario/actualizaUsuario","PUT",leerUsuario(),
       				"<c:out value="${sessionScope.objUsuario.access_token}"/>","<c:out value="${sessionScope.objUsuario.jti}"/>")
    	).done(function (response) {
    		listarTablas();
        	mostrarMensaje("Se actualizó crorectamente el usuario "+response.idusuario);
        	limpiarForm();
        	$("#nuevo").modal("hide");
    	})
    	.fail(function(mensaje) {
			mostrarMensaje(mensaje.responseJSON.detail);
		});
    }
    

    
    $("#btn_eliminar").click(function(){
   	 $("#eliminar").modal("hide");
   	 	var cod=$("#idEliminar").val();
   		$.ajax( 
   			settingsRegistro("http://localhost:8090/usuario/eliminaUsuario?id="+cod,"DELETE","",
       				"<c:out value="${sessionScope.objUsuario.access_token}"/>","<c:out value="${sessionScope.objUsuario.jti}"/>")
    	).done(function (response) {
        	mostrarMensaje("Se elimino crorectamente el usuario "+cod);
    		listarTablas();
        	limpiarFormCliente();
    	})
    	.fail(function(mensaje) {
    		console.log(mensaje);
			mostrarMensaje(mensaje.responseJSON.detail);
		});
    });
    
} );
</script>

<script type="text/javascript">  
    $(document).ready(function(){    

        $('#idRegistrar').bootstrapValidator({      
       	 fields:{
       		 
       		 Nombre: {
    	    	selector:'#idNombre',   
                   validators: {    
                       notEmpty: {    
                           message: 'Ingrese Nombre'    
                       },      
                       regexp: {    
                           regexp: /^[a-zA-ZáéíóúÁÉÍÓÚ\s\w]+$/,    
                           message: 'Letras y números'    
                       },    
                   }    
               },
         Apellido: {
 	    	selector:'#idApellido',   
                validators: {    
                    notEmpty: {    
                        message: 'Ingrese Apellidos'    
                    },      
                    regexp: {    
                        regexp: /^[a-zA-ZáéíóúÁÉÍÓÚ\s\w]+$/,    
                        message: 'Letras y números'    
                    },    
                }    
            },
           Direccion: {
	    	selector:'#idDireccion',   
               validators: {    
                   notEmpty: {    
                       message: 'Ingrese Direccion'    
                   },  
               }    
           },
           Telefono: {
   	    	selector:'#idTelefono',   
                  validators: {    
                      notEmpty: {    
                          message: 'Ingrese Telefono'    
                      },      
                      regexp: {    
                    	  regexp: /^[0-9]{7,9}$/,  
                          message: 'Ingresar un numero entre 7 y 9 digitos'    
                      },     
                  }    
          },
          Dni: {
     	    	selector:'#idDni',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Dni'    
                        },      
                        regexp: {    
                            regexp: /^[0-9]{8}$/,    
                            message: 'Solo ingrese 8 digitos'    
                        },    
                    }    
            },
            Correo: {
     	    	selector:'#idCorreo',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Correo'    
                        },      
                        emailAddress: {
                            message: 'Por favor introduce un correo válido'
                        },    
                    }    
            },
          Sexo: {
     	    	selector:'#idSexo',   
                    validators: {    
                        notEmpty: {    
                            message: ''    
                        },      
                        regexp: {   
                        	regexp: /^[A-Z]+$/,    
                            message: 'Elija un Sexo'    
                        },     
                    }    
            },
          Distrito: {
     	    	selector:'#idDistrito',   
                    validators: {    
                        notEmpty: {    
                            message: 'Elija un Distrito'    
                        },      
                        regexp: {    
                            regexp: /^[0-9]+$/,    
                            message: 'Elija un Distrito'    
                        },     
                    }    
            },
          Rol: {
     	    	selector:'#idRol',   
                    validators: {    
                        notEmpty: {    
                            message: 'Elija un Rol'    
                        },      
                        integer: {
                            message: 'Por favor elija un rol'
                        },    
                    }    
            }
       	 }
       }); 
    });
 </script>
</body>

</html>