import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class NineDwarves {
	private static int[] arr = new int[9];
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		int a = 0, b = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int kid = arr[i] + arr[j];
				if (sum - kid == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i != a && i != b) {
				System.out.println(arr[i]);
			}
		}
	}
*/
}
