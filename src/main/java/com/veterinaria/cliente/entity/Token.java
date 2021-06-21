package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Token {
	
	private String access_token;
	private String token_type;
	private String refresh_token;
	private int expires_in;
	private String scope;
	private String jti;
	
///DATOS DEL USUAROP LOGUEADO
	private int idusuario;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private String telefono;
	private String correo;
	private String password;
	private String sexo;
	private int idrol;

//---DATOS PARA EL LOGUEO
	private String username;
	private String grant_type;
	
	public String getJti() {
		return "JSESSIONID="+jti;
	}
	
	
	
}
