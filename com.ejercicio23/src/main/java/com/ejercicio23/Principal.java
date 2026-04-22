package com.ejercicio23;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ejercicio23.Libro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main(String[] args) {
		
		File archivoBiblioteca = new File("biblioteca.json");
		
		Libro libro1 = new Libro("El Hobbit", "JRR Tolkien", 1950, true);
		Libro libro2 = new Libro("El Señor de los Anillos", "JRR Tolkien", 1951, true);
		Libro libro3 = new Libro("100 años de Soledad", "Gabriel García Márquez", 1975, true);
		
		List<Libro> libros = new ArrayList<>();
		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);
		
		
		Biblioteca b1 = new Biblioteca("Biblioteca Municipal","Sevilla",libros);
		
		ObjectMapper mapeador = new ObjectMapper();
		try {
			mapeador.writeValue(archivoBiblioteca, b1);
		} catch (IOException e) {
			System.out.println("Error comunicando con el archivo.");
		}
		
		try {
			Biblioteca leida = mapeador.readValue(archivoBiblioteca,new TypeReference<Biblioteca>() {});
			System.out.println(leida.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
