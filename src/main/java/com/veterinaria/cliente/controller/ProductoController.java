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
import com.veterinaria.cliente.util.Constantes;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	private String REST_PRODUCTOS="http://localhost:8090/producto/";
	//private String REST_CATEGORIAS="http://localhost:8090/combo/categoria";
	

	Producto buscaProductoById(int cod) {
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Producto> response=rt.getForEntity(REST_PRODUCTOS+"buscaProductoById/"+cod, Producto.class);
		return response.getBody();
	}
	
	
	@RequestMapping(value = "/listaProductos")
	public @ResponseBody Map<String, Object> listaProductos(){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			Producto[] lista=listaProducto();
			map.put("productos", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	

	
	
	@RequestMapping(value = "/buscaProductoById")
	public @ResponseBody Map<String, Object> buscaPorductoXCodigo(int cod){
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			//RestTemplate rt=new RestTemplate();
			//ResponseEntity<Producto[]> response=rt.getForEntity(REST_PRODUCTOS+"lista", Producto[].class);
			Producto lista=buscaProductoById(cod);
			map.put("producto", lista);
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
	
	@RequestMapping(value="/registrarProducto",method = RequestMethod.POST)
	public String registra(@RequestParam("files") List<MultipartFile> files, Producto obj, RedirectAttributes flash){
		//Map<String, Object> salida=new HashMap<String,Object>();
		//Producto objSalida=null;
		try {
			
			if(files.size()!=0) {
				//service.saveFotos(files);
				int c=0;
				for(MultipartFile file:files) {
					
					if(!(file.getBytes()==null)) {
						System.out.println("FILE: "+file.getOriginalFilename());
						if(c==0) obj.setFoto1(file.getOriginalFilename());
						else if(c==1)obj.setFoto2(file.getOriginalFilename());
						else if(c==2) obj.setFoto3(file.getOriginalFilename());						
					}else {
						if(c==0) obj.setFoto1("image-not-found.png");
						else if(c==1)obj.setFoto2("image-not-found.png");
						else if(c==2) obj.setFoto3("image-not-found.png");
					}
					System.out.println(c);
					c++;
				}
			}
			
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
			System.out.println("idproducto: "+obj.getIdproducto());
			if(obj.getIdproducto()==0)
				rt.postForObject(REST_PRODUCTOS+"registra", requests, String.class);
			else
				rt.put(REST_PRODUCTOS+"actualiza", requests, String.class);
			flash.addFlashAttribute("CORRECTO", Constantes.MENSAJE_REG_EXITOSO);
			return "redirect:/verCrudProductos";			 	 
		} catch (Exception e) {
			e.printStackTrace();
			flash.addFlashAttribute("ERROR", Constantes.MENSAJE_REG_ERROR);
			return "redirect:/verCrudProductos";
		}
	}
	

	
	@RequestMapping(value = "/deleteProducto")
	public @ResponseBody Map<String, Object> deleteProducto(@RequestParam("codigo") int cod){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			RestTemplate rt=new RestTemplate();
			rt.delete(REST_PRODUCTOS+"elimina/"+cod);
			map.put("mensaje", "Se elimino correctamente el producto "+cod);
			map.put("lista", listaProducto());
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mensaje","Error al eliminar");
		}
		return map;
	}
	
	
	
	
}
