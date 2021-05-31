package com.veterinaria.cliente.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idespecie")
	private int idespecie;
	private String nombre;
	

}
