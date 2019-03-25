import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int count = 1;
		while (count < 10) {
			System.out.println(num + " * " + count + " = " + num * count);
			count++;
		}
	}

}
