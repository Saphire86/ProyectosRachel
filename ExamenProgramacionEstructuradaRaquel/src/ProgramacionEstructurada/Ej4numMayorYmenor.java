package ProgramacionEstructurada;

import java.util.Arrays;
import java.util.Scanner;

public class Ej4numMayorYmenor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int cuantos;
		int elementos[];
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("¿Numero de elementos?");
		cuantos = s1.nextInt();
		elementos = new int [cuantos];
		
		for (int i = 0; i < elementos.length; i++) {
			System.out.println("Escribe el numero "+(i+1)+" de la lista de numeros");
			elementos[i]=s1.nextInt();
		}
		
		Arrays.sort(elementos);
		
		int mayor = elementos[elementos.length-1];
		int menor = elementos[0];
		int repMa=0;
		int repMe=0;
		
		for (int ele : elementos) {			
			if (mayor==ele) {
				repMa++;
			} 
		}
		
		for (int ele : elementos) {			
			if (menor==ele) {
				repMe++;
			} 
		}
		
		System.out.println("El numero mayor es: "+mayor+ " y se repite: "+repMa+" veces.");
		System.out.println("El numero menor es: "+menor+ " y se repite: "+repMe+" veces.");		

	}

}
