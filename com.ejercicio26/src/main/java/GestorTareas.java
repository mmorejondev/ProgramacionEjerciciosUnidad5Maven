import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class GestorTareas {

	Map <String, Tarea> tareas;
	Scanner teclado = new Scanner(System.in);
	
	public GestorTareas() {
		
		this.tareas = new HashMap<>();
	}
	
public void anadirTarea() {
		/*Cargamos las tareas desde el JSON con Jackson*/
		ObjectMapper mapeador = new ObjectMapper();
		 
		File archivoTareas = new File("tareas.json");
		try {
			this.tareas = mapeador.readValue(archivoTareas, new TypeReference<Map<String, Tarea>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		System.out.println("Introduzca ID: ");
		String nuevoId=teclado.nextLine();
		System.out.println("Introduzca descripción: ");
		String descripcion=teclado.nextLine();
		Tarea nuevaTarea = new Tarea(nuevoId,descripcion);
		
		/*Añadimos la tarea al mapa*/
		this.tareas.put(nuevoId,nuevaTarea);
		
		/*Escribimos el mapa en el JSON*/
		try {
			mapeador.writeValue(archivoTareas, this.tareas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
}

	public void listarTareas() {
		
		ObjectMapper mapeador = new ObjectMapper();
		
		File archivoTareas = new File("tareas.json");
		try {
			this.tareas = mapeador.readValue(archivoTareas, new TypeReference<Map<String, Tarea>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String idTarea: this.tareas.keySet()) {
			Tarea t = this.tareas.get(idTarea);
			System.out.println(t.toString());
			
		}
		
	}

	public void marcarTareaCompletada() {

ObjectMapper mapeador = new ObjectMapper();
		
		File archivoTareas = new File("tareas.json");
		try {
			this.tareas = mapeador.readValue(archivoTareas, new TypeReference<Map<String, Tarea>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Introduzca ID de tarea a completar: ");
		String nuevoId=teclado.nextLine();
		
		/*Actualizamos la tarea a completada*/
		this.tareas.get(nuevoId).setCompletada(true);
		
		
		/*Escribimos el mapa en el JSON*/
		try {
			mapeador.writeValue(archivoTareas, this.tareas);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
	
}
