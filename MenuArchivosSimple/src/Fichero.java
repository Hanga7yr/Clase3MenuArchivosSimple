import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class Fichero {

	public Fichero () {}

	public static ArrayList<String> LeerFichero(String ruta){
		
		ArrayList<String> salida  = new ArrayList<>();
					
		try(BufferedReader fbr = new BufferedReader(new FileReader(ruta))) {
			String linea = "";
			
			while(linea != null)
				if((linea = fbr.readLine()) == null)		;
				else										salida.add(linea);					
			
		}catch(FileNotFoundException e ) {
			System.out.println("No existe el fichero");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return salida; 
	}
	
	public static boolean EscribirFichero(ArrayList<String> datos, String ruta) {
		
		boolean  salida = true;
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(new File(ruta)));
			
			for (String linea : datos)
				out.write(linea+"\n");
			
			out.close();
		} catch (UnsupportedEncodingException | FileNotFoundException ex2) {
			System.out.println("Mensaje error 2: " + ex2.getMessage());
			
			salida = false ;
		} catch (IOException ex) {
			System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
			
			salida = false ; 
		}
		return salida ; 
	}	
	
	
	public static boolean CopiarFichero (String origen, String destino) {
		
		boolean salida = false ; 
		
    	File origin = new File(origen);
        File destination = new File(destino);
	      
        if (origin.exists() && origin.isFile()) {
    		try {
                InputStream in = new FileInputStream(origin);
                OutputStream out = new FileOutputStream(destination);
                
                byte[] buf = new byte[1024];
                int len;
                
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                
                in.close();
                out.close();
                
                destination.createNewFile();
                
                salida = true ;
            } catch (IOException ioe) {
            	ioe.printStackTrace();
                salida = false ;
            }
        } else {
        	System.out.println("El fichero origen no existe.");
            salida = false ;
        }
        
        return salida;
	}
	public static boolean CrearFichero (String ruta) {
		boolean salida = false ;
		
		File fichero = new File(ruta);

	    try {
	    	if (fichero.createNewFile()) {
	    		System.out.println("El fichero se ha creado correctamente");
	    	  	salida = true;
	    	}else {
	    		System.out.println("No ha podido ser creado el fichero");
	    		salida = false;
    		}
    	} catch (IOException ioe) {
    		ioe.printStackTrace();
    	}
	
		return salida;
	}
	
	public static boolean EliminarFichero (String ruta) {
		boolean salida = false ;
		
		File fichero = new File(ruta);
  	
	  	if (fichero.isFile() && fichero.delete()) {
	  		System.out.println("El fichero ha sido borrado satisfactoriamente");
	  		salida = true; 
	  	}else{
	  		System.out.println("El fichero no puede ser borrado");
		  	salida = false; 
  		}
		return salida;
	}
}
