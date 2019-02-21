import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	private static char[][] arr;
	private static int size = 0;
	private static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());

		arr = new char[size][size];

		for (int i = 0; i < size; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				char letter = line.charAt(j);
				arr[i][j] = letter;
			}
		}

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int dir = 0; dir < 4; dir++) {
					int targetX = x + dirX[dir];
					int targetY = y + dirY[dir];

					if (targetX >= 0 && targetX < size && targetY >= 0 && targetY < size) {
						swap(x, y, targetX, targetY); // Swap
						getMax(size, arr);
						swap(x, y, targetX, targetY); // Roll-back
					}
				}
			}
		}

		System.out.println(max);
	}

	private static void swap(int oriX, int oriY, int tgtX, int tgtY) {
		char temp = arr[oriX][oriY];
		arr[oriX][oriY] = arr[tgtX][tgtY];
		arr[tgtX][tgtY] = temp;
	}

	private static void getMax(int size, char[][] arr) {
		int count = 1;
		int temp = 1;

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size - 1; y++) {
				char val = arr[x][y];
				if (val == arr[x][y + 1]) {
					count++;
				} else {
					temp = Math.max(count, temp);
					count = 1;
				}

				/*
				 * int countX = 0; int nextY = y; boolean foundX = false; while (!foundX &&
				 * nextY < size) { if (val == (arr[x][nextY])) { countX++; nextY++; } else {
				 * foundX = true; break; } }
				 */
			}
			temp = Math.max(count, temp);
			count = 1;

			for (int y = 0; y < size - 1; y++) {
				char val = arr[y][x];
				if (val == arr[y + 1][x]) {
					count++;
				} else {
					temp = Math.max(count, temp);
					count = 1;
				}
			}
			temp = Math.max(count, temp);
			count = 1;
		}
		
		if (temp > max) {
			max = temp;
		}
	}

	/*
	 * private static char[][] deepCopy() { char[][] result = new char[size][size];
	 * for (int i = 0; i < size; i++) { result[i] = Arrays.copyOf(arr[i],
	 * arr[i].length); } return result; }
	 */
}
