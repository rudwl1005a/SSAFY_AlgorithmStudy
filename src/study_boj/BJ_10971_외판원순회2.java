package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/10971 )
 */
public class BJ_10971_외판원순회2 {
	static int N;
	static long ans;
	static int[][] map;

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

		ans = Long.MAX_VALUE;
		dfs(0, 0, 1, 1);
		System.out.println(ans == Long.MAX_VALUE ? 0 : ans);
	}

	private static void dfs(int loc, long dis, int visit, int cnt) {

		if (dis > ans) {
			return;
		}
		
		if (cnt == N) {
			if (map[loc][0] != 0) {
				dis += map[loc][0];
				ans = Math.min(ans, dis);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visit & 1 << i) != 0 || map[loc][i] == 0) {
				continue;
			}

			dfs(i, dis + map[loc][i], visit | 1 << i, cnt + 1);
		}
	}
}
