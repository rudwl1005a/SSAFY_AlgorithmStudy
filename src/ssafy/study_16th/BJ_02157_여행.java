package ssafy.study_16th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2157 )
 */
public class BJ_02157_여행 {

	private static int N, M, K, dp[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// DP[M][N] = M번 도시 방문 했을 때 도착 도시 번호가 N
		dp = new int[M + 1][N + 1];
		List<Node> boards[] = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			boards[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a > b) {
				continue;
			}
			boards[a].add(new Node(b, c));
		}

		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		int cnt = 1;
		while (!q.isEmpty() && cnt < M) {

			int size = q.size();

			while (size-- > 0) {
				int nowIndex = q.poll();
				for (Node nextNode : boards[nowIndex]) {
					int nextIndex = nextNode.index;
					int nextScore = dp[cnt][nowIndex] + nextNode.score;
					if (dp[cnt + 1][nextIndex] >= nextScore) {
						continue;
					}
					dp[cnt + 1][nextIndex] = nextScore;
					q.add(nextIndex);
				}
			}
			cnt++;
		}

		for (int i = 2; i <= M; i++) {
			result = Integer.max(result, dp[i][N]);
		}
		System.out.println(result);

	}

	public static class Node {
		int index;
		int score;

		public Node(int index, int score) {
			this.index = index;
			this.score = score;
		}
	}
}
