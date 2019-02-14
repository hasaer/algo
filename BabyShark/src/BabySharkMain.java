import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabySharkMain {

	// N x N ����, ����� M���� + �Ʊ� ��� 1����
	// ���� 1by1�� �ִ� 1����

	private static int mapSize;
	private static int[][] map;
	
	
	public static int[][] Sharks;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mapSize = Integer.parseInt(br.readLine());
		map = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				int wtf = Integer.parseInt(st.nextToken());
				map[i][j] = wtf;
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}

class Shark {
	public int Size = 0;
	// �Ʊ��� 1�ʿ� ������ �����¿�� �� ĭ �̵�
	// if (Size > mySize) ����
	// 1������� �¸� �԰�,
	// 1�������� ���ٸ�
	// �Ÿ��� ���� ����� ����⿡��
	// �Ÿ���? �����ϴµ��� �������� ĭ�� ������ �ּҰ�(���� ����� ��Ʈ)
	// �Ÿ��� ������ ��찡  2�̻��̸�? ���� �� -> ���� ���� ������
	// else if (Size == mySize) �������ϴ�
	// else �� �������ϴ� ���� �����ּ���
	
	// �̵� �ҿ� �ð��� 1��
	// ����⸦ ������ �� �ڸ��� ��ĭ
	
	// ** �÷��� ����
	// �ڽ��� ũ��� ���� ���� ����⸦ ���� ������ ũ�Ⱑ 1 ����
	// -> Size == 2�� �� 2���� ������ 3����, 3�� �� 3���� ������ 4��...
	// ������ �־����� ��, �Ʊ� �� �� �� ���� �������� ������ ��û���� �ʰ� -> ������ ����
	// ����⸦ ��Ƹ��� �� �ִ����� ���ϴ� ���α׷��� �ۼ�
	
	// args�� �޾ƿ��� ������..?
}