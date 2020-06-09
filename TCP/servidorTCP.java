package TCP;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servidorTCP {
	ServerSocket sServidor;
	Socket sCliente;
	int puerto;
	PrintStream salida;
	Scanner entrada;
	String mensajeSolicitud = " ";
	String mensajeRespuesta = " ";
	
	public servidorTCP(int p){
		puerto = p;
	}
	public void Sjuego(){
		
		try {
			sServidor = new ServerSocket(puerto);
			System.out.println("- SERVIDOR TCP INICIADO -");
			System.out.println("- Esperando Cliente -");
			while(true){
				sCliente = sServidor.accept();
				
				///////////////ESTE ES EL MENSAJE DE BIENVENIDA AL SERVIDOR////////////////////
				PrintStream bienvenida = new PrintStream(sCliente.getOutputStream());
				bienvenida.println("***BIENVENIDO AL SERVIDOR : PIEDRA PAPEL O TIJERA!!!! ***");
				////////////////////////////////////////////////////////////////////////////////
				
				PrintStream salida = new PrintStream(sCliente.getOutputStream());

				Scanner entrada1 = new Scanner(sCliente.getInputStream());
				

				int a = Integer.parseInt(entrada1.nextLine());
				

				if (a == 1) {
					salida.println("PAPEL ");
				}else{
					if (a==2) {
						salida.println("PIEDRA ");
					}else{
						if (a==3) {
							salida.println("TIJERA");
						}else {
							salida.println("Respuesta Del Servidor: FUERA DE RANGO");
						}
					}
				}
				
				System.out.println("opcion elegida por el cliente: "+a);
			}
		} catch (Exception e) {
			e.printStackTrace();
			finalizar();
		}
		finally{
			finalizar();
		}
	}
	public void finalizar(){
		try {
			salida.close();
			entrada.close();
			sServidor.close();
			sCliente.close();
			System.out.println("Conexion Finalizada...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
