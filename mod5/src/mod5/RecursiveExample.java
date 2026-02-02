package mod5;
import java.util.Scanner;

public class RecursiveExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double[] numbers = new double[5];
		
		System.out.println("Enter five numbers, I will give you the product. :)");
		
		getInput(scanner, numbers, 0);
		
		double totalProduct = calculateProduct(numbers, 0);
		
		System.out.println("The product is: " +totalProduct);
		scanner.close();
	}

	public static void getInput(Scanner sc, double[] arr, int index) {
		if (index == 5) {
			return;
		}
		System.out.println("Enter number " +(index + 1) +": ");
		arr[index] = sc.nextDouble();
		getInput(sc, arr, index +1);
	}
		
		public static double calculateProduct(double[] arr, int index) {
			if (index == arr.length - 1) {
				return arr[index];
			}
			return arr[index] * calculateProduct(arr, index + 1);			
		}

	
}


