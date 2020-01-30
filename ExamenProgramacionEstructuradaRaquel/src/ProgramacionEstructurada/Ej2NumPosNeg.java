package ProgramacionEstructurada;

import java.util.Scanner;

public class Ej2NumPosNeg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero;		
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("Introduce un numero en la pantalla:");
		numero = s1.nextInt();
		
		if (numero == 0) {
			System.out.println("El numero es 0");
		} else {
			if (numero < 0) {
				System.out.println("El numero es negativo");
			} else {
				System.out.println("El numero es positivo");
			}
		}
	}	
}
