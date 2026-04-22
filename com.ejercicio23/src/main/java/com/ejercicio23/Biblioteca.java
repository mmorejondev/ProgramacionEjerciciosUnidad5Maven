package com.ejercicio23;

import java.util.List;

public class Biblioteca {

	String nombre;
	String ciudad;
	List<Libro> libros;
	
	public Biblioteca(String nombre, String ciudad, List<Libro> libros) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.libros = libros;
	}
	
	public Biblioteca() {}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		String resultado="";
		
		resultado = "Biblioteca nombre=" + nombre + ", ciudad=" + ciudad + "\n";
		for (Libro l : this.libros)
			resultado = resultado + "\t" + l.toString() + "\n";
	
		return resultado;
	}
	
	
	
	
}
