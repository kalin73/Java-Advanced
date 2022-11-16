import java.util.Arrays;
import java.util.Scanner;


public class Add_VAT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Prices with VAT:");
		Arrays.stream(sc.nextLine().split(", "))
		      .map(Double::parseDouble)
		      .map(x -> x * 1.2)
		      .forEach(x->System.out.printf("%.2f%n",x));
		
		sc.close();

	}

}
