import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		GestorTareas gt = new GestorTareas();
		Scanner teclado = new Scanner(System.in);
		int opcion=0;
		
		System.out.println("1.- Añadir Tarea");
		System.out.println("2.- Listar Tareas");
		System.out.println("3.- Marcar Tarea como completada");
		System.out.println("4.- Salir");
		opcion=teclado.nextInt();
		teclado.nextLine();
		
		
		while (opcion!=4) {
			if (opcion==1) {
				gt.anadirTarea();
			}else if (opcion == 2) {
				gt.listarTareas();
			}else if (opcion == 3) {
				gt.marcarTareaCompletada();
			}
		
			System.out.println("1.- Añadir Tarea");
			System.out.println("2.- Listar Tareas");
			System.out.println("3.- Marcar Tarea como completada");
			System.out.println("4.- Salir");
			opcion=teclado.nextInt();
			teclado.nextLine();
			
		}
	}

}
