package practicaAux;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServidorUDP {
	DatagramSocket socketUDP;
	int puerto;
	public ServidorUDP(int p) {
		puerto = p;
	}
	
	public void TamañoS(){
		try {
			socketUDP = new DatagramSocket(puerto);
			System.out.println(" ----- SERVIDOR UDP INICIADO -----");
			System.out.println("---- Esperando Solicitudes ----");
			while(true){
				
				/////////////////////RECIBIMOS EL 1er DATAGRAMA DEL CLIENTE////////////////////////
				DatagramPacket paqueteRecibido = new DatagramPacket(new byte[1024],1024);
				socketUDP.receive(paqueteRecibido);
				String mensajeRecibido =recorte( new String(paqueteRecibido.getData()));
				///////////////////////////////////////////////////////////////////
				
				
				////////////////////////////ENVIAMOS EL DATAGRAMA DE RESPUESTA AL CLIENTE//////////////////////////
				byte mensajeEnviar[] = new byte[5];
				String respuestaaCliente = "Tamaño de cadena: "+mensajeRecibido.length()+"#";
				mensajeEnviar = respuestaaCliente.getBytes();
				DatagramPacket paqueteAEnviar = new DatagramPacket(mensajeEnviar,mensajeEnviar.length,paqueteRecibido.getAddress(),paqueteRecibido.getPort());
				socketUDP.send(paqueteAEnviar);
				///////////////////////////////////////////////////////////////////////////////////////////////////
				
				////////////////////////////IMPRIMIMOS EN LA CONSOLA DEL SERVIDOR////////////////////////////////////
				System.out.println("tamaño de cadena: "+mensajeRecibido.length()+" ");
				
			}
		}catch(Exception e){ 	
			e.printStackTrace();
		}
	}
	
	public void finalizar(){
		try{
			socketUDP.close();
			System.out.println("Conexion Finalizada...!!!");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String recorte(String s){
		String m="";
		char c[]=s.toCharArray();
		boolean sw=true;
		for(int i=0;i<s.length()&&sw;i++){
			if(c[i]!='#'){
				m=m+c[i];
			}else{
				sw=false;
			}
		}
		return m;
	}
}
