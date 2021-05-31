package com.veterinaria.cliente.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seleccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpedido;
	private int idproducto;
	private int cantidad;
	private double precio;
	private double precioTotal;
	private double importe;
	private double descuento;
	private double igv;
	private double montoTotal;
}
