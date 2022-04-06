package study_08th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1937 )
 */
public class BJ_01937_욕심쟁이판다_fail {
	// 시간초과

	static int N, ans, count;
	static int[][] map;
	static int[][] max;
//	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				visit = new boolean[N][N];
//				visit[i][j] = true;
				dfs(i, j, 1);
				ans = Math.max(ans, count);
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int y, int x, int cnt) {
		if (max[y][x] != 0) {
			return;
		}

//		count = Math.max(count, cnt);

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

//			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[y][x] >= map[ny][nx] || visit[ny][nx]) {
			if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[y][x] >= map[ny][nx]) {
				continue;
			}

//			visit[ny][nx] = true;
			dfs(ny, nx, cnt + 1);
		}
	}
}
