package com.veterinaria.cliente.controller;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.veterinaria.cliente.entity.DetallePedido;
import com.veterinaria.cliente.entity.DetallePedidoPK;
import com.veterinaria.cliente.entity.Pedido;
import com.veterinaria.cliente.entity.Seleccion;
import com.veterinaria.cliente.entity.Usuario;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	private String REST_PEDIDOS="http://localhost:8090/pedido/";
	
	@RequestMapping("/procesarCarrito")
	@ResponseBody
	public Map<String, Object> procesarCarrito(String carrito,HttpSession session)  {
		
		System.out.println(carrito);
		String producto = carrito;
	    Gson gson = new Gson();
	    Type listaProducto = new  TypeToken<List<Seleccion>>() {}.getType();
	    List<Seleccion> detalleJson = gson.fromJson(producto, listaProducto);
	    System.out.println(detalleJson.get(0));
	    System.out.println(detalleJson.get(0).getCantidad());
	    System.out.println(detalleJson.get(0).getPrecioTotal());
	   
	    List<DetallePedido> detalle=new ArrayList<DetallePedido>();
	    double imp=0,des=0,igv=0,mon=0;
	    for (Seleccion det : detalleJson) {
			DetallePedidoPK pk=new DetallePedidoPK();
			pk.setIdproducto(det.getIdproducto());
			
			DetallePedido dp=new DetallePedido();
			dp.setDetallePK(pk);
			dp.setCantidad(det.getCantidad());
			dp.setPrecioTotal(det.getPrecioTotal());
			imp+=det.getPrecioTotal();
			
			detalle.add(dp);
		}
	    
	    System.out.println(imp);
		if(imp>500)
			des=0.05*imp;
		igv=imp*0.18;
		mon=imp+igv-des;
		System.out.println("IM:"+imp+"I:"+igv+"D:"+des+"M:"+mon);
		
		detalle.get(detalle.size()-1).setImporte(imp);
		detalle.get(detalle.size()-1).setDescuento(des);
		detalle.get(detalle.size()-1).setIgv(igv);
		detalle.get(detalle.size()-1).setMontoTotal(mon);
		
		System.out.println("ESTA BIEN HASTA AQUI");
		Seleccion sel=new Seleccion();
		sel.setDetalle(detalle);
		Usuario user =((Usuario) session.getAttribute("objUsuario"));
		sel.setIdcliente(user.getIdusuario());
		RestTemplate rt=new RestTemplate();
		//Se transforma en json
		Gson gson2=new Gson();
		String dataJson = gson2.toJson(sel);
		//
		HttpHeaders header=new HttpHeaders();
		MediaType mediaType=new MediaType("application","json",StandardCharsets.UTF_8);
		header.setContentType(mediaType);
		HttpEntity<String> requests=new HttpEntity<String>(dataJson.toString(),header);
		ResponseEntity<Pedido> objIns= rt.postForEntity(REST_PEDIDOS+"procesarCarrito", requests, Pedido.class);
		
	    //Pedido pedido=new Pedido();
	    //pedido.setCliente((Usuario) session.getAttribute("objUsuario"));
		
	   // pedido.setEstado("PENDIENTE");
	    //pedido.setDetalle(detalle);
	    
		
		
	    //String salida="-1";
	    Map<String, Object> salida = new HashMap<String, Object>();
	    if(objIns.getBody()!=null) {
	    	salida.put("mensaje", "Se registro correctamente el pedido con N° "+objIns.getBody().getIdpedido());
	    }
	    
		return salida;
	}
	
}

