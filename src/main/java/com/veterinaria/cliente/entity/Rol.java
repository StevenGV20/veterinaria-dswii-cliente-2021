package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")*/
	private int idrol;
	private String nombre;
	
}
