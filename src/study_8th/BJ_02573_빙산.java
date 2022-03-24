package study_8th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2573 )
 */
public class BJ_02573_빙산 {

	static int N, M, count, ans;
	static int[][] map;
	static boolean[][] visit;

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					count++;
				}
			}
		}

		do {
			int cnt = 0;
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 || visit[i][j]) {
						continue;
					}
					dfs(i, j);
					cnt++;
				}
			}

			if (cnt >= 2) {
				System.out.println(ans);
				return;
			}
			ans++;
		} while (melt());

		System.out.println(0);
	}

	private static void dfs(int y, int x) {

		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M || map[ny][nx] == 0 || visit[ny][nx]) {
				continue;
			}

			visit[ny][nx] = true;
			dfs(ny, nx);
		}

	}

	private static boolean melt() {
		
		int[][] temp = new int[N][M];
		copyMap(map, temp);
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (temp[y][x] == 0) {
					continue;
				}
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || temp[ny][nx] != 0) {
						continue;
					}
					cnt++;
				}
				if (temp[y][x] <= cnt) {
					map[y][x] = 0;
					count--;
				} else {
					map[y][x] -= cnt;
				}
			}
		}

		if (count == 0) {
			return false;
		}

		return true;
	}

	private static void copyMap(int[][] origin, int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = origin[i][j];
			}
		}
	}

}
