package ssafy.study_21st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/12784 )
 */
public class BJ_12784_인하니카공화국 {

	static int T, N, M, dp[], cost[][];
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			tree = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 섬의 개수
			M = Integer.parseInt(st.nextToken()); // 다리의 개수
			for (int i = 0; i < N + 1; i++) {
				tree.add(new ArrayList<>());
			}

			dp = new int[N + 1]; // n번째 노드까지의 다리 최소값
			cost = new int[N + 1][N + 1];
			visit = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				tree.get(u).add(v);
				tree.get(v).add(u);

				cost[u][v] = c;
				cost[v][u] = c;
			}

			dp[1] = 2000001;
			dfs(1, -1);

			// 1과 연결된 다리가 하나도 없다면 0을 출력
			sb.append(dp[1] == 2000001 ? 0 : dp[1]).append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int idx, int parent) {
		visit[idx] = true;

		if (parent != -1) { // 루트 노드가 아니라면 부모 노드와 자신과의 다이너마이트 수 저장
			dp[idx] = cost[parent][idx];
		}

		int sum = 0;
		for (int child : tree.get(idx)) { // 연결되어 있는 다리 확인
			if (!visit[child]) {
				dfs(child, idx);
				sum += dp[child]; // 자식 노드의 최소 다이너마이트 수를 더한다
			}
		}

		if (sum == 0) {
			sum = dp[idx];
		}

		dp[idx] = Math.min(sum, dp[idx]); // 부모 노드와 연결되어있는 다이너마이트 값과 자식노드들의 다이너마이트의 합의 최소값 저장
	}

}
