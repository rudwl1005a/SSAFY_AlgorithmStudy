package ssafy.study_32nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/15685 )
 */
public class BJ_15685_드래곤커브 {

	static boolean[][] map;
	static int N;

	/*
	 * 0: x좌표가 증가하는 방향 (→)
	 * 1: y좌표가 감소하는 방향 (↑)
	 * 2: x좌표가 감소하는 방향 (←)
	 * 3: y좌표가 증가하는 방향 (↓)
	 */
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new boolean[101][101];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			List<Integer> list = new ArrayList<>();
			list.add(d);

			for (int j = 0; j < g; j++) {
				for (int k = list.size() - 1; k >= 0; k--) {
					list.add((list.get(k) + 1) % 4);
				}
			}

			map[y][x] = true;
			for (int nd : list) {
				y += dy[nd];
				x += dx[nd];
				map[y][x] = true;
			}
		}

		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
