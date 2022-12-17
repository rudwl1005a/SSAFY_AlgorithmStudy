package ssafy.study_31st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/14497 )
 */
public class BJ_14497_주난의난 {

	static int N, M, ans;
	static int x1, y1, x2, y2;
	static char map[][];
	static boolean visit[][];
	static boolean flag; // 범인을 찾았는지 확인

	static int[] dy = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		y1 = Integer.parseInt(st.nextToken()) - 1;
		x1 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;
		x2 = Integer.parseInt(st.nextToken()) - 1;

		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		while (!flag) {
			visit = new boolean[N][M];
			dfs(y1, x1);
			ans++;
		}

		System.out.println(ans);
	}

	private static void dfs(int y, int x) {
		visit[y][x] = true;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx]) {
				continue;
			}
			if (ny == y2 && nx == x2) { // 범인 찾았으면
				flag = true;
				return;
			}
			// 빈칸이면 전진
			if (map[ny][nx] == '0') {
				dfs(ny, nx);
			}
			// 장애물이면 빈칸으로 만들고 visit처리
			if (map[ny][nx] == '1') {
				map[ny][nx] = '0';
				visit[ny][nx] = true;
			}
		}

	}

}
