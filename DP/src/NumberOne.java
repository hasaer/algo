import java.util.Arrays;
import java.util.Scanner;

public class NumberOne {

	static int[] arr;

	public static void main(String[] args) {
		// ���� ���� ���
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

	// ��� �ƴ� �ݺ��� -> Bottom up�� �ƴϰ� 124ms
	private static void calcMinLoop(int n) {
		arr[0] = 0; // ������ ������ �� ����
		arr[1] = 0; // 1 = 1

		for (int i = 2; i < n + 1; i++) {
			arr[i] = arr[i - 1] + 1; // �ּ� i - 1���� 1ȸ �� �ϰ� ������ 

			if (i % 3 == 0) { // ���� 3���� �����������, �� ���� i - 1�� + 1ȸ �� �� �����ٵ� �۴ٸ�, �� ��Ʈ�� ź��.
				if (arr[i] > arr[i / 3]) {
					arr[i] = arr[i / 3] + 1;
				}
			}
			
			if (i % 2 == 0) { // ��������
				if (arr[i] > arr[i / 2]) {
					arr[i] = arr[i / 2] + 1;
				}
			}
			
			// �ݺ��������� arr[i] �ϳ��� ä���� ������ �����ϴ� ���
		}
	}

	// Top down 344ms
	private static int calcMin(int n) {
		if (n == 1)
			return 0; //
		if (arr[n] != -1)
			return arr[n]; // �̹� ���Ǿ� ����� ���� ����

		// �߿�:
		// 3���� ������ 2�� ������ -1�̵� �ݵ�� �� �� �� �ؾ� �ϱ� ������ +1
		// eg. 10�� ��� 2�� ������ �������� 10 -> 5 -> 4 -> 2 -> 1�� ź�� ����������...
		// 9�� 9 -> 3 -> 1�� Ÿ�� ������ 10�� 9 + 1�� ���� ��
		// �׷��� n�� 3 �Ǵ� 2�� ������ �Ͱ� n-1���� �� �� �� ���� �� �������� ���ϴ� ����
		int result = calcMin(n - 1) + 1;

		if (n % 3 == 0) {
			if (result > calcMin(n / 3) + 1) {
				result = calcMin(n / 3) + 1;
			}	
		}
			//result = Math.min(result, calcMin(n / 3) + 1); // 3���� ������ �������� 3���θ� ������ �� ���� �����ϱ�
		if (n % 2 == 0) {
			if (result > calcMin(n / 2) + 1) {
				result = calcMin(n / 2) + 1;
			}
		}
			//result = Math.min(result, calcMin(n / 2) + 1); // n-1 ��������� 1�� ���ų� or �׳� 2�� ������ ��Ʈ�� �����ĸ� Ȯ��...

		arr[n] = result;
		return result;
	}

	// f(n)�� ���� �� �ּ� (f(n/3) + 1, f(n/2) + 1, f(n-1) + 1)
}