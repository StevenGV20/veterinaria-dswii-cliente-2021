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
public class DetallePedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	private DetallePedidoPK detallePK;
	
	//@ManyToOne
	//@JoinColumn(name = "idpedido",nullable = false, insertable = false, updatable = false)
	private Pedido pedido;
	
	//@ManyToOne
	//@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;
	
	private int cantidad;
	private double precioTotal;
	private double importe;
	private double descuento;
	private double igv;
	private double montoTotal;
	/*
	public double getImporte() {
		DecimalFormat df=new DecimalFormat();
		Decimal
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	*/
	
	
	
}
