package ssafy.study_23rd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/14567 )
 */
public class BJ_14567_선수과목 {

	static int N, M, indegree[];
	static ArrayList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 과목의 수
		M = Integer.parseInt(st.nextToken()); // 선수 조건의 수

		indegree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // b의 선수과목
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			indegree[b]++;
		}

		topologicalSort(); // 위상정렬

		System.out.println(sb);

	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N + 1];

		// 선수과목이 없는 과목
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				result[i]++;
				q.offer(i);
			}
		}

		// 선수과목이 있는 과목
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i : list[node]) {
				indegree[i]--;

				if (indegree[i] == 0) {
					q.offer(i);
					if (result[i] < result[node] + 1) {
						result[i] = result[node] + 1;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(result[i]).append(" ");
		}

	}

}
