package com.ar.unq.chasqui.few.core.dto.apiary;

import java.io.Serializable;
import java.util.List;

import com.ar.unq.chasqui.few.core.dto.ProductoDto;

public class PaginaProductoDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductoDto> productos;
	private Integer pagina;
	private Integer paginasTotal;
	private Integer cantItems;




	public PaginaProductoDto(List<ProductoDto> productos, Integer paginaActual, Integer paginasTotal,
			Integer itemsTotal) {
		super();
		this.productos = productos;
		this.pagina = paginaActual;
		this.paginasTotal = paginasTotal;
		this.cantItems = itemsTotal;
	}





	public List<ProductoDto> getProductos() {
		return productos;
	}





	public void setProductos(List<ProductoDto> productos) {
		this.productos = productos;
	}





	public Integer getPagina() {
		return pagina;
	}





	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}





	public Integer getPaginasTotal() {
		return paginasTotal;
	}





	public void setPaginasTotal(Integer paginasTotal) {
		this.paginasTotal = paginasTotal;
	}





	public Integer getCantItems() {
		return cantItems;
	}





	public void setCantItems(Integer cantItems) {
		this.cantItems = cantItems;
	}


}
