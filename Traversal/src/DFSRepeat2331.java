import java.util.*;

public class DFSRepeat2331 {

	static int A, P;
	static int[] checked;
	public static void main(String[] args) {
		checked = new int[300000];
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		System.out.println(calc(A, 0));
	}
	
	static int calc(int a, int count) {
		if (checked[a] != 0) {
			return checked[a];
		}
		
		checked[a] = count;
		int next = powSum(a);
		
		return calc(next, count + 1);
	}

	static int powSum(int source) {
		int sum = 0;
		while (source > 0) {
			int a = (int)(source % 10);
			sum += Math.pow(a, P);
			source /= 10;
		}
		return sum;
	}
}
