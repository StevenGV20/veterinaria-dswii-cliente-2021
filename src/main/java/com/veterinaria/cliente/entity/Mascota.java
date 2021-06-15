package com.veterinaria.cliente.entity;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.veterinaria.cliente.util.FunctionUtil;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
	/*@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idmascota")*/
	private int idmascota;
	private String nombre;
	private String raza;
	private String edad;
	private String sexo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Timestamp(value = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	
	public String getStrFechaNacFormateada() {
		return FunctionUtil.toFechaString(fechaNacimiento);
	}
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idcliente")
	private Usuario cliente;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "idespecie")
	private Especie idespecie;
}
