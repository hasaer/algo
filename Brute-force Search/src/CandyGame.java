import java.util.*;
import java.io.*;

public class CandyGame {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine().toString());
		if (size < 3 || size > 50) {
			System.out.println(0);
		}
		
		String[][] arr = new String[size][size];
		for (int i = 0; i < size; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				String str = line[j];
				arr[i][j] = str;
			}
		}
		
		int max = 0;
		String[][] target;
		/*
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				String ori = arr[i][j];
				
				int l, r, u, d;
				l = i - 1;
				r = i + 1;
				u = j - 1;
				d = j + 1;
				
				int pos = 0;
				if (l > -1) {
					target = arr.clone();
					String temp = arr[l][j];
					target[i][j] = temp;
					target[l][j] = ori;
					// target 가져가서 연결된 사탕 확인
				}
			}
		}
		*/
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				String val = arr[i][j];
				int count = 0;
				int right = j;
				//System.out.println("Compare " + arr[i][j] + " in " + i + ", " + j);
				boolean diff = false;
				while (!diff && right < size) {
					if (val.equals(arr[i][right])) {
						count++;
						right++;
					} else {
						diff = true;
						break;
					}
				}
				if (count > max) {
					System.out.println("Updated! at " + i + ", "+ j );
					max = count;
				}
			}
		}
		
		System.out.println(max);
		
		/* 자리 바꾸기 경우의 수
		 * 3 x 3 -> 12 (6 + 6)
		 * 4 x 4 -> 24 (12 + 12)
		 * 5 x 5 -> 40 (20 + 20)
		 * 6 x 6 -> 60 (30 + 30)
		 * 3 x 4, 4 x 6, 5 x 8, 6 x 10
		 * n * (n -1) * 2
		 * *
		 */
		
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
}
