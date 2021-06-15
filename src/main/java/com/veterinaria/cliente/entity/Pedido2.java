package com.veterinaria.cliente.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "pedido2")
public class Pedido2 {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpedido")*/
	private int idpedido;
	private String nombre;
	private String regPedido;	
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPedido;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idrol")
	private Rol idrol;

}
