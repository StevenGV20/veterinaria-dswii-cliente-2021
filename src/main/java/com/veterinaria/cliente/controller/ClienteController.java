package com.veterinaria.cliente.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Usuario;
/*
import com.veterinaria.cliente.entity.soap.Cliente;
import com.veterinaria.cliente.service.soap.ClienteService;
import com.veterinaria.cliente.service.soap.ClienteServicePortType;
*/
@Controller
@RequestMapping(value ="/cliente")
public class ClienteController {
/*
	private ClienteService service;
	
	public ClienteController() {
		service=new ClienteService();
	}
	
	@RequestMapping(value = "/listaClientes")
	public @ResponseBody Map<String, Object> listaClientes(){
		Map<String, Object> map = new HashMap<String,Object>();
		List<Cliente> lista=null;
		try {
			ClienteServicePortType soap=service.getClienteServiceHttpSoap11Endpoint();
			lista=soap.listaClientes();
			map.put("clientes", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}*/
	
	
	
	//CON SERVICIOS RES
	private String REST_CLIENTE="http://localhost:8090/cliente/";
	
	@RequestMapping(value = "/listaCliente")
	public @ResponseBody Map<String, Object> listaCategorias(){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			//RestTemplate rt=new RestTemplate();
			//ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
			Usuario[] lista=listaCliente();
			map.put("clientes", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	Usuario[] listaCliente() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Usuario[]> response=rt.getForEntity(REST_CLIENTE+"lista", Usuario[].class);
		return response.getBody();
	}
	
	
	
}
