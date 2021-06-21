package com.veterinaria.cliente.controller;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.veterinaria.cliente.entity.Opcion;
import com.veterinaria.cliente.entity.Token;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private String REST_USUARIO="http://localhost:8090/usuario/";
	
	@RequestMapping("/failureLogin")
	public String failureLogin(HttpSession session) {
		session.setAttribute("MENSAJE", "El usuario no existe");
		return "login";
	}
	
	@RequestMapping("/token")
	@ResponseBody
	public String inicioLogin(String token, String opcion,HttpSession session) {
		
		System.out.println("TOKEN"+token);
		//leer token
		Gson gson = new Gson();
	    Type objToken = new  TypeToken<Token>() {}.getType();
	    Token tokenJson = gson.fromJson(token, objToken);
	    System.out.println(tokenJson.getIdusuario());
		
	    //Leer Opcion
	    Gson gson2 = new Gson();
	    Type objOpcion = new  TypeToken<List<Opcion>>() {}.getType();
	    List<Opcion> opciones = gson2.fromJson(opcion, objOpcion);
	    
	    
	    session.setAttribute("objUsuario", tokenJson);
		session.setAttribute("objMenus", opciones);
	    
		return "login";
	}
	
	
	@RequestMapping("/login")
	public String iniciarSesion(@RequestParam("username") String user,
			@RequestParam("password") String psw,@RequestParam("grant_type") String gt, HttpSession session){
		//Map<String, Object> map=new HashMap<String, Object>();
		try {
			System.out.println("INICIO");
			RestTemplate rt=new RestTemplate();
			//Se transforma en json
			Gson gson=new Gson();
			Token bean=new Token();
			bean.setUsername(user);
			bean.setPassword(psw);
			bean.setGrant_type(gt);
			String dataJson = gson.toJson(bean);
			//
			System.out.println(bean.getUsername());
			HttpHeaders header=new HttpHeaders();
			MediaType mediaType=new MediaType("application","json",StandardCharsets.UTF_8);
			header.setContentType(mediaType);
			header.setBasicAuth("clientedsw","dsw");
			HttpEntity<String> requests=new HttpEntity<String>(dataJson.toString(),header);
			//
			String url="http://localhost:8090/oauth/token?username="+bean.getUsername()+"&password="+bean.getPassword()+"&grant_type="+bean.getGrant_type()+"";
			System.out.println("LO CONVIRTIO EN JSON");
			System.out.println(requests);
			ResponseEntity<Token> response=rt.exchange(url, HttpMethod.POST,requests, Token.class);

			System.out.println("LEYO AL USUARIO");
			//UsuarioAuth usuario=response.getBody();
			Token token=response.getBody();
			if (token == null) {
				System.out.println("EL USUARIO NO EXISTE");
				session.setAttribute("MENSAJE", "El usuario no existe");
				return "redirect:/verLogin";
			} else {

				System.out.println("ENTRO A LA LISTA OPCION");
				RestTemplate rte=new RestTemplate();
				Gson gsont=new Gson();
				String jsontoken = gsont.toJson(token);
				System.out.println(jsontoken);
				HttpHeaders headerRp=new HttpHeaders();
				//MediaType mediaTypeRp=new MediaType("application","json");
				headerRp.setContentType(MediaType.APPLICATION_JSON);
				//headerRp.setBearerAuth(token.getAccess_token());
				System.out.println("TOKEN: "+token.getAccess_token()); 
				headerRp.add("Authorization","Bearer "+ token.getAccess_token());
				headerRp.add("Cookie", token.getJti());
				
				//HttpEntity<String> entity = new HttpEntity<String>(requestJson,headerRp);
				
				//HttpEntity<String> requestsRp=new HttpEntity<String>(jsontoken.toString(),headerRp);
				//System.out.println(requestsRp.getHeaders());
				
				
				String theUrl = REST_USUARIO+"traerEnlaces/"+token.getIdusuario();
			    RestTemplate restTemplate = new RestTemplate();
			    
			  //  HttpHeaders headers = createHttpHeaders("fred","1234");
		        HttpEntity<String> entity1 = new HttpEntity<String>("parameters", headerRp);
		        System.out.println(entity1.getHeaders());
		        ResponseEntity<Opcion[]> opciones = restTemplate.exchange(theUrl, HttpMethod.GET, entity1, Opcion[].class);
		        
				//ResponseEntity<?> opciones=rte.getForEntity(,Opcion.class,requestsRp);
				Opcion[] menus = (Opcion[]) opciones.getBody();

				System.out.println("LEYO LA LISTA OPCION");
				
				session.setAttribute("objUsuario", token);
				session.setAttribute("objMenus", menus);

				System.out.println("CORRECTO");
				return "redirect:/";
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/verLogin";
		}
		
	}
	/*
	private HttpHeaders createHttpHeaders(String user, String password)
	{
	    //String notEncoded = user + ":" + password;
	    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", encodedAuth);
	    return headers;
	}*/
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		//session.invalidate();
		session.setAttribute("objUsuario",null);
		session.setAttribute("objMenus", null);
		
		response.setHeader("Cache-control", "no-cache");
		response.setHeader("Expires", "0");
		response.setHeader("Pragma", "no-cache");

		request.setAttribute("mensaje", "El usuario saliÃ³ de sesiÃ³n");
		return "redirect:/verLogin";

	}
}
