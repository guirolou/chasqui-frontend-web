package com.ar.unq.chasqui.few.core.entity;

public class ProductoPedido {

	private Integer id;
	private Double precio;
	private String nombreProducto;
	private String nombreVariante;
	private Integer cantidad;
	
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getNombreVariante() {
		return nombreVariante;
	}
	public void setNombreVariante(String nombreVariante) {
		this.nombreVariante = nombreVariante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
