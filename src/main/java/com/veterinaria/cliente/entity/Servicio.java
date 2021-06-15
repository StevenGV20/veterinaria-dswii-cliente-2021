package com.veterinaria.cliente.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
	/*@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idservicio")*/
	private int idservicio;
	private String nombre;
	private double precio;
	private String descripcion;
	private String horario;
	//private String fecha;
	private String foto;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")*/
	private Categoria idcategoria;
	
}
