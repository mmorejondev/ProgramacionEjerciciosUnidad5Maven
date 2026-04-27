

import java.io.Serializable;

public class Tarea implements Serializable{

	String id;
	String descripcion;
	boolean completada;
	
	public Tarea(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
		this.completada=false;
	}
	
	public Tarea() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", descripcion=" + descripcion + ", completada=" + completada + "]";
	}

	

}
