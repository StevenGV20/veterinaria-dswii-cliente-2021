package com.veterinaria.cliente.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")*/
	private int idpedido;
	//private String estado;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Timestamp(value = "yyyy-MM-dd HH:mm:ss")
	//@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaRegistro;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idcliente")
	private Usuario cliente;
	/*
	@OneToMany(fetch =FetchType.LAZY, mappedBy = "pedido" )
	private List<DetallePedido> detalle;*/
}
