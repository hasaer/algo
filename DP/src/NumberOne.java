import java.util.Arrays;
import java.util.Scanner;

public class NumberOne {

	static int[] arr;

	public static void main(String[] args) {
		// 여러 열일 경우
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int n = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		//Arrays.fill(arr, -1);
		//System.out.println(calcMin(n));
		calcMinLoop(n);
		System.out.println(arr[n] + " " + arr[n - 1] + " " + arr[n - 2]);
	}

	// 재귀 아닌 반복문 -> Bottom up은 아니고 124ms
	private static void calcMinLoop(int n) {
		arr[0] = 0; // 어차피 접근할 일 없음
		arr[1] = 0; // 1 = 1

		for (int i = 2; i < n + 1; i++) {
			arr[i] = arr[i - 1] + 1; // 최소 i - 1보다 1회 더 하게 돼있음 

			if (i % 3 == 0) { // 만약 3으로 나누어떨어지고, 그 값이 i - 1에 + 1회 더 한 값보다도 작다면, 그 루트로 탄다.
				if (arr[i] > arr[i / 3]) {
					arr[i] = arr[i / 3] + 1;
				}
			}
			
			if (i % 2 == 0) { // 마찬가지
				if (arr[i] > arr[i / 2]) {
					arr[i] = arr[i / 2] + 1;
				}
			}
			
			// 반복수행으로 arr[i] 하나씩 채워서 끝까지 도달하는 방식
		}
	}

	// Top down 344ms
	private static int calcMin(int n) {
		if (n == 1)
			return 0; //
		if (arr[n] != -1)
			return arr[n]; // 이미 계산되어 저장된 값을 리턴

		// 중요:
		// 3으로 나누든 2로 나누든 -1이든 반드시 한 번 더 해야 하기 때문에 +1
		// eg. 10의 경우 2로 나누어 떨어져서 10 -> 5 -> 4 -> 2 -> 1을 탄다 생각했지만...
		// 9가 9 -> 3 -> 1을 타기 때문에 10은 9 + 1로 보는 것
		// 그래서 n을 3 또는 2로 나누는 것과 n-1에서 한 번 더 빼는 게 빠른지를 비교하는 것임
		int result = calcMin(n - 1) + 1;

		if (n % 3 == 0) {
			if (result > calcMin(n / 3) + 1) {
				result = calcMin(n / 3) + 1;
			}	
		}
			//result = Math.min(result, calcMin(n / 3) + 1); // 3으로 나누어 떨어지면 3으로만 나누는 게 가장 빠르니깐
		if (n % 2 == 0) {
			if (result > calcMin(n / 2) + 1) {
				result = calcMin(n / 2) + 1;
			}
		}
			//result = Math.min(result, calcMin(n / 2) + 1); // n-1 결과값에서 1을 빼거나 or 그냥 2로 나누는 루트가 빠르냐를 확인...

		arr[n] = result;
		return result;
	}

	// f(n)은 다음 중 최소 (f(n/3) + 1, f(n/2) + 1, f(n-1) + 1)
}