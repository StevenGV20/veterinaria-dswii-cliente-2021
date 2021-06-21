package com.veterinaria.cliente.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageProductos {
	private List<Producto> content;
	private boolean last;
	private int totalElements;
	private int totalPages;
	private boolean first;
	private int numberOfElements;
	private int size;
	private int number;
}
