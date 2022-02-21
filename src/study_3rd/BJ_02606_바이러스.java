package study_3rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2606 )
 */
public class BJ_02606_바이러스 {
	// DFS

	static int N, M, ans; // 컴퓨터 수, 연결 쌍 수
	static boolean[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = true;
			map[x][y] = true;

		}

		// 1번 컴퓨터부터 시작
		dfs(1);

		System.out.println(ans);
	}

	private static void dfs(int from) {

		visit[from] = true;

		for (int i = 1; i <= N; i++) {
			if (visit[i] || !map[from][i]) {
				continue;
			}
			ans++;
			dfs(i);
		}

		return;

	}

}
