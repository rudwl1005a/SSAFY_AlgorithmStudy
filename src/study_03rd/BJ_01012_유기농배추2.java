package study_03rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/1012 )
 * 시간 : 160ms
 */
public class BJ_01012_유기농배추2 {
	// DFS로 풀기

	static int T, N, M, K, count;
	static boolean[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// 초기화
			count = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!map[i][j] || visit[i][j])
						continue;
					dfs(i, j);
					count++;
				}
			}

			System.out.println(count);
		}
	}

	private static void dfs(int y, int x) {

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || !map[ny][nx] || visit[ny][nx])
				continue;
			visit[ny][nx] = true;
			dfs(ny, nx);
		}

	}

}
