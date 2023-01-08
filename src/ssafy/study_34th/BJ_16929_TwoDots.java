package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/16929 )
 */
public class BJ_16929_TwoDots {

	static int N, M, sy, sx;
	static char map[][];
	static boolean ans, visited[][];

	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] || ans) continue;
				sy = i; sx = j;
				dfs(i, j, 0);
			}
		}
		
		System.out.println(ans ? "Yes" : "No");
	}

	private static void dfs(int y, int x, int cnt) {

		// 사이클 확인
		if (cnt >= 4 && y == sy && x == sx) {
			ans = true;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx]) continue;
			if (map[y][x] == map[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx, cnt + 1);
				visited[ny][nx] = false; // 사이클 확인 위해서 방문체크 해제
			}
		}
	}

}
