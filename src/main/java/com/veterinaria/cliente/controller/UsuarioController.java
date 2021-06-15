package com.veterinaria.cliente.controller;

import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.veterinaria.cliente.entity.Opcion;
import com.veterinaria.cliente.entity.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private String REST_USUARIO="http://localhost:8090/usuario/";
	
	@RequestMapping("/failureLogin")
	public String failureLogin(HttpSession session) {
		session.setAttribute("MENSAJE", "El usuario no existe");
		return "login";
	}
	
	@RequestMapping("/login")
	public String iniciarSesion(Usuario bean, HttpSession session){
		//Map<String, Object> map=new HashMap<String, Object>();
		try {
			System.out.println("INICIO");
			RestTemplate rt=new RestTemplate();
			//Se transforma en json
			Gson gson=new Gson();
			String dataJson = gson.toJson(bean);
			//
			HttpHeaders header=new HttpHeaders();
			MediaType mediaType=new MediaType("application","json",StandardCharsets.UTF_8);
			header.setContentType(mediaType);
			HttpEntity<String> requests=new HttpEntity<String>(dataJson.toString(),header);
			//
			System.out.println("LO CONVIRTIO EN JSON");
			ResponseEntity<Usuario> response=rt.postForEntity(REST_USUARIO+"login", requests, Usuario.class);

			System.out.println("LEYO AL USUARIO");
			Usuario usuario=response.getBody();
			if (usuario == null) {
				System.out.println("EL USUARIO NO EXISTE");
				session.setAttribute("MENSAJE", "El usuario no existe");
				return "redirect:/verLogin";
			} else {
				RestTemplate rte=new RestTemplate();
				ResponseEntity<Opcion[]> opciones=rte.getForEntity(REST_USUARIO+"traerEnlaces/"+usuario.getIdusuario(), Opcion[].class);
				Opcion[] menus = opciones.getBody();

				session.setAttribute("objUsuario", usuario);
				session.setAttribute("objMenus", menus);

				System.out.println("CORRECTO");
				return "redirect:/";
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			return "redirect:/failureLogin";
		}
		
	}
	
	
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
