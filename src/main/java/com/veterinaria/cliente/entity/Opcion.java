package com.veterinaria.cliente.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idopcion;
	private String nombre;
	private String ruta;
	private String estado;
	private String icono;
	
	
}
