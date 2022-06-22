package ssafy.study_17th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1005 )
 */
public class BJ_01005_ACMCraft {

	static int T, N, K, W, min;
	static int[] build, indegree;
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물의 갯수
			K = Integer.parseInt(st.nextToken()); // 건설순서 규칙 갯수

			build = new int[N + 1];
			list = new ArrayList[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				build[i] = Integer.parseInt(st.nextToken());
				list[i] = new ArrayList<>();
			}

			indegree = new int[N + 1]; // y건물을 짓기 전에 필요한 건물 개수 for 위상정렬
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // x건물 지은 다음에
				int y = Integer.parseInt(st.nextToken()); // y건물 짓기 가능

				list[x].add(y);
				indegree[y]++;
			}

			W = Integer.parseInt(br.readLine());

			sb.append(topologicalSort()).append("\n");
		}
		System.out.println(sb);
	}

	private static int topologicalSort() { // 위상정렬
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];

		// 기본 소요시간
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				result[i] = build[i];
				q.offer(i);
			}
		}

		// 총 소요시간 = 이전까지 소요시간 + 현재 건물 소요시간
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i : list[node]) {
				result[i] = Math.max(result[i], result[node] + build[i]); // 이전 건물이 다 올라가야 건물을 지을 수 있기 떄문에 Max값 넣어주기
				indegree[i]--;

				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		return result[W];
	}

}

/*
 * 참고 : 위상정렬 ( https://bcp0109.tistory.com/21 )
 */