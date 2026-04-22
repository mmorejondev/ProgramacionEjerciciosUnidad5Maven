package com.ejercicio24;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {

	public static void main (String args []) {
		
		final String RUTA_ARCHIVO="src/main/resources/";
		File archivoPersonas = new File(RUTA_ARCHIVO + "personas.json");
		File archivoPersonasJovenes = new File(RUTA_ARCHIVO + "personas_jovenes.json");
		
		if (archivoPersonas.exists()) {
			System.out.println("El archivo existe. Comenzando proceso...");
			ObjectMapper mapeador = new ObjectMapper();
			try {
				List<Persona> listaPersonas = mapeador.readValue(archivoPersonas, new TypeReference<List<Persona>>() {});
				/*Filtramos personas con edad menor o igual que 30*/
				List<Persona> personasJovenes = new ArrayList<Persona>();
				for (Persona p: listaPersonas) {
					if (p.getEdad()<=30) {
						personasJovenes.add(p);
					}
				}
				
				/*Escribimos la lista filtrada en el archivo de salida*/
				mapeador.writeValue(archivoPersonasJovenes,personasJovenes);
				System.out.println("Archivo creado.");
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
		}else {//En caso de que no exista creamos uno nuevo vacío, pero no es de utilidad en este problema
			try {
				archivoPersonas.createNewFile();
				System.out.println("El archivo no existe. Creando archivo nuevo vacío.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
}
