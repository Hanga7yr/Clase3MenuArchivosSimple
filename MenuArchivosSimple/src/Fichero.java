import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class Fichero {

	public Fichero () {}
	

	public ArrayList<String> LeerFichero ( String ruta ) throws IOException {
		
		ArrayList<String> salida  = new ArrayList<>();
					
		try(BufferedReader fbr = new BufferedReader(new FileReader(ruta)) ){
		
			String linea = "Inicio";
			
			
			while(linea != null){
				
				linea = fbr.readLine();
				if (linea == null) {
					System.out.println("Fichero cargado;");
					
				}else {
					
					salida.add(linea);					
				}		
				
			}
			
		}catch(FileNotFoundException e ) {
			System.out.println("no existe el fichero");
		}
		
		
		return  salida ; 
	}
	
	public boolean EscribirFichero (ArrayList<String> datos , String ruta ) {
		
		boolean  salida = true ; 
		
	
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta), "UTF-8"));
			
			
			for (String linea : datos) {
				try {
					
					out.write(linea+"\n");
					out.write("moradota moradota la polla moradota");
				} catch (IOException ex) {
					
					salida = false ; 
					System.out.println("Mensaje excepcion escritura: " + ex.getMessage());
				}
			}

		} catch (UnsupportedEncodingException | FileNotFoundException ex2) {
			
			salida = false ;
			System.out.println("Mensaje error 2: " + ex2.getMessage());
			
		} finally {
			try {
				System.out.println("fichero , escrito ");
				out.close();
				
			} catch (IOException ex3) {
				System.out.println("Mensaje error cierre fichero: " + ex3.getMessage());
			}
		}
			
		
		return salida ; 
	}	
	
	
	public boolean CopiarFichero ( String origen , String destino) {
		
		boolean salida = false ; 
		
	        File origin = new File(origen);
	        File destination = new File(destino);
	        
	      System.out.println(destination.exists());
	      System.out.println(origin.exists());
	      
	        if (origin.exists() ) {
	            try {
	                InputStream in = new FileInputStream(origin);
	                OutputStream out = new FileOutputStream(destination);
	                // We use a buffer for the copy (Usamos un buffer para la copia).
	                byte[] buf = new byte[1024];
	                int len;
	                while ((len = in.read(buf)) > 0) {
	                    out.write(buf, 0, len);
	                }
	                in.close();
	                out.close();
	                return salida = true ;
	            } catch (IOException ioe) {
	            	
	                ioe.printStackTrace();
	                return salida = false ;
	            }
	        } else {
	            return salida = false ;
	        }
		
	}
	public boolean CrearFichero (String ruta ) {
		boolean salida = false ;
		
		File fichero = new File (ruta);

	    try {
	    	  
	    	  if (fichero.createNewFile()) {
	    		  System.out.println("El fichero se ha creado correctamente");
	    	  	salida = true ;
	    	  }else {
	    		  System.out.println("No ha podido ser creado el fichero");
	    		  salida = false ;
	    	  }
    
	    	} catch (IOException ioe) {
	    	  ioe.printStackTrace();
	    	}
	
		return salida = false ;
	}
	
	public boolean EliminarFichero (String ruta ) {
		boolean salida = false ;
		
		File fichero = new File (ruta);
  	
  	if (fichero.delete()) {
  		System.out.println("El fichero ha sido borrado satisfactoriamente");
  		salida = true ; 
  	}else 
  		{
  			  System.out.println("El fichero no puede ser borrado");
  			  salida = false ; 
  		}
		return salida = false ;
	}
	
	
 	
}
