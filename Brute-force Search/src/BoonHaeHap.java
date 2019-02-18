import java.io.*;
import java.util.*;

public class BoonHaeHap {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		boolean found = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toString();		
		int num = Integer.parseInt(input);
		int result = 0;
		
		if (num < 10) {
			found = false;
		} else {
			for (int i = num - (9 * input.length()); i < num && !found; i++) {
				int val = 0;
				int temp = i;
				while (true) {
					if (temp / 10 == 0) {
						val += temp;
						break;
					}
					
					val += temp % 10;
					temp /= 10;
				}
				
				val += i;
				
				if (val == num) {
					found = true;
					result = i;
					System.out.println(result);
					break;
				}
			}	
		}
		
		if (!found) {
			System.out.println(0);	
		}
		*/
		
		/*
		 * if (num < 1 || num > 1000000) { System.out.print(0); return; } else { for
		 * (int i = 1; i < num; i++) { String str = String.valueOf(i); String[] strs =
		 * str.split(""); int temp = i; for (int j = 0; j < strs.length; j++) { temp +=
		 * Integer.parseInt(strs[j]); } if (temp == num) { found = true;
		 * System.out.println(i); break; } }
		 * 
		 * if (!found) { System.out.println(0); } }
		 */
	}
}
