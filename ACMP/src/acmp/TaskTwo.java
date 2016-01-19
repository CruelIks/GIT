package acmp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskTwo {

	/*public static int getNum(int count) {

		if (count == 1) {
			return 1;
		} else {
			
			for (int i = 1; i <= stepSize; i++) {
				resultCalc = resultCalc + getNum(lesSize - i);
			}
			return resultCalc;
		}

	}*/

	public static void main(String args[]) {

		int stepSize, lesSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите шаг:");
		stepSize = sc.nextInt();
		System.out.println("¬ведите длину лестницы:");
		lesSize = sc.nextInt();
		

		int myArray[] = new int[lesSize + 1];
		myArray[0] = 1;
		
		for (int i = 1; i < myArray.length; i++) {
			
			if (i <= stepSize) {

				for (int j = 0; j < i; j++) {
					myArray[i] = myArray[i] + myArray[j];
				}
				
			} else {

				for (int j = (i - stepSize); j < i; j++) {
					myArray[i] = myArray[i] + myArray[j];
				}
			}
			
		}

		printArray(myArray);
		sc.close();
	}

	private static void printArray(int[] myArray) {
		for (int i = 0; i < myArray.length; i++) {
			System.out.print("" + myArray[i] + " ");
		}

	}
}
