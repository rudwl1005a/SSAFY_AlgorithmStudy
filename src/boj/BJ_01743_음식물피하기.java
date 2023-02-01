package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/1743 )
 */
public class BJ_01743_음식물피하기 {

	static int N, M, K, ans, temp, map[][];

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로길이
		M = Integer.parseInt(st.nextToken()); // 가로길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기 개수
		map = new int[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}

		// dfs를 통해서 최대값 갱신
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 1) {
					temp = 0;
					dfs(i, j);
					ans = Math.max(ans, temp);
				}
			}
		}

		System.out.println(ans);
	}

	public static void dfs(int y, int x) {

		map[y][x] = 0;
		temp++;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 1 || nx < 1 || ny > N || nx > M || map[ny][nx] != 1) continue;
			dfs(ny, nx);
		}
	}
}
