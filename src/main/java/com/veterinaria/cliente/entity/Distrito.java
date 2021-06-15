package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Distrito {
/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddistrito")*/
	private int iddistrito;
	private String nombre;
	
}
