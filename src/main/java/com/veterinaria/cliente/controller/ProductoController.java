package com.veterinaria.cliente.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Producto;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	private String REST_PRODUCTOS="http://localhost:8090/producto/";
	private String REST_CATEGORIAS="http://localhost:8090/combo/categoria";
	
	@RequestMapping(value = "/listaProductos")
	public @ResponseBody Map<String, Object> listaProductos(){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			//RestTemplate rt=new RestTemplate();
			//ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
			Producto[] lista=listaProducto();
			map.put("productos", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/listaCategorias")
	public @ResponseBody Map<String, Object> listaCategorias(){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			//RestTemplate rt=new RestTemplate();
			//ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
			Producto[] lista=listaProducto();
			map.put("productos", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	Producto[] listaProducto() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
		return response.getBody();
	}
	
	
}
