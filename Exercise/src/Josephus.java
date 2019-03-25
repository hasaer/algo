import java.util.*;
import java.io.*;

public class Josephus {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		System.out.print("<");
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				q.add(q.peek());
				q.poll();
			}
			System.out.print(q.peek() + ", ");
			q.poll();
		}
		System.out.print(q.peek());
		System.out.print(">");
	}

}
