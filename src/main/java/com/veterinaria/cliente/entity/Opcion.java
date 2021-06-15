package com.veterinaria.cliente.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Opcion {
	private int idopcion;
	private String nombre;
	private String ruta;
	private String estado;
	private String icono;
	
	
}
