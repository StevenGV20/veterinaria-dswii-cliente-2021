package com.veterinaria.cliente.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Producto;
import com.veterinaria.cliente.entity.Servicio;

@Controller
@SessionAttributes({"LISTAPRODUCTOS","LISTASERVICIOS"})
public class OpcionController {
	
	private String REST_PRODUCTOS="http://localhost:8090/producto/";
	private String REST_CATEGORIAS="http://localhost:8090/combo/categoria";
	private String REST_SERVICIOS="http://localhost:8090/servicio/";
	
	//VISTA CLIENTE
	/*@RequestMapping("/index")
	public String index() {
		return "index";
	}
	*/
	
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
	
	@RequestMapping("/")
	public String verInicio(ModelMap flash) {
		Producto[] productos= listaProductos();
		Servicio[] servicios= listaServicios();
		flash.addAttribute("LISTAPRODUCTOS", productos);
		flash.addAttribute("LISTASERVICIOS", servicios);
		return "index";
	}
	
	//VISTA ADMINISTRADOR
	
	@RequestMapping("/verCrudClientes")
	public String verCliente() {
		return "crudClientes";
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
