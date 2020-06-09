package TCP;
 
public class MainServidorTCP {

	public static void main(String[] args) {
		servidorTCP S = new servidorTCP(9999);
		
		//Recibe una opcion del cliente conectado y responde con el un mensaje
		S.Sjuego();
	}

}