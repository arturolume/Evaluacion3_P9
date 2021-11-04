import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.transform.Result;
import java.util.Scanner;

public class Evaluacion3_P9 {
 
	public static void main(String[] args) throws Exception {
		
		int codigo;
		String apellido, nombre, dni, direccion;
		
        Connection conn = null;
     
        String driver   = "com.mysql.cj.jdbc.Driver";
        String db       = "evaluacion3";
        String url      = "jdbc:mysql://localhost:3306/" + db;
        String user     = "root";
        String pass     = "Reyes562";
        System.out.println("Connected to database : " + db);

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected to database : " + db);
            Statement st=conn.createStatement();

            Scanner sc = new Scanner(System.in);

            boolean salir = false;
            while (!salir){
                System.out.println("1- Registrar alumno");
                System.out.println("2- Mostrar alumnos");
                System.out.println("3- Buscar alumno por DNI");
                System.out.println("4- Busqueda personalizada");
                System.out.println("5- Salir");
                System.out.println("Ingrese una de las opciones");
                int opcion = sc.nextInt();
                switch(opcion){
                    case 1:
                    	System.out.println("REGISTRAR ALUMNO");
                        System.out.println("Ingresa el apellido del alumno");
                        apellido = sc.next();
                        System.out.println("Ingresa el nombre del alumno");
                        nombre = sc.next();                  
                        System.out.println("Ingresa el DNI del alumno");
                        dni = sc.next();
                        System.out.println("Ingresa la direccion del alumno");
                        direccion = sc.next();
                        String insercion = "insert into alumnos(codigo, apellidos, nombres, dni, direccion) values("
                        		+ "default, '"+apellido+"','"+nombre+"','"+dni+"', '"+direccion+"')";
                        int result = st.executeUpdate(insercion);

                        System.out.println("\nTerminado\n");
                        break;
                    
                    case 2:
                        System.out.println("MOSTRAR ALUMNOS");
                        
                        ResultSet rs = st.executeQuery("select * from alumnos");
                        
                        while (rs.next()) {
                        	System.out.println("Codigo:" + rs.getString(1)
            				+ "\nApellido: "+rs.getString(2)
            				+"\nNombre: "+rs.getString(3)
            				+"\nDNI: "+rs.getString(4)
            				+"\nDireccion: "+rs.getString(5)+"\n");
                        }
                        System.out.println("\nTerminado\n");
                        break;
                    case 3:
                    	System.out.println("BUSCAR ALUMNO POR DNI");
                    	System.out.println("Ingrese el DNI del alumno a buscar");
                    	dni = sc.next();
                    	ResultSet rs1 = st.executeQuery("select * from alumnos where dni ='"+dni+"'");
                    	if (rs1.next()) {
                    		System.out.println("Codigo:" + rs1.getString(1)
            				+ "\nApellido: "+rs1.getString(2)
            				+"\nNombre: "+rs1.getString(3)
            				+"\nDNI: "+rs1.getString(4)
            				+"\nDireccion: "+rs1.getString(5)+"\n");                   	
                        }
                    	System.out.println("\nTerminado\n");
                    	break;
                    case 4:
                    	System.out.println("BUSQUEDA PERSONALIZADA");
                    	System.out.println("Ingrese por que dato quieres buscar");
                    	System.out.println("1- Codigo");
                        System.out.println("2- Apellido");
                        System.out.println("3- Nombre");
                        System.out.println("4- DNI");
                        System.out.println("Ingrese una de las opciones");
                        int opcion2 = sc.nextInt();
                        switch(opcion2) {
                        case 1:
                        	System.out.println("BUSCAR ALUMNO POR CODIGO");
                        	codigo = sc.nextInt();
                        	ResultSet rs11 = st.executeQuery("select * from alumnos where codigo ="+codigo+"");
                        	if (rs11.next()) {
                        		System.out.println("Codigo:" + rs11.getString(1)
                				+ "\nApellido: "+rs11.getString(2)
                				+"\nNombre: "+rs11.getString(3)
                				+"\nDNI: "+rs11.getString(4)
                				+"\nDireccion: "+rs11.getString(5)+"\n");                   	
                            }
                        	System.out.println("\nTerminado\n");
                        	break;	
                        case 2:
                        	System.out.println("BUSCAR ALUMNO POR APELLIDO");
                        	apellido = sc.next();
                        	ResultSet rs111 = st.executeQuery("select * from alumnos where apellido ='"+apellido+"'");
                        	if (rs111.next()) {
                        		System.out.println("Codigo:" + rs111.getString(1)
                				+ "\nApellido: "+rs111.getString(2)
                				+"\nNombre: "+rs111.getString(3)
                				+"\nDNI: "+rs111.getString(4)
                				+"\nDireccion: "+rs111.getString(5)+"\n");                   	
                            }
                        	System.out.println("\nTerminado\n");
                        	break;
                        case 3:
                        	System.out.println("BUSCAR ALUMNO POR NOMBRE");
                        	nombre = sc.next();
                        	ResultSet rs1111 = st.executeQuery("select * from alumnos where nombre ='"+nombre+"'");
                        	if (rs1111.next()) {
                        		System.out.println("Codigo:" + rs1111.getString(1)
                				+ "\nApellido: "+rs1111.getString(2)
                				+"\nNombre: "+rs1111.getString(3)
                				+"\nDNI: "+rs1111.getString(4)
                				+"\nDireccion: "+rs1111.getString(5)+"\n");                   	
                            }
                        	System.out.println("\nTerminado\n");
                        	break;
                        case 4:
                        	System.out.println("BUSCAR ALUMNO POR DNI");
                        	dni = sc.next();
                        	ResultSet rs11111 = st.executeQuery("select * from alumnos where dni ='"+dni+"'");
                        	if (rs11111.next()) {
                        		System.out.println("Codigo:" + rs11111.getString(1)
                				+ "\nApellido: "+rs11111.getString(2)
                				+"\nNombre: "+rs11111.getString(3)
                				+"\nDNI: "+rs11111.getString(4)
                				+"\nDireccion: "+rs11111.getString(5)+"\n");                   	
                            }
                        	System.out.println("\nTerminado\n");
                        	break;
                        }
                    case 5:
                        salir = true;
                        System.out.println("\nSaliendo del menu\nQue tenga un buen dia.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQLException: "+e.getMessage());
            System.out.println("SQLState: "+e.getSQLState());
            System.out.println("VendorError: "+e.getErrorCode());
        }
    }
}