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
			
			System.out.print("/nIngrese la opción a realizar: ");
			String entrada = input.nextLine();
					
			try {
				option = Integer.parseInt(entrada);
			}catch(Exception e) {
				System.out.println("La entrada no tiene el formato correcto.");
				option = -1;
			}
			
			switch(option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
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
		
		System.out.print("Introduce el fichero de origen: ");
		origin = input.nextLine();
		
	}
}
