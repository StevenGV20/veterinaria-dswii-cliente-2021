package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario{
	/**
	 * 
	 */
	private int idusuario;
	private String nombre;
	private String apellido;
	private String direccion;
	private String dni;
	private String telefono;
	private String correo;
	private String password;
	private String sexo;
	
	/*@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddistrito")*/
	private Distrito iddistrito;
	/*
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrol")*/
	private Rol idrol;
	

}
