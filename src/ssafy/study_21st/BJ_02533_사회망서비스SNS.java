package ssafy.study_21st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2533 )
 */
public class BJ_02533_사회망서비스SNS {

	static int N, dp[][];
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		dp = new int[N + 1][2]; // 2차원 index 0 : 얼리어답터가 아닐때, 1 : 얼리어답터일때
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}

		dfs(1);

		System.out.println(Math.min(dp[1][0], dp[1][1])); // 첫번째 노드가 얼리어답터일 경우와 아닐경우 중 최소값
	}

	private static void dfs(int idx) {
		visit[idx] = true;
		dp[idx][0] = 0; // idx번째 노드가 얼리어답터가 아닌경우
		dp[idx][1] = 1; // idx번째 노드가 얼리어답터일 경우

		for (int child : tree.get(idx)) {
			if (!visit[child]) { // 자식노드를 방문 안했다면
				dfs(child); // 자식 노드의 dp값 확인
				dp[idx][0] += dp[child][1]; // 자기가 얼리어답터가 아닐경우는 자식들이 얼리어 답터여야 한다
				dp[idx][1] += Math.min(dp[child][0], dp[child][1]); // 자기가 얼리어답터일 경우 자식들은 얼리어답터일 수도 아닐수도 있다(최소값을 구하는 것이기 때문)
			}
		}
	}
}
