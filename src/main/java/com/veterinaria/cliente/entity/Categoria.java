package com.veterinaria.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
	/*@Id
	@GeneratedValue
	@Column(name="idcategoria")*/
	private int idcategoria;
	private String nombre;
}
