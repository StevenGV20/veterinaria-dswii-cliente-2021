package com.veterinaria.cliente.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.veterinaria.cliente.entity.Categoria;

@Controller
public class ComboController {

	private String REST_CATEGORIAS="http://localhost:8090/combo/categoria";
	
	@RequestMapping("/listaCategorias")
	@ResponseBody
	public Map<String, Object> listaCategorias(ModelMap flash) {
		Map<String, Object> map= new HashMap<String, Object>();
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Categoria[]> response=rt.getForEntity(REST_CATEGORIAS, Categoria[].class);
		Categoria[] categorias= response.getBody();
		map.put("categorias", categorias);
		return map;
	}
	
}
