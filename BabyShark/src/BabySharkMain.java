import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BabySharkMain {

	// N x N 공간, 물고기 M마리 + 아기 상어 1마리
	// 공간 1by1에 최대 1마리

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
	// 아기상어 1초에 인접한 상하좌우로 한 칸 이동
	// if (Size > mySize) 먹음
	// 1마리라면 걔를 먹고,
	// 1마리보다 많다면
	// 거리가 가장 가까운 물고기에게
	// 거리란? 도달하는동안 지나가는 칸의 개수의 최소값(가장 가까운 루트)
	// 거리가 동일한 경우가  2이상이면? 가장 위 -> 가장 왼쪽 순으로
	// else if (Size == mySize) 지나갑니다
	// else 못 지나갑니다 엄마 도와주세요
	
	// 이동 소요 시간은 1초
	// 물고기를 먹으면 그 자리는 빈칸
	
	// ** 플레이 로직
	// 자신의 크기와 같은 수의 물고기를 먹을 때마다 크기가 1 증가
	// -> Size == 2일 때 2마리 먹으면 3으로, 3일 때 3마리 먹으면 4로...
	// 공간이 주어졌을 때, 아기 상어가 몇 초 동안 엄마에게 도움을 요청하지 않고 -> 끝나는 로직
	// 물고기를 잡아먹을 수 있는지를 구하는 프로그램을 작성
	
	// args를 받아오는 법부터..?
}