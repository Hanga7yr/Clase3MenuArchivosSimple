import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu {
	
	private static Scanner input = new Scanner(System.in);
	public static void showMenu() {
		String[] lineas = new String[] {
			"1. Copiar ficheros",
			"2. Crear un fichero",
			"3. Borrar un fichero",
			"4. Mostrar un fichero",
			"5. Salir"
		};
		
		boolean salir = false;
		
		do {
			int option = -1;
			
			for(String i : lineas)
				System.out.println(i);
			
			System.out.print("\nIngrese la opción a realizar: ");
			String entrada = input.nextLine();
					
			try {
				option = Integer.parseInt(entrada);
			}catch(Exception e) {
				System.out.println("La entrada no tiene el formato correcto.");
				option = -1;
			}
			
			switch(option) {
				case 1:
					copyFiles();
					break;
				case 2:
					createFile();
					break;
				case 3:
					deleteFile();
					break;
				case 4:
					showFile();
					break;
				case 5:
					salir = true;
					break;
				default:
					break;
			}
			
		}while(!salir);
	}
	
	public static void copyFiles() {
		String origin = "";
		String dest = "";
		
		System.out.print("Introduce la ruta del fichero de origen: ");
		origin = input.nextLine();
		
		System.out.print("Introduce la ruta del fichero de destino: ");
		dest = input.nextLine();
		
		if(!Fichero.CopiarFichero(origin, dest))	System.out.println("Error en la copia de los ficheros.");
		else										System.out.println("Se han copiado los ficheros correctamente.");
	}
	
	public static void createFile() {
		String file = "";
		
		System.out.print("Introduce la ruta del fichero a crear: ");
		file = input.nextLine();
		
		if(!Fichero.CrearFichero(file))	System.out.println("Error en la creación del fichero.");
			
	}
	
	public static void deleteFile() {
		String file = "";
		
		System.out.print("Introduce la ruta del fichero a eliminar: ");
		file = input.nextLine();
		
		if(!Fichero.EliminarFichero(file)) {
			System.out.println("Error en el borrado del fichero.");
		}
	}
	
	public static void showFile() {
		String file = "";
		ArrayList<String> content = null;
		
		System.out.print("Introduce la ruta del fichero a leer: ");
		file = input.nextLine();
		
		if((content = Fichero.LeerFichero(file)) == null) {
			System.out.println("Error en la lectura del fichero.");
		}else {
			System.out.println();
			
			for(String i : content)
				System.out.println(i);
			
			System.out.println();
		}
}
}
