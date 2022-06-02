package ssafy.study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 골드5 ( https://www.acmicpc.net/problem/9663 )
 * 메모리 : 15532KB, 시간: 13328ms
 */
public class BJ_09663_NQueen {

	static int N, count;
	static boolean[][] chess;

	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 위에서부터 시계방향
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		chess = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			checkQueen(0, i);
		}

		System.out.println(count);
	}

	static void checkQueen(int y, int x) {
		
		// 놓은 자리에서 팔방탐색해서 퀸이 있는지 확인
		for (int d = 0; d < 8; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			// 한 방향으로 쭉 가고
			while (true) {
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) break;
				if (chess[ny][nx]) {
					return; // 퀸 발견했으면 리턴
				}
				ny = ny + dy[d];
				nx = nx + dx[d];
			}
		}
		
		// 기저 조건 - 여기까지 오면 8개 다 놓은것
		if (y == N - 1) {
			count++;
			return;			
		}
		
		// 퀸 없으면 퀸 놓고 다음 줄 확인
		for (int i = 0; i < N; i++) {
			chess[y][x] = true;		
			checkQueen(y + 1, i);
		}
		chess[y][x] = false;
	}

}