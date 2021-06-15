package com.veterinaria.cliente.controller;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.veterinaria.cliente.entity.Producto;
import com.veterinaria.cliente.entity.Servicio;
import com.veterinaria.cliente.util.Constantes;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	private String REST_SERVICIOS="http://localhost:8090/servicio/";
	//private String REST_CATEGORIAS="http://localhost:8090/combo/categoria";
	
	
	

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
	
	@RequestMapping(value = "/listaServiciosByName")
	@ResponseBody
	public Servicio[] listaServiciosByName(String nombre){
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"listaServiciosByName/"+nombre, Servicio[].class);
		Servicio[] lista=response.getBody();
		return lista;
	}
	@RequestMapping(value = "/listaServiciosByNameAZ")
	@ResponseBody
	public Servicio[] listaServiciosByNameAZ(){
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"listaServiciosByNameAZ", Servicio[].class);
		Servicio[] lista=response.getBody();
		return lista;
	}
	@RequestMapping(value = "/listaServiciosByNameZA")
	@ResponseBody
	public Servicio[] listaServiciosByNameZA(){
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"listaServiciosByNameZA", Servicio[].class);
		Servicio[] lista=response.getBody();
		return lista;
	}
	@RequestMapping(value = "/listaServiciosByPrecioMenor")
	@ResponseBody
	public Servicio[] listaServiciosByPrecioMenor(){
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"listaServiciosByPrecioMenor", Servicio[].class);
		Servicio[] lista=response.getBody();
		return lista;
	}
	
	@RequestMapping(value = "/listaServiciosByPrecioMayor")
	@ResponseBody
	public Servicio[] listaServiciosByPrecioMayor(){
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Servicio[]> response=rt.getForEntity(REST_SERVICIOS+"listaServiciosByPrecioMayor", Servicio[].class);
		Servicio[] lista=response.getBody();
		return lista;
	}
	
	
	
	@RequestMapping(value = "/listaServicios")
	public @ResponseBody Map<String, Object> listaProductos(){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			Servicio[] lista=listaServicios();
			map.put("servicios", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/buscaServicioById")
	public @ResponseBody Map<String, Object> buscaServcioXCodigo(int cod){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			//RestTemplate rt=new RestTemplate();
			//ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
			Servicio lista=buscaServicioById(cod);
			map.put("servicio", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	Producto[] listaProducto() {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Producto[]> response=rt.getForEntity(REST_SERVICIOS+"lista", Producto[].class);
		return response.getBody();
	}
	
	@RequestMapping(value="/registrarServicio",method = RequestMethod.POST)
	public String registra(Servicio obj, RedirectAttributes flash){
		//Map<String, Object> salida=new HashMap<String,Object>();
		//Producto objSalida=null;
		try {
			RestTemplate rt=new RestTemplate();
			//Se transforma en json
			Gson gson=new Gson();
			String dataJson = gson.toJson(obj);
			//
			HttpHeaders header=new HttpHeaders();
			MediaType mediaType=new MediaType("application","json",StandardCharsets.UTF_8);
			header.setContentType(mediaType);
			HttpEntity<String> requests=new HttpEntity<String>(dataJson.toString(),header);
			//pos
			System.out.println("idproducto: "+obj.getIdservicio());
			System.out.println("idproducto: "+obj.getFoto());
			if(obj.getIdservicio()==0)
				rt.postForObject(REST_SERVICIOS+"registra", requests, String.class);
			else
				rt.put(REST_SERVICIOS+"actualiza", requests, String.class);
			
			flash.addFlashAttribute("CORRECTO", Constantes.MENSAJE_REG_EXITOSO);
			
			return "redirect:/verCrudServicios";			 	 
		} catch (Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("ERROR", Constantes.MENSAJE_REG_ERROR);
			return "redirect:/verCrudServicios";
		}
	}
	

	
	@RequestMapping(value = "/eliminaServicio")
	public @ResponseBody Map<String, Object> deleteProducto(@RequestParam("codigo") int cod){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			RestTemplate rt=new RestTemplate();
			rt.delete(REST_SERVICIOS+"elimina/"+cod);
			map.put("mensaje", "Se elimino correctamente el servicio "+cod);
			map.put("lista", listaProducto());
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mensaje","Error al eliminar");
		}
		return map;
	}
	
	
	
}
