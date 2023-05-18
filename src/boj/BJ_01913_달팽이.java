package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1913 )
 */
public class BJ_01913_달팽이 {

	static int N, K, map[][];

	static int[] dy = { 1, 0, -1, 0 }; // 하, 우, 상, 좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int kr = 0;
		int kc = 0;

		makeMap(N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
				if (map[i][j] == K) {
					kr = i;
					kc = j;
				}
			}
			sb.append("\n");
		}
		sb.append(kr + 1).append(" ").append(kc + 1);
		System.out.println(sb);
	}

	public static void makeMap(int n) {
		int y = 0;
		int x = 0;
		int count = n * n;
		int d = 0; // 방향

		while (true) {
			if (count == 0) {
				break;
			}
			map[y][x] = count--;
			int ny = y + dy[d];
			int nx = x + dx[d];
			int nd = setDirection(d, n, ny, nx);
			
			// 방향이 바뀌면 다음 방향을 기준으로 y,x를 업데이트.
			if (nd != d) {
				y = y + dy[nd];
				x = x + dx[nd];
				d = nd;
			} else {
				y = ny;
				x = nx;
			}
		}
	}

	public static int setDirection(int d, int n, int ny, int nx) {
		// 범위를 벗어났거나 이후 있을 자리가 이미 값이 있거나
		if (ny >= n || nx >= n || ny < 0 || nx < 0 || map[ny][nx] != 0) {
			d = (d + 1) % 4;
		}
		return d;
	}

}
