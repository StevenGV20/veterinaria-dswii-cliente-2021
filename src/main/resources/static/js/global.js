var MSG_ERROR = "Se gener&oacute; un error, consulte al administrador";
var MSG_ELIMINAR = "&#191;Desea eliminar el registro&#63;";
var MSG_ELIMINADO = "Se elimino correctamente";

//alert('hola');

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
    
var firebaseConfig = {
   	    apiKey: "AIzaSyBxWqCgzMttyuU6SuqQm1Y2Yzrim_VQNZo",
   	    authDomain: "veterinariaweb-a901c.firebaseapp.com",
   	    projectId: "veterinariaweb-a901c",
   	    storageBucket: "veterinariaweb-a901c.appspot.com",
   	    messagingSenderId: "606620728073",
   	    appId: "1:606620728073:web:2a31aa9f1907fb1b08f1d8",
   	    measurementId: "G-QBYB64D4ZK"
   	  };
   	  // Initialize Firebase
   	  firebase.initializeApp(firebaseConfig);
   	  firebase.analytics();
   	  //uploadImage();
   	  function uploadImage(i){
   		  alert("Hola");
   		  const ref= firebase.storage().ref();
   		  var img='img/image-not-found.png';
   		  //img/cargando.gif
   		  //const file1= $("input[name=files]").eq(0);//document.querySelector("input[name=files]")[0];
   		  const file1=document.getElementsByName("files")[i].files[0];
   		var sizeByte = file1.size;
        var sizekiloBytes = parseInt(sizeByte / 1024);
		 if(file1!=null){
	    	if(sizekiloBytes>100){
	    		$("#foto"+(i+1)).val(img);
	    		alert("El tamaño de la imagen "+(i+1)+" es "+sizekiloBytes+" KB y supero el limite");
	    		return;
	    	}
   	   		  const name = new Date + '-'+file1.value;
   			  
   			  const metadata={
   					  contentType: file1.type
   			  }
   			 $("#foto"+(i+1)).attr("src","img/cargando.gif");
   			  const task = ref.child(name).put(file1, metadata);
   			  task
   			  .then(snapshot => snapshot.ref.getDownloadURL())
   			  .then(url => {
   				  console.log(url);
   				  //img=url;
   				  //alert("Image upload successful");
   				  $("#fotos"+(i+1)).val(url);
   				  //const imageElement = $("#image1");
   				  //imageElement.attr("src",url);
   				  $("#foto"+(i+1)).attr("src",url);
   				  //return url;
   			  });   
   			  /*var url = $("#foto"+(i+1)).val();
   			  console.log("URL: "+url);
   			  alert(url);
   			  return url;*/
   			  
   		  }else{
   			$("#foto"+(i+1)).val(img);
   		  }
   			  //return img;
   		  
   		  /*
   		  console.log(ref);
   		  return img;*/
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
