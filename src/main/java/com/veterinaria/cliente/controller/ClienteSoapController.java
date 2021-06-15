package com.veterinaria.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente-soap/")
public class ClienteSoapController {

	/*private ClienteService service;
	
	public ClienteSoapController() {
		service=new ClienteService();
	}
	
	@RequestMapping("/")
	public String index() {
		return "producto";
	}
	
	@RequestMapping("/lista")
	@ResponseBody
	public List<Cliente> listAll() {
		List<Cliente> lista=null;
		try {
			ClienteServicePortType soap=service.getClienteServiceHttpSoap11Endpoint();
			lista=soap.listaClientes();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping("/consultaPorPrecios")
	@ResponseBody
	public List<Cliente> consultaPorPrecios(double min,double max) {
		List<Cliente> lista=null;
		try {
			ClienteServicePortType soap=service.getClienteServiceHttpSoap11Endpoint();
			lista=soap.listaClientes();		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	@RequestMapping("/registrarProducto")
	public String registraProducto(Usuario obj,
			RedirectAttributes redirect) {
		try {
			Cliente bean=new Cliente();
			ObjectFactory factory=new ObjectFactory();
			JAXBElement<String> xApe,xNom;
			xNom=factory.createClienteNombre(obj.getNombre());
			xApe=factory.createClienteApellido(obj.getApellido());
			bean.setNombre(xNom);
			bean.setApellido(xApe);
			
			ClienteServicePortType soap=service.getClienteServiceHttpSoap11Endpoint();
			soap.registraCliente(bean);
			redirect.addFlashAttribute("MENSAJE","Producto registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al registrar");
			e.printStackTrace();
		}
		return "redirect:/producto/";
	}
	
	@RequestMapping("/eliminarProducto")
	public String eliminarProducto(@RequestParam("codigo")int cod,RedirectAttributes redirect) {
		try {
			ClienteServicePortType soap=service.getClienteServiceHttpSoap11Endpoint();
			soap.eliminaCliente(cod);
			redirect.addFlashAttribute("MENSAJE","Producto eliminado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al eliminar");
			e.printStackTrace();
		}
		return "redirect:/producto/";
	}
	*/
}
