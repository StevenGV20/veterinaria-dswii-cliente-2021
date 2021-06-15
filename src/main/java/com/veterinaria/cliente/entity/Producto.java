package com.veterinaria.cliente.entity;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	/*@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idproducto")*/
	private int idproducto;
	private String nombre;
	@NumberFormat(pattern = "##.##")
	private double precio;
	private int stock;
	private String marca;
	private String descripcionSimple;
	private String descripcionHTML;
	private String foto1;
	private String foto2;
	private String foto3;
	
	
	 
	//private Categoria idcategoria;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idcategoria")
	private Categoria idcategoria;

	/*
	public double getPrecio() {
		DecimalFormat df=new DecimalFormat("####.##");
		return Double.parseDouble(df.format(precio));
	}*/
}
