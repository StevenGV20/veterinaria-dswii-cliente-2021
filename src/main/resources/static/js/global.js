var MSG_ERROR = "Se gener&oacute; un error, consulte al administrador";
var MSG_ELIMINAR = "&#191;Desea eliminar el registro&#63;";
var MSG_ELIMINADO = "Se elimino correctamente";

//alert('hola');

 function settingsRegistro(url,method,json,token,cookie){
	    	var settings = {
	  		  "url": url,
	  		  "method": method,
	  		  "timeout": 0,
	  		  "headers": {
	  		    "Authorization": "Bearer "+token,
				"Content-Type": "application/json",
	  		    "Cookie": cookie
	  		  },
	  		  "data": JSON.stringify(json),
	  		};
	  		console.log(settings);
			 return settings;
		}

function leerMascota(){
	var cod=$("#idCodigo").val();
	var cli=$("#idCodCliente").val();
	var nom=$("#idNombre").val();
	var age=$("#idEdad").val();
	var raza=$("#idRaza").val();
	var fec=$("#idFechaNac").val();
	var sex=$("#idSexo").val();
	var esp=$("#idEspecie").val();
	
	var obj={
		idmascota : cod,
		cliente : {
			idusuario : cli
		},
		nombre : nom,
		edad : age,
		fechaNacimiento : fec,
		raza : raza,
		sexo : sex,
		idespecie : {
			idespecie : esp
		}
	}
	return obj;
}

function leerCliente(){
    	var cod=$("#idCodigo").val();
	    var nom=$("#idNombre").val();
	    var ape=$("#idApellido").val();
	    var dir=$("#idDireccion").val();
	    var fon=$("#idTelefono").val();
	    var dni=$("#idDni").val();
	    var cor=$("#idCorreo").val();
	    var sex=$("#idSexo").val();
	    var psw=$("#idPassword").val();
	    var dis=$("#idDistrito").val();
	    
	    var obj = {
	    		idusuario : cod,
	    		nombre : nom,
	    		apellido : ape,
	    		direccion : dir,
	    		telefono : fon,
	    		dni : dni,
	    		correo : cor,
	    		sexo : sex,
	    		password : psw,
	    		iddistrito : {
	    			iddistrito : dis
	    		}
	    }
	    return obj;
    }
    
    function leerUsuario(){
    	var cod=$("#idCodigo").val();
	    var nom=$("#idNombre").val();
	    var ape=$("#idApellido").val();
	    var dir=$("#idDireccion").val();
	    var fon=$("#idTelefono").val();
	    var dni=$("#idDni").val();
	    var cor=$("#idCorreo").val();
	    var sex=$("#idSexo").val();
	    var rol=$("#idRol").val();
	    var psw=$("#idPassword").val();
	    var dis=$("#idDistrito").val();
	    
	    var obj = {
	    		idusuario : cod,
	    		nombre : nom,
	    		apellido : ape,
	    		direccion : dir,
	    		telefono : fon,
	    		dni : dni,
	    		correo : cor,
	    		sexo : sex,
	    		password : psw,
	    		iddistrito : {
	    			iddistrito : dis
	    		},
	    		idrol: {
	    			idrol : rol
	    		}
	    }
	    return obj;
    }
    
    function leerProducto(){
    	var cod=$("#idCodProducto").val();
	    var nom=$("#idNombre").val();
	    var pre=$("#idPrecio").val();
	    var sto=$("#idStock").val();
	    var mar=$("#idMarca").val();
	    var cat=$("#idCategoria").val();
	    var desSim=$("#idDescripcionSimple").val();
	    var desht=$("#idDescripcionHTML").val();
	    var f1=$("#fotos1").val();
	    var f2=$("#fotos2").val();
	    var f3=$("#fotos3").val();
    	var obj = {
    		idproducto:cod,
    		marca:mar,
    		nombre:nom,
    		precio:pre,
    		stock:sto,
    		descripcionSimple :desSim,
    		descripcionHTML : desht,
    		idcategoria :{
    			idcategoria : cat
    		},
    		foto1:f1,
    		foto2:f2,
    		foto3 :f3 
    	};
    	console.log("My obj: "+obj);
    	return obj;
    }
    
    
    function leerServicio(){
    	var cod=$("#idCodServicio").val();
	    var nom=$("#idNombre").val();
	    var pre=$("#idPrecio").val();
	    var des=$("#idDescripcion").val();
	    var hor=$("#idHorario").val();
	    var cat=$("#idCategoria").val();
	    var f1=$("#fotos1").val();
    	var obj = {
    		idservicio : cod,
    		nombre : nom,
    		precio:pre,
    		descripcion : des,
    		horario :hor,
    		idcategoria :{
    			idcategoria : cat
    		},
    		foto:f1,
    	};
    	console.log("My obj: "+obj);
    	return obj;
    }
   
function mostrarMensaje(msg, ejecutarAccion){
	$('#id_my_modal').remove();
	
	$("body").append('<div class="modal fade" id="id_my_modal" role="dialog"><div class="modal-dialog"><div class="modal-content">' + 
					 '<div class="modal-header"><button type="button" class="close" data-dismiss="modal">&times;</button><h4 class="modal-title">Mensaje</h4></div>'+
					 '<div class="modal-body"><p>'+msg+'</p></div>'+
					 '<div class="modal-footer"><button type="button" id="id_btn_dialog_aceptar" class="btn btn-primary btn-sm">Aceptar</button></div>'+
					 '</div></div></div>');
	
	$("#id_btn_dialog_aceptar").click(function(){
		$('#id_my_modal').modal("hide");
		if(ejecutarAccion != undefined){
			window.location.href = ejecutarAccion;
		}
	});
	
	$('#id_my_modal').modal("show");
}


function mostrarMensajeConfirmacion(msg, accionAceptar, accionCancelar, data){
	$('#id_my_modal_confirmacion').remove();
	
	$("body").append('<div class="modal fade" id="id_my_modal_confirmacion" role="dialog"><div class="modal-dialog"><div class="modal-content">' + 
					 '<div class="modal-header"><button type="button" class="close" data-dismiss="modal">&times;</button><h4 class="modal-title">Mensaje</h4></div>'+
					 '<div class="modal-body"><p>'+msg+'</p></div>'+
					 '<div class="modal-footer">'+
					 '<button type="button" id="id_btn_dialog_si" class="btn btn-primary btn-sm">Si</button>'+
					 '<button type="button" id="id_btn_dialog_no" class="btn btn-default">No</button>'+
					 '</div>'+
					 '</div></div></div>');
	
	$("#id_btn_dialog_si").click(function(){
		$('#id_my_modal_confirmacion').modal("hide");
		if(accionAceptar != null){
			accionAceptar(data);
		}
	});
	$("#id_btn_dialog_no").click(function(){
		$('#id_my_modal_confirmacion').modal("hide");
		if(accionCancelar != null){
			accionCancelar(data);
		}
	});
	
	$('#id_my_modal_confirmacion').modal("show");
}
