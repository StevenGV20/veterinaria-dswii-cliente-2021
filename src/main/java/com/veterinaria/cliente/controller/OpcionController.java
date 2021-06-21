package com.veterinaria.cliente.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Cita;
import com.veterinaria.cliente.entity.DetallePedidoUsuario;
import com.veterinaria.cliente.entity.Mascota;
import com.veterinaria.cliente.entity.Opcion;
import com.veterinaria.cliente.entity.PageProductos;
import com.veterinaria.cliente.entity.PageServicios;
import com.veterinaria.cliente.entity.Producto;
import com.veterinaria.cliente.entity.Servicio;
import com.veterinaria.cliente.entity.Token;
import com.veterinaria.cliente.entity.Tracking;
import com.veterinaria.cliente.entity.Usuario;

@Controller
@SessionAttributes({"LISTAPRODUCTOS","LISTASERVICIOS"})
public class OpcionController {
	
	private String REST_PRODUCTOS="http://localhost:8090/producto/";
	private String REST_SERVICIOS="http://localhost:8090/servicio/";
	private String REST_MASCOTAS="http://localhost:8090/mascota/";
	//private String REST_PEDIDOS="http://localhost:8090/pedido/";
	private String REST_TRACKING="http://localhost:8090/tracking/";
	private String REST_CITA="http://localhost:8090/cita/";
	
	//VISTA CLIENTE
	/*@RequestMapping("/index")
	public String index() {
		return "index";
	}
	*/
	
	///LISTADOS	
	Producto[] listaProductos() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
		return response.getBody();
	}
	
	Servicio[] listaServicios() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"lista", Servicio[].class);
		return response.getBody();
	}
	
	PageProductos[] listaProductosByPage() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<PageProductos[]> response=rt.getForEntity(REST_PRODUCTOS+"listaByPage/0", PageProductos[].class);
		return response.getBody();
	}
	
	PageServicios[] listaServiciosByPage() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<PageServicios[]> response=rt.getForEntity(REST_SERVICIOS+"listaByPage?page=0&size=6", PageServicios[].class);
		return response.getBody();
	}
	
	Mascota[] listaMascotasByCliente(int cod,Token user) {
		HttpHeaders headerRp=new HttpHeaders();
		//MediaType mediaTypeRp=new MediaType("application","json");
		headerRp.setContentType(MediaType.APPLICATION_JSON);
		//headerRp.setBearerAuth(token.getAccess_token());
		System.out.println("TOKEN: "+user.getAccess_token()); 
		headerRp.add("Authorization","Bearer "+ user.getAccess_token());
		headerRp.add("Cookie", user.getJti());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headerRp);
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Mascota[]> response=rt.exchange(REST_MASCOTAS+"listaMascotasByCliente/"+cod,
				HttpMethod.GET, entity,Mascota[].class);
		return response.getBody();
	}
	
	
	//BUSQUEDAS
	Servicio buscaServicioById(int cod) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio> response=rt.getForEntity(REST_SERVICIOS+"buscaServicioById/"+cod, Servicio.class);
		return response.getBody();
	}
	
	Producto buscaProductoById(int cod) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Producto> response=rt.getForEntity(REST_PRODUCTOS+"buscaProductoById/"+cod, Producto.class);
		return response.getBody();
	}
	
	Mascota buscarMascotaById(Token user) {
		HttpHeaders headerRp=new HttpHeaders();
		//MediaType mediaTypeRp=new MediaType("application","json");
		headerRp.setContentType(MediaType.APPLICATION_JSON);
		//headerRp.setBearerAuth(token.getAccess_token());
		System.out.println("TOKEN: "+user.getAccess_token()); 
		headerRp.add("Authorization","Bearer "+ user.getAccess_token());
		headerRp.add("Cookie", user.getJti());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headerRp);
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Mascota> response=rt.exchange(REST_MASCOTAS+"buscarMascotaById/"+user.getIdusuario(), HttpMethod.GET, entity, Mascota.class);
		return response.getBody();
	}
	
	
	///ENLACES
	
	@RequestMapping("/")
	public String verInicio(ModelMap flash) {
		//PageProductos[] productos= listaProductosByPage();
		//PageServicios[] servicios= listaServiciosByPage();
		//flash.addAttribute("LISTAPRODUCTOS", productos[0].getContent());
		//flash.addAttribute("LISTASERVICIOS", servicios[0].getContent());
		return "index";
	}
	
	//VISTA ADMINISTRADOR
	
	@RequestMapping("/verCitas")
	public String verCitas(HttpSession session,HttpServletRequest request) {
		Token user=(Token)session.getAttribute("objUsuario");
		HttpHeaders headerRp=new HttpHeaders();
		//MediaType mediaTypeRp=new MediaType("application","json");
		headerRp.setContentType(MediaType.APPLICATION_JSON);
		//headerRp.setBearerAuth(token.getAccess_token());
		System.out.println("TOKEN: "+user.getAccess_token()); 
		headerRp.add("Authorization","Bearer "+ user.getAccess_token());
		headerRp.add("Cookie", user.getJti());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headerRp);
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Cita[]> response=null;
		Cita[] lista= null;
		if(user.getIdrol()<2) {
			response=rt.exchange(REST_CITA+"listaCitaByCliente/"+user.getIdusuario(), HttpMethod.GET, entity, Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}else if(user.getIdrol()<4) {
			response=rt.exchange(REST_CITA+"listAll", HttpMethod.GET, entity, Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}else if(user.getIdrol()==5) {
			response=rt.exchange(REST_CITA+"listarCitaByVeterinario/"+user.getIdusuario(), HttpMethod.GET, entity, Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}
		return "listaCitas";
	}
	
	@RequestMapping("/verMisMascotas")
	public String verCrudMascotas(HttpSession session,HttpServletRequest request) {
		Token usu=(Token) session.getAttribute("objUsuario");
		Mascota[] lista= listaMascotasByCliente(usu.getIdusuario(),usu);
		request.setAttribute("mascotas", lista);
		request.setAttribute("codCliente", usu.getIdusuario());
		return "misMascotas";
	}
	
	@RequestMapping("/verMascotasByCliente")
	public String verMascotasByCliente(int cod,HttpServletRequest request,HttpSession session) {
		Token usu=(Token) session.getAttribute("objUsuario");
		Mascota[] lista= listaMascotasByCliente(cod,usu);
		request.setAttribute("mascotas", lista);
		request.setAttribute("codCliente", cod);
		return "misMascotas";
	}
	
	@RequestMapping("/verMisPedidos")
	public String verMisPedidos(HttpSession session,HttpServletRequest request) {
		Token user=(Token)session.getAttribute("objUsuario");
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Tracking[]> response=null;
		
		HttpHeaders headerRp=new HttpHeaders();
		//MediaType mediaTypeRp=new MediaType("application","json");
		headerRp.setContentType(MediaType.APPLICATION_JSON);
		//headerRp.setBearerAuth(token.getAccess_token());
		System.out.println("TOKEN: "+user.getAccess_token()); 
		headerRp.add("Authorization","Bearer "+ user.getAccess_token());
		headerRp.add("Cookie", user.getJti());
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headerRp);		
		
		Tracking[] lista= null;
		if(user.getIdrol()<2) {
			response=rt.exchange(REST_TRACKING+"listaByCliente/"+user.getIdusuario(), HttpMethod.GET, entity, Tracking[].class);
			lista=response.getBody();
			request.setAttribute("pedidos", lista);
		}else if(user.getIdrol()<4) {
			response=rt.exchange(REST_TRACKING+"listaAll", HttpMethod.GET, entity, Tracking[].class);
			lista= response.getBody();
			request.setAttribute("pedidos", lista);
		}else if(user.getIdrol()==4) {
			response=rt.exchange(REST_TRACKING+"listaByTrabajador/"+user.getIdusuario(), HttpMethod.GET, entity, Tracking[].class);
			lista= response.getBody();
			request.setAttribute("pedidos", lista);
		}
		return "misPedidos";
	}

	@RequestMapping("/consultarTracking")
	public String consultarTracking(int cod,HttpServletRequest request,HttpSession session) {
		if(!(cod+"").matches("[0-9]{1,}")) {
			System.out.println("HOLASSS");
			return "redirect:/";			
		}
		else {
			Token user=(Token)session.getAttribute("objUsuario");
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Tracking> responseTra=null;
			ResponseEntity<DetallePedidoUsuario[]> responseDet=null;
			
			HttpHeaders headerRp=new HttpHeaders();
			//MediaType mediaTypeRp=new MediaType("application","json");
			headerRp.setContentType(MediaType.APPLICATION_JSON);
			//headerRp.setBearerAuth(token.getAccess_token());
			System.out.println("TOKEN: "+user.getAccess_token()); 
			headerRp.add("Authorization","Bearer "+ user.getAccess_token());
			headerRp.add("Cookie", user.getJti());
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headerRp);	
			
			responseTra=rt.exchange(REST_TRACKING+"buscaByPedido/"+cod, 
					HttpMethod.GET, entity, Tracking.class);
			
			responseDet=rt.exchange(REST_TRACKING+"buscarHistorialPedido/"+cod,
					HttpMethod.GET, entity, DetallePedidoUsuario[].class);
			Tracking track=responseTra.getBody();
			DetallePedidoUsuario[] historial = responseDet.getBody();
			request.setAttribute("tracking", track);
			request.setAttribute("historial", historial);
			return "pedidoTracking";
		}
			
	}
	
	
	@RequestMapping("/verCrudClientes")
	public String verCliente() {
		return "crudClientes";
	}
	
	@RequestMapping("/verChatVendedor")
	public String verChatVendedor() {
		return "foroVendedor";
	}
	@RequestMapping("/verChatCliente")
	public String verChatCliente() {
		return "foroCliente";
	}
	
	@RequestMapping("/verChatPersonal")
	public String verChatPersonal() {
		return "chatCliente";
	}
	
	@RequestMapping("/verCarrito")
	public String verCarrito() {
		return "carritoCompras";
	}
	
	@RequestMapping("/verTracking")
	public String verTracking() {
		return "pedidoTracking";
	}

		
	@RequestMapping("/verRegistroCliente")
	public String verRegistroCliente() {
		return "registrarCliente";
	}
	
	@RequestMapping("/verLogin")
	public String verLogin() {
		return "login";
	}
	
	@RequestMapping("/verTablesConsultas")
	public String verTablesConsultas() {
		return "tablesConsultas";
	}
	
	@RequestMapping("/verTablesIncidencias")
	public String verTablesIncidencias() {
		return "tablesIncidencias";
	}
//-----------------MIREEEEEEEEN ESTOOOOO---------------
	@RequestMapping("/verCrudMascotas")
	public String verCrudMascotas() {
		return "crudMascotas";
	}
	
	@RequestMapping("/verCrudProductos")
	public String verCrudProductos() {
		return "crudProductos";
	}
	
	@RequestMapping("/verDetalleProducto")
	public String verDetalleProducto(int id,HttpServletRequest request) {
		Producto obj=buscaProductoById(id);
		request.setAttribute("objProducto", obj);
		return "detalleProducto";
	}
	
	@RequestMapping("/verListaProductos")
	public String verListaProductos(ModelMap flash) {
		Producto[] productos= listaProductos();
		flash.addAttribute("LISTAPRODUCTOS", productos);
		return "listaProductos";
	}
	
	@RequestMapping("/verCrudServicios")
	public String verCrudServicios() {
		return "crudServicios";
	}
	
	@RequestMapping("/verListaServicios")
	public String verListaServicios(ModelMap flash) {
		Servicio[] servicios= listaServicios();
		flash.addAttribute("LISTASERVICIOS", servicios);
		return "listaServicios";
	}
	
	@RequestMapping("/verDetalleServicio")
	public String verDetalleServicio(int id, HttpServletRequest request) {
		Servicio objServicio=buscaServicioById(id);
		request.setAttribute("objServicio", objServicio);
		return "detalleServicio";
	}
	
	@RequestMapping("/verCrudTrabajadores")
	public String listaTrabajadores() {
		return "crudTrabajadores";
	}
	
	@RequestMapping("/verInicioAdmin")
	public String verInicioAdmin() {
		return "inicioAdmin";
	}
	
	@RequestMapping("/verTablesVendedor")
	public String verTablesVendedor() {
		return "tablesVendedor";
	}
	
	@RequestMapping("/verRegistroMascotas")
	public String verRegistroMascotas() {
		return "registrarMascota";
	}
	
	@RequestMapping("/verRegistroDeCliente")
	public String verRegistroDeCliente() {
		return "registroCliente";
	}
	
	
	@RequestMapping("/verRegistroConsultas")
	public String verRegistroConsultas() {	return "registroConsultas";	}
	
	@RequestMapping("/verRegistroIncidencia")
	public String verRegistroIncidencia() {	return "registroIncidencia";	}
	
	@RequestMapping("/verRegistroPedido")
	public String verRegistroPedido() {	return "registroPedido";	}
}
