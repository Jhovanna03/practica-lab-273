package TCP;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {
	Socket sCliente;
	Scanner entrada;
	PrintStream salida;
	String host;
	int puerto;
	String mensajeSolicitud = "";
	String mensajeRespuesta= "";
	private Scanner lectura;
	
	public ClienteTCP(String h,int p) {
		host = h;
		puerto = p;
	}
	public void Cjuego(){
		try {
			sCliente = new Socket(host,puerto);
			
			////////////////ACA RECIBIREMOS EL MENSAJE DE BIENVENIDA DEL SERVIDOR//////////
			Scanner mensajeb = new Scanner(sCliente.getInputStream());
			System.out.println(mensajeb.nextLine());
			///////////////////////////////////////////////////////////////////////
			
			PrintStream numero1 = new PrintStream(sCliente.getOutputStream());  
			//PrintStream numero2 = new PrintStream(sCliente.getOutputStream()); 
			
			Scanner entrada = new Scanner(sCliente.getInputStream());
			
			
			lectura = new Scanner(System.in);
			System.out.println("piedra papel o tijera");
			System.out.println("***********menu*************");
			System.out.println("-opcion 1");
			System.out.println("-opcion 2");
			System.out.println("-opcion 3");
			System.out.println("salir");
			
			System.out.print("elija una opcion :");
			String u =  lectura.nextLine();
			numero1.println(u); //Se envia el primer numero al servidor
			
			
			//////Aca imprimimos la respuesta del servidor
			System.out.println(entrada.nextLine());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}
	}
	
	public void finalizar(){
		try {
			salida.close();
			entrada.close();
			sCliente.close();
			System.out.println("conexion finalizada");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
