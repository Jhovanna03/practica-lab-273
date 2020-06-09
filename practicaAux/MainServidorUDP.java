package practicaAux;

public class MainServidorUDP {

	public static void main(String[] args) {
		ServidorUDP S = new ServidorUDP(8888);
		
		//El servidor responde con el tamaño de la cadena 
		S.TamañoS();
		
		
	}
}