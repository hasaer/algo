import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci {

	static BigInteger[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new BigInteger[n + 1];
		Arrays.fill(arr, BigInteger.valueOf(-1));
		System.out.println(fibonacci(n));
	}

	private static BigInteger fibonacci(int n) {
		if (n == 0) return BigInteger.valueOf(0);
		if (n == 1) return BigInteger.valueOf(1);
		if (arr[n] != BigInteger.valueOf(-1)) {
			return arr[n];
		} else {
			BigInteger big = new BigInteger("0");
			return arr[n] = big.add(fibonacci(n - 2).add(fibonacci(n - 1))); 
		}
	}
}
