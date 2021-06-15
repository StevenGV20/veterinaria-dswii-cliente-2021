package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especie {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idespecie")*/
	private int idespecie;
	private String nombre;
	

}
