package utng.model;

import java.io.Serializable;

public class Acto implements Serializable{
	private String id;
	private String fecha;
	private int codigo;
	private String lugar;
	private String descripcion;
	
	public Acto() {
		this("","",0,"","");
	}

	public Acto(String id, String fecha, int codigo, String lugar, String descripcion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.codigo = codigo;
		this.lugar = lugar;
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Acto [id=" + id + ", fecha=" + fecha + ", codigo=" + codigo + ", lugar=" + lugar + ", descripcion="
				+ descripcion + "]";
	}
	

}
