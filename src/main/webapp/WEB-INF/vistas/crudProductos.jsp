<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <c:if test="${sessionScope.objUsuario.idrol.idrol==null}">
    	<c:redirect url="/"/>
    </c:if>
    <c:if test="${sessionScope.objUsuario.idrol.idrol==1}">
    	<c:redirect url="/"/>
    </c:if>
<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Vendedor Admin - Productos</title>
	
    
    <link rel="stylesheet" href="css/reset.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:400,900" rel="stylesheet">
	<link rel="stylesheet" href="css/main.css">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <!-- EDITOR TEXT HTML 
    <link href="css/editor.css" type="text/css" rel="stylesheet"/>
    -->
	
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600|Open+Sans" rel="stylesheet"> 
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
	<link rel="stylesheet" href="css/estilos.css">
    
    <script src="js/ckeditor.js"></script>
	<script src="js/sample.js"></script>
	<link rel="stylesheet" href="css/neo.css">
	
	<!-- 
   <link href="css/dataTables.bootstrap.min.css" rel="stylesheet">  -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
   <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrapValidator.css"/>
    
	
<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.6.5/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.6.5/firebase-storage.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/8.6.5/firebase-analytics.js"></script>
	

    <!-- CSS only <link rel="stylesheet" href="css/samples.css"> -->
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
  	
  	#txtEditor div ul{
  		list-style-type: circle;  		
  	}
  	
  	#txtEditor div ol{
  		list-style-type: decimal;  		
  	}
  	
  	.card-img-top{
  		width:40%;
  	}
  	.img-list{
  		width:100%;
  	}
  	.modal-lg{
  		max-width: 60%;
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

<c:if test="${requestScope.CORRECTO!=null}">
<div class="alert alert-success alert-dismissible fade show" role="alert" id="success-alert">
  <strong></strong> ${requestScope.CORRECTO}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
<c:remove var="CORRECTO"/>

<c:if test="${requestScope.ERROR!=null}">
<div class="alert alert-danger alert-dismissible fade show" role="alert" id="success-alert">
  <strong></strong> ${requestScope.ERROR}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
<c:remove var="ERROR"/>

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Lista de Productos</h1>
                    <p class="mb-4">En esta seccion podra registrar, ver y editar los productos.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Lista de Productos</h6>
                        </div>
                        <div class="cont_mant ml-2">
							<button type="button" class="btn btn-info mt-4" data-toggle="modal" data-target="#nuevo">Nuevo <i class="fa fa-plus-circle" aria-hidden="true"></i></button>  
						</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="idTableProductos" width="100%" cellspacing="0">
                                    <thead>
                                         <tr>
								            <th>ID</th>
								            <th>Nombre</th>
								            <th>Descripcion</th>
								            <th>Stock</th>
								            <th>Precio(S/.)</th>
								            <th>Categoria</th>
								            <th>Marca</th>
								            <th>Imagen</th>
								            <th></th>
								            <th></th>
								            <th></th>
								        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                           <th>ID</th>
								            <th>Nombre</th>
								            <th>Descripcion</th>
								            <th>Stock</th>
								            <th>Precio(S/.)</th>
								            <th>Categoria</th>
								            <th>Imagen</th>
								            <th></th>
								            <th></th>
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
                      <h2>Registrar Poducto</h2>
                    </div>
                    <!-- producto/registrarProducto -->
                    <form  method="post" accept-charset="UTF-8" action="http://localhost:8090/producto/registra" id="idRegistrar"  data-toggle="validator" class="mt-3 form-horizontal">
                      <div class="row">
                        <div class="col-md-6">
                          <fieldset>
                          <input type="text" hidden="true" class="input"  name="idproducto" value="0" id="idCodProducto" placeholder="Ingresar Nombre">
							<input type="text" class="input"  name="nombre" id="idNombre" placeholder="Ingresar Nombre">
                          </fieldset>
                        </div>
                        <div class="col-md-3">
                          <fieldset>                           	
							<input type="text" class="input"  name="precio" id="idPrecio" placeholder="Ingresar Precio">
                          </fieldset>
                        </div>
                        <div class="col-md-3">
                          <fieldset>
							<input type="text" class="input"  name="stock" id="idStock" placeholder="Ingresar Stock">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>
							<input type="text" class="input"  name="marca" id="idMarca" placeholder="Ingresar Marca">
                          </fieldset>
                        </div>
                        
                        <div class="col-md-6">
                          <fieldset class="block">
							<select id="idCategoria"  class="input" name="idcategoria.idcategoria">	
								<option>[ Seleccione Categoria ]</option>
							</select>
						 </fieldset>
                        </div>
                        <div class="col-md-12">
                          <fieldset>                           	
							<textarea class="input"  name="descripcionSimple" id="idDescripcionSimple" placeholder="Ingresar descripcion simple"></textarea>
                          </fieldset>
                        </div>
                        
                         <div class="col-md-12">
                         	 <fieldset>    
		                          <div class="adjoined-bottom">
										<div class="grid-container">
											<div class="grid-width-100">
												<div id="editor">
													
												</div>
											</div>
										</div>
									</div>
							</fieldset>
                        </div>
                        <input type="hidden" class="input"  name="descripcionHTML" id="idDescripcionHTML">
                      
                        
                       <div class="col-md-4">
                          <fieldset>
                         	<label>Suba la 1° Imagen:</label>  
                         	<img id="foto1" src="img/image-not-found.png" class="card-img-top img-card"/>                         	
							<input type="file" class="input" onchange="uploadImage(0);"  name="files" id="idImagen1" placeholder="Ingresar Foto1">
							<input name="foto1" id="fotos1" value="img/image-not-found.png" hidden=""/>
							<input name="foto2" id="fotos2" value="img/image-not-found.png" hidden=""/>
							<input name="foto2" id="fotos3" value="img/image-not-found.png" hidden=""/>
                          </fieldset>
                        </div>
                        <div class="col-md-4">
                          <fieldset>          
                          	<label>Suba la 2° Imagen:</label>   
                          	<img id="foto2" src="img/image-not-found.png" class="card-img-top img-card"/>              	
							<input type="file" class="input" onchange="uploadImage(1);"  name="files" id="idImagen2" placeholder="Ingresar Foto2">
                          </fieldset>
                        </div>
                        <div class="col-md-4">
                          <fieldset>     
                          	<label>Suba la 3° Imagen:</label>
                          	<img id="foto3" src="img/image-not-found.png" class="card-img-top img-card"/>                          	
							<input type="file" class="input" onchange="uploadImage(2);"  name="files" id="idImagen3" placeholder="Ingresar Foto3">
                          </fieldset>
                        </div>
                        <div class="col-md-6">
                          <fieldset>     
                          	<label> Imagen:</label>                          	
							
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
        	¿Seguro de eliminar el Producto? 
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <form action="" method="post" name="formDelete" id="id_form_elimina">	
		  	  <input type="hidden" id="idEliminar" name="codigo">
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
	<script src="js/global.js"></script>
    <script src="popup.js"></script>
    
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script> -->
	<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.js"></script>
	
	<!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>
   <script src="js/sweetalert2.min.js"></script>
   
   <!-- Firebase App (the core Firebase SDK) is always required and must be listed first -->

  <!-- If you enabled Analytics in your project, add the Firebase SDK for Analytics -->

  <!-- Add Firebase products that you want to use
  <script src="https://www.gstatic.com/firebasejs/8.6.2/firebase-auth.js"></script>
  <script src="https://www.gstatic.com/firebasejs/8.6.2/firebase-firestore.js"></script> -->
<!-- The core Firebase JS SDK is always required and must be listed first -->

<!-- TODO: Add SDKs for Firebase products that you want to use
     https://firebase.google.com/docs/web/setup#available-libraries
<script src="https://www.gstatic.com/firebasejs/8.6.5/firebase-app.js"></script> 
<script src="https://www.gstatic.com/firebasejs/8.6.5/firebase-analytics.js"></script>-->

<script type="text/javascript">


$(document).on("click","#btnEditar",(function(){
	var cod=$(this).parents('tr').find("td")[0].innerHTML;
	$("#titleModal").text("Editar Area");
	//$("#idRegistrar").attr("action","producto/actualizaProducto")
	$.getJSON("http://localhost:8090/producto/buscaProductoXID/"+cod,{},function(data){
		console.log(data.producto);
		$("#idCodProducto").val(cod);
		//alert($("#idCodProducto").val());
		$("#idNombre").val(data.nombre);
		$("#idPrecio").val(data.precio);
		$("#idStock").val(data.stock);
		$("#idMarca").val(data.marca);
		$("#idDescripcionSimple").val(data.descripcionSimple);
		$("#idCategoria").val(data.idcategoria.idcategoria);
		//$("#idDescripcionHTML").val(data.descripcionHTML);
		CKEDITOR.instances.editor.destroy();
		$("#editor").append(data.descripcionHTML);
		initSample();
		$("#idImagen1").val(data.foto1);
		
	})
	//bloquear(false);
	
}));

$(document).on("click","#btnEliminar",(function(){
	var cod=$(this).parents('tr').find("td")[0].innerHTML;
	$("#idEliminar").val(cod);
}));


function bloquear(b){
	$("#idRegistrar input").prop("disabled",b);
	$("#idRegistrar select").prop("disabled",b);
	$("#btnRegistrar").prop("disabled",b);
}

function limpiar(){

	CKEDITOR.instances.editor.destroy();
	initSample();
	//bloquear(false);
	$("#idRegistrar").trigger("reset");
	$("#idRegistrar").data("bootstrapValidator").resetForm(true);
	$("#idCodProducto").val("0");
	$("#idRegistrar select").val("[ Seleccione Categoria ]");
	$("#idDescripcionHTML").val("");
	$("#foto1").attr("src","img/image-not-found.png");
	$("#foto2").attr("src","img/image-not-found.png");
	$("#foto3").attr("src","img/image-not-found.png");
	$("#fotos1").attr("src","img/image-not-found.png");
	$("#fotos2").attr("src","img/image-not-found.png");
	$("#fotos3").attr("src","img/image-not-found.png");
	
}

function listarTabla(){
	$('#idTableProductos').DataTable().clear();
	 $('#idTableProductos').DataTable().destroy();
	$('#idTableProductos tbody').append('<tr><td class="loading text-center mb-5" colspan="10"><img src="img/cargando.gif" width="10%" alt="loading" /><br/>Un momento, por favor...</td> </tr>');
	$.getJSON("http://localhost:8090/producto/lista",{},function(lista, q, t){
		console.log(lista);
		//var detalles="<button type='button' class='btn btn-info' id='btnDetalles' data-toggle='modal'  data-target='#idModalFoto'>Subir Foto</button>";
		var editar="<button type='button' class='btn btn-success' id='btnEditar' data-toggle='modal'  data-target='#nuevo'>Editar</button>";
		var eliminar="<button type='button' class='btn btn-danger' data-toggle='modal' data-target='#eliminar' id='btnEliminar'>Eliminar</button>";
		$("#idTableProductos tbody").empty();
		var c=0;
		$.each(lista,function(index,item){
			var img="image-not-found.png";
			$("#idTableProductos tbody").append("<tr><td>"+item.idproducto+"</td><td>"+
					item.nombre+"</td><td style='width:30%;'>"+
					item.descripcionSimple+"</td><td>"+
					item.stock+"</td><td>"+
					item.precio+"</td><td>"+
					item.idcategoria.nombre+"</td><td>"+
					item.marca+"</td><td><img  src='img/cargando.gif' onload='$(this).attr(\"src\",\""+item.foto1+"\")' class='img-list' alt='No existe' />"+
					"</td><td><a href='verDetalleProducto?id="+
							item.idproducto+"' target='_blank'><i class='fas fa-eye'></i></a></td><td>"+editar+"</td><td>"+eliminar+"</td></tr>");
			
			//$(".img-list").eq(c).attr("src",item.foto1);
			c++;
		})//class='card-img-top'
		$("#idTableProductos").DataTable();
		/*$('.img-list').on('load', function() {
			  alert("image is loaded");
		});*/
    })
	
}

$(document).ready( function () {

    
	
	$("#success-alert").fadeTo(2000,500).slideUp(500,function(){
		$("#success-alert").slideUp(500);	
	});
	initSample();
	localStorage.clear();
    //alert("Hola");
  
   //$("#id_table").DataTable();
    
	listarTabla();
    
    $.getJSON("http://localhost:8090/combo/categoria",{},function(data, q,t){
        console.log(data);
		//$("#idCategoria").append("<option></option>");
		$.each(data,function(index,item){
			//$("#idCategoria").emmpty();
			$("#idCategoria").append("<option value='"+item.idcategoria+"'>"+item.nombre+"</option>");
		})
    })
 
    
    $("#btnCancelar").click(function(){
		//alert("hola"); 
    	limpiar();
    	//$("#idRegistrar").attr("action","producto/registrarProducto")
    });


    $("#btnRegistrar").click(function(){
    	var txt= CKEDITOR.instances.editor.getData();
    	$("#idDescripcionHTML").val(txt);
		//alert("¿Está seguro de enviar?");
		var validator = $('#idRegistrar').data('bootstrapValidator');
	    validator.validate();
	    
	    if (validator.isValid()) {
	    	const file=document.getElementsByName("files")[0].files[0];
	    	var sizeByte = file.size;
	        var sizekiloBytes = parseInt(sizeByte / 1024);
	    	if(sizekiloBytes>100){
	    		alert("El tamaño de archivo es "+sizekiloBytes+" KB y supero el limite");
	    		return;
	    	}
	    	
			$.ajax({
	    		  type: "POST",
		          url: "http://localhost:8090/producto/registra", 
	    		  data: $("#idRegistrar").serialize(),
		          success: function(data){
		        	/*
		        	//var urls = new Array();
		        	for(var i=0;i<3;i++){
						uploadImage(i);
			    	}*/
		        	
		        	//console.log(urls);
		        	listarTabla();
		        	mostrarMensaje("Se registro crorectamente el producto "+data.idproducto);
		        	//guardarFotos(data.idproducto);
		        	limpiar();
		        	//limpiarFormCliente();
		          },
		          error: function(message){
		        	  console.log(message);
		        	  mostrarMensaje(message.responseJSON.detail);
		          }
		     });
	    }
		
		//$("#idRegistrar").submit();
    });
    
    function guardarFotos(id){
    	var urls=new Array();
    	for(var i=0;i<3;i++){
    		urls[i]=$("#foto"+(i+1)).val();
    	}
		
    	var obj={foto1 : urls[0], foto2 : urls[1], foto3 : urls[2], idproducto : id};
    	console.log(obj);
    	$.ajax({
  		  type: "PUT",
	          url: "http://localhost:8090/producto/subirFotos", 
  		  	  data: obj,
	          success: function(data){
	        	mostrarMensaje("Se registro crorectamente las fotos");
	        	//limpiarFormCliente();
	          },
	          error: function(message){
	        	  console.log(message);
	        	  mostrarMensaje(message.responseJSON.detail);
	          }
	     });
    }
    
    $("#btn_eliminar").click(function(){
		var cod=$("#idEliminar").val();
     	  $("#eliminar").modal("hide");
    	$.ajax({
            type: "DELETE",
            url: "http://localhost:8090/producto/elimina/"+cod, 
            //data: $('#id_form_elimina').serialize(),
            success: function(data){
            	$("#idTableProductos tbody").empty();
          	  	listarTabla();
          	  mostrarMensaje("Se elimino correctamente");	          	
            },
            error: function(message){
            	mostrarMensaje(message.responseJSON.detail);
            }
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
                           message: 'Ingrese nombre de Producto'    
                       },      
                       regexp: {    
                           regexp: /^[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\s\w]+$/,    
                           message: 'Letras y números'    
                       },    
                   }    
               },
               Precio: {
          	    	selector:'#idPrecio',   
                         validators: {    
                             notEmpty: {    
                                 message: 'Ingrese Precio del Producto'    
                             },      
                             regexp: {    
                                 regexp: /^([1-9])([0-9]{1,})?[.]([0-9]{2})+$/,    
                                 message: 'El precio debe tener formato: #.##, y el primer dígito debe ser mayor a 0'    
                             },    
                         }    
                 },
                 Stock: {
         	    	selector:'#idStock',   
                        validators: {    
                            notEmpty: {    
                                message: 'Ingrese Stock del Producto'    
                            },      
                            regexp: {    
                                regexp: /^([1-9])([0-9]{1,})?$/,    
                                message: 'Solo numeros enteros y que el primero sea mayor a 0'    
                            },    
                        }    
                },
                Marca: {
        	    	selector:'#idMarca',   
                       validators: {    
                           notEmpty: {    
                               message: 'Ingrese Unidades en Pedido del Producto'    
                           },      
                           regexp: {    
                               regexp: /^[a-zA-ZáéíóúÁÉÍÓÚñÑ-\s\w]+$/,    
                               message: 'Letras y números'    
                           },    
                       }    
                   },
            DescripcionSimple: {
	    	selector:'#idDescripcionSimple',   
               validators: {    
                   notEmpty: {    
                       message: 'Ingrese Descripcion Simple del Producto'    
                   },  
               }    
           },
           Categoria: {
     	    	selector:'#idCategoria',   
                    validators: {    
                        notEmpty: {    
                            message: 'Elija una categoria'    
                        },
                        integer: {       
                            message: 'Por favor elija una categoria'    
                        },    
                    }    
            },
           DescripcionHTML: {
     	    	selector:'#idDescripcionHTML',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese una descripcion en el editor de Texto.'    
                        },   
                    }    
            },
           Foto1: {
     	    	selector:'#idImagen1',   
                    validators: {    
                    	notEmpty: {    
                            message: 'Elija un archivo'    
                        },      
                        regexp: {    
                            regexp: /\.(gif|jpe?g|png|webp|bmp)$/i,    
                            message: 'Solo admite formatos: .jpe, .jpg, .png, .webp, .bmp'    
                        },      
                    }    
            },
           Foto2: {
     	    	selector:'#idImagen2',   
                    validators: {    
                    	regexp: {    
                            regexp: /\.(gif|jpe?g|png|webp|bmp)$/i,    
                            message: 'Solo admite formatos: .jpe, .jpg, .png, .webp, .bmp'    
                        }, 
                    }    
            },
           Foto3: {
     	    	selector:'#idImagen3',   
                    validators: {    
                    	regexp: {    
                            regexp: /\.(gif|jpe?g|png|webp|bmp)$/i,    
                            message: 'Solo admite formatos: .jpe, .jpg, .png,  .webp, .bmp'    
                        },
                    }    
            }
       	 }
       }); 
    });
 </script>
    
</body>

</html>