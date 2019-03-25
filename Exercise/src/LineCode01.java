import java.util.Scanner;

public class LineCode01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long min = N - 1;
        for (long i = 1; i * i < N; i++) {
            if (N % i == 0) {
            	System.out.println(N / i + " " + i);
            	if (Math.abs((N / i) - i) < min) {
            		min = Math.abs((N / i) - i);
            	}
            }
        }
        System.out.print(min);
	}

}
