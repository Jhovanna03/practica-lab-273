package TCP;

public class MainClienteTCP{
	public static void main(String[] args) {
		ClienteTCP C = new ClienteTCP("localhost",9999);
		
		//Envia 1 opcion, el servidor responde con la opcion elegida
		C.Cjuego();
	}
}
