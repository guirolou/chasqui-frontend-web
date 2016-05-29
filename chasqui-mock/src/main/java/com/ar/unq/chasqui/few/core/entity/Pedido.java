package com.ar.unq.chasqui.few.core.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;

public class Pedido {
	
	private Integer id;
	private Integer idVendedor;
	private String estado;
	private Cliente usuarioCreador;
	private Boolean alterable;
	private DateTime fechaCreacion;
	private Direccion direccionEntrega;
	private Double montoMinimo;
	private Double montoActual;
	private List<UsuarioParticipante> usuariosParticipantes;
	
	//GETs & SETs
	
	public Pedido(int i, String string, Date date, Double j, Double k, String estadoPedidoAbierto,Boolean alterable) {
		id=i;
		Cliente c = new Cliente();
		c.setEmail(string);
		usuarioCreador = c;
		fechaCreacion = new DateTime(date.getTime());
		montoMinimo = j;
		montoActual = k;
		estado = estadoPedidoAbierto;
		this.alterable = alterable;
		this.usuariosParticipantes = new ArrayList<UsuarioParticipante>();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Cliente getUsuarioCreador() {
		return usuarioCreador;
	}
	
	public void setUsuarioCreador(Cliente usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
	
	public DateTime getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(DateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Direccion getDireccionEntrega() {
		return direccionEntrega;
	}
	
	public void setDireccionEntrega(Direccion direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	
	
	
	public Double getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(Double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public Double getMontoActual() {
		return montoActual;
	}

	public void setMontoActual(Double montoActual) {
		this.montoActual = montoActual;
	}

	public List<UsuarioParticipante> getUsuariosParticipantes() {
		return usuariosParticipantes;
	}
	
	public void setUsuariosParticipantes(List<UsuarioParticipante> usuariosParticipantes) {
		this.usuariosParticipantes = usuariosParticipantes;
	}
	

	public Integer getIdVendedor() {
		return idVendedor;
	}
	
	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}
	
	
	
	public Boolean getAlterable() {
		return alterable;
	}
	
	public void setAlterable(Boolean alterable) {
		this.alterable = alterable;
	}
	
	
	
	//METHODS 



	public void agregarProducto(ProductoPedido p,String usuario){
		for(UsuarioParticipante u : this.getUsuariosParticipantes()){
			if(u.getUserName().equals(usuario)){
				u.getProductosEnPedido().add(p);
				return;
			}
		}
		
		UsuarioParticipante us = new UsuarioParticipante(usuario);
		us.getProductosEnPedido().add(p);
		this.usuariosParticipantes.add(us);
	}


	public void editarPedido () {
		//TODO
	}

//	public void confirmarte() {
//		if(this.getEstado().equals(Constantes.ESTADO_PEDIDO_CONFIRMADO) && alterable ){
//			this.estado = Constantes.ESTADO_PEDIDO_ENTREGADO;
//		}
//		this.alterable=false;
//		
//	}
	
	
	public HashMap<String,ProductoPedido>ordernarByUsuario(){
		HashMap<String,ProductoPedido>resultado = new HashMap<String,ProductoPedido>();
		for(UsuarioParticipante u : this.usuariosParticipantes){
			for(ProductoPedido p : u.getProductosEnPedido()){
				resultado.put(u.getUserName(), p);				
			}
		}
		return resultado;
	}

	public void agregarUsuarioParticipante(String string) {
		UsuarioParticipante u = new UsuarioParticipante(string);
		u.setUserName(string);
		this.usuariosParticipantes.add(u);
		
	}


}
