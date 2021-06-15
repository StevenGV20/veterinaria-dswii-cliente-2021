package com.veterinaria.cliente.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Cita;
import com.veterinaria.cliente.entity.Mascota;
import com.veterinaria.cliente.entity.Producto;
import com.veterinaria.cliente.entity.Servicio;
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
	
	Mascota[] listaMascotasByCliente(int cod) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Mascota[]> response=rt.getForEntity(REST_MASCOTAS+"listaMascotasByCliente/"+cod, Mascota[].class);
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
	
	Mascota buscarMascotaById(int cod) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Mascota> response=rt.getForEntity(REST_MASCOTAS+"buscarMascotaById/"+cod, Mascota.class);
		return response.getBody();
	}
	
	
	///ENLACES
	
	@RequestMapping("/")
	public String verInicio(ModelMap flash) {
		Producto[] productos= listaProductos();
		Servicio[] servicios= listaServicios();
		flash.addAttribute("LISTAPRODUCTOS", productos);
		flash.addAttribute("LISTASERVICIOS", servicios);
		return "index";
	}
	
	//VISTA ADMINISTRADOR
	
	@RequestMapping("/verCitas")
	public String verCitas(HttpSession session,HttpServletRequest request) {
		Usuario user=(Usuario)session.getAttribute("objUsuario");
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Cita[]> response=null;
		Cita[] lista= null;
		if(user.getIdrol().getIdrol()<2) {
			response=rt.getForEntity(REST_CITA+"listaCitaByCliente/"+user.getIdusuario(), Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}else if(user.getIdrol().getIdrol()<4) {
			response=rt.getForEntity(REST_CITA+"listAll", Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}else if(user.getIdrol().getIdrol()==5) {
			response=rt.getForEntity(REST_CITA+"listarCitaByVeterinario/"+user.getIdusuario(), Cita[].class);
			lista=response.getBody();
			request.setAttribute("citas", lista);
		}
		return "listaCitas";
	}
	
	@RequestMapping("/verMisMascotas")
	public String verCrudMascotas(HttpSession session,HttpServletRequest request) {
		Usuario usu=(Usuario) session.getAttribute("objUsuario");
		Mascota[] lista= listaMascotasByCliente(usu.getIdusuario());
		request.setAttribute("mascotas", lista);
		request.setAttribute("codCliente", usu.getIdusuario());
		return "misMascotas";
	}
	
	@RequestMapping("/verMascotasByCliente")
	public String verMascotasByCliente(int cod,HttpServletRequest request) {
		Mascota[] lista= listaMascotasByCliente(cod);
		request.setAttribute("mascotas", lista);
		request.setAttribute("codCliente", cod);
		return "misMascotas";
	}
	
	@RequestMapping("/verMisPedidos")
	public String verMisPedidos(HttpSession session,HttpServletRequest request) {
		Usuario user=(Usuario)session.getAttribute("objUsuario");
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Tracking[]> response=null;
		Tracking[] lista= null;
		if(user.getIdrol().getIdrol()<2) {
			response=rt.getForEntity(REST_TRACKING+"listaByCliente/"+user.getIdusuario(), Tracking[].class);
			lista=response.getBody();
			request.setAttribute("pedidos", lista);
		}else if(user.getIdrol().getIdrol()<4) {
			response=rt.getForEntity(REST_TRACKING+"listaAll", Tracking[].class);
			lista= response.getBody();
			request.setAttribute("pedidos", lista);
		}else if(user.getIdrol().getIdrol()==4) {
			response=rt.getForEntity(REST_TRACKING+"listaByTrabajador/"+user.getIdusuario(), Tracking[].class);
			lista= response.getBody();
			request.setAttribute("pedidos", lista);
		}
		return "misPedidos";
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
		return "tracking";
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
