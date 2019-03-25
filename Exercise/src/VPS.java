import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class VPS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Stack<Character> stackOpen = new Stack<Character>();
		Stack<Character> stackClose = new Stack<Character>();
		
		while (T-- > 0) {
			String line = br.readLine();
			char[] chars = line.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '(') {
					stackOpen.push(chars[i]);
				} else {
					if (stackOpen.size() > 0) {
						stackOpen.pop();	
					} else {
						stackClose.push(chars[i]);
					}
				}
			}
			
			if (stackOpen.size() == 0 && stackClose.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
			stackOpen.clear();
			stackClose.clear();
		}
	}

}
