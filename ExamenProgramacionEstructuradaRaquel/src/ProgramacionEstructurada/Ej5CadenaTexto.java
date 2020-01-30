package ProgramacionEstructurada;

public class Ej5CadenaTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String texto;
		
		texto = "Nunca mates una mosca sobre la cabeza de un tigre.";
		
		System.out.println(texto.toUpperCase());
		System.out.println(texto.toLowerCase());
		System.out.println(texto.substring(0, 5));
		System.out.println(texto.substring(16, 21));
		System.out.println(texto.substring(31, 37));
		System.out.println(texto.indexOf('m'));
		System.out.println(texto.length());

	}

}
