   <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
<title>Foro Grupal</title>

    <link rel="stylesheet" href="css/demo_chat_editor.css">
    
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css">
    <link rel="stylesheet" href="css/medium-editor.css">
    <link rel="stylesheet" href="css/theme_chat_editor.css" id="medium-editor-theme"> 
    
<link rel="stylesheet" href="css/main_chat.css" />

<style>

#container{
	width: 100%;
	margin: 0px auto;
}
.editable p{
	margin-bottom: -5px;
}


</style>

</head>
<body background="18.jpg"
	style="background-position: center; background-repeat: no-repeat; background-size: cover;">
	<noscript>
		<h2>Sorry! Your browser doesn't support Javascript</h2>
	</noscript>
	<c:if test="${sessionScope.objUsuario.nombre == null }">
		<div id="username-page">
			<div class="username-page-container">
				<h1 class="title">Ingresa tu nombre</h1>
				<form id="usernameForm" name="usernameForm">
					<div class="form-group">
						<input type="text" id="name" placeholder="Username"
							autocomplete="off" class="form-control" value=""/>
					</div>
					<div class="form-group">
						<button type="submit" class="accent username-submit">Iniciar Chat</button>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	<c:if test="${sessionScope.objUsuario.nombre != null }">
		<div id="username-page">
			<div class="username-page-container">
				<h1 class="title">Ingresa tu nombre</h1>
				<form id="usernameForm" name="usernameForm">
					<div class="form-group">
						<input type="text" id="name" placeholder="Username"
							autocomplete="off" class="form-control" value="${sessionScope.objUsuario.nombre} ${sessionScope.objUsuario.apellido}"/>
					</div>
					<div class="form-group">
						<button type="submit" class="accent username-submit">Iniciar Chat</button>
					</div>
				</form>
			</div>
		</div>
	</c:if>
	<div id="chat-page" class="hidden">
		<div class="chat-container">
			<div class="chat-header">
				<h2>Bienvenido</h2>
			</div>
			<div class="connecting">Connecting...</div>
			<ul id="messageArea">
				<li class="chat-message"><i style="background-color: rgb(57, 187, 176);">V</i><span>Vendedor</span>
					<p>Hola soy el vendedor deseas consultarme algo?</p>
				</li>

			</ul>
			<!-- BEGIN FORM FOR SEND MESSAGE -->
			<form id="messageForm" name="messageForm" nameForm="messageForm">
				<div class="form-group">
					<div class="input-group clearfix">
					
					<!-- INPUT FOR SEND MESSAGE
						<input type="text" id="message" autocomplete="off"  placeholder="Type a message..."
							 class="form-control" /> -->
					<!--BEGIN INPUT HTML FOR SEND MESSAGE -->
					 <div id="container">
				        <textarea class="editable medium-editor-textarea form-control" style="height: 100px;overflow-y: scroll;" id="message" autocomplete="off"> </textarea>
				    </div>				    
					
					<!--END INPUT HTML FOR SEND MESSAGE -->							
						<button type="submit" class="primary">Send</button>
					</div>
				</div>
			</form>
			<!-- END FORM FOR SEND MESSAGE -->
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script src="/js/main_chat.js"></script>
	
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script src="js/medium-editor.js"></script>
	
	<script type="text/javascript">
	 var editor = new MediumEditor('.editable', {
         buttonLabels: 'fontawesome'
     });
	 $(document).ready(function(){
			$("ul a").css("background-color","blue");
		});
	</script>
</body>
</html>