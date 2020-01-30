package ProgramacionEstructurada;

import java.util.Scanner;

public class Ej3TipoDeCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;		
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("Introduce un numero de 1 a 8 en la pantalla para ver el tipo de coche:");
		numero = s1.nextInt();
		
		switch (numero) {
		case 1:
			System.out.println("MICROCOCHE");
			break;
		case 2:
			System.out.println("AUTOMOVIL COMPACTO");
			break;
		case 3:
			System.out.println("AUTOMOVIL ULTRACOMPACTO");
			break;
		case 4:
			System.out.println("AUTOMOVIL FAMILIAR");
			break;
		case 5:
			System.out.println("VEHICULO DE LUJO");
			break;
		case 6:
			System.out.println("AUTOMOVIL DEPORTIVO");
			break;
		case 7:
			System.out.println("DESCAPOTABLE");
			break;
		case 8:
			System.out.println("TODOTERRENO");
			break;
		default:
			break;
		}
		
	}

}
