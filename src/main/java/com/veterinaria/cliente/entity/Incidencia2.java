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
public class Incidencia2 {
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idincidencia")*/
	private int idincidencia;
	private String nombre;
	private String regIncidencia;	
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHistorial;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idrol")
	private Rol idrol;

}
