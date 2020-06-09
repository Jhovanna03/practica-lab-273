package practicaAux;

import java.io.IOException;

public class MainClienteUDP {
	public static void main(String[] args) throws IOException {
		ClienteUDP C = new ClienteUDP("127.0.0.1",8888);
		
		//El cliente manda la cadena y el servidor responde con el tamaño 
		C.TamañoC();
			
	}
}
