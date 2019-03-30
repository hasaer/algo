import java.util.*;

public class QuickSort {
	
	static int[] src, target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = sc.nextInt();
		}
		
		sort(src, 0, src.length - 1);
		
		for (int i = 0; i < N; i++) {
			System.out.println(src[i]);
		}
	}
	
	static void sort(int[] src, int left, int right) {
		int i, j, pivot, temp;
		if (left < right) {
			i = left; j = right;
			pivot = src[(left + right) / 2];
			
			while (i < j) {
				while (src[j] > pivot) j--;
				
				while (i < j && src[i] <= pivot) i++;
				
				temp = src[i];
				src[i] = src[j];
				src[j] = temp;
			}
			
			sort(src, left, i - 1);
			sort(src, i + 1, right);
		}
	}
}
