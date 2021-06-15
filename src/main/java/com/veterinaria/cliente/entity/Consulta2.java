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
public class Consulta2 {
/*	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idconsulta")*/
	private int idconsulta;
	private String nombre;
	private String regConsulta;	
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date fechaConsulta;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idrol")
	private Rol idrol;

}
