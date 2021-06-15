package com.veterinaria.cliente.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedidoUsuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@EmbeddedId
	private DetallePedidoUsuarioPK detallePK;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne
	//@JoinColumn(name = "idpedido",nullable = false, insertable = false, updatable = false)
	private Pedido pedido;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne
	//@JoinColumn(name = "idusuario",nullable = false, insertable = false, updatable = false)
	private Usuario usuario;
	
	private String estado;
	
	@Timestamp(value = "yyyy-MM-dd HH:mm:ss")
	private Date fechaModificacion = new Date();
}
