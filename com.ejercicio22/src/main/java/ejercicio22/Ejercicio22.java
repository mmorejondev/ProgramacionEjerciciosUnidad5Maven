package ejercicio22;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio22 {

	public static void main(String[] args) {

		Libro libro1 = new Libro("El Hobbit", "JRR Tolkien", 1950, true);
		//Creamos un mapeador de ObjectMapper que es una clase Jackson
		ObjectMapper mapeador = new ObjectMapper();
		File archivoLibros = new File("biblioteca.json");
		try {
			mapeador.writeValue(archivoLibros,libro1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Libro nuevo = mapeador.readValue(archivoLibros, new TypeReference<Libro>() {});
			System.out.println("Libro leido del JSON");
			System.out.println(nuevo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
