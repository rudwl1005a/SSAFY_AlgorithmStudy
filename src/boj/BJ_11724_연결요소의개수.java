package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/11724 )
 */
public class BJ_11724_연결요소의개수 {

	static int N, M, ans, map[][] = new int[1001][1001];
	static boolean[] visited = new boolean[1001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a][b] = map[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				dfs(i);
				ans++;
			}
		}

		System.out.println(ans);
	}

	private static void dfs(int idx) {
		if (visited[idx] == true)
			return;
		else {
			visited[idx] = true;
			for (int i = 1; i <= N; i++) {
				if (map[idx][i] == 1) {
					dfs(i);
				}
			}
		}
	}
}
