package ssafy.study_24th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2623 )
 */
public class BJ_02623_음악프로그램 {

	static int N, M, indegree[];
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		indegree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int prev = 0;
		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int size = Integer.parseInt(str[0]);
			for (int j = 1; j <= size; j++) {
				int a = Integer.parseInt(str[j]);
				if (j == 1) {
					continue;
				}
				prev = Integer.parseInt(str[j - 1]);
				list[prev].add(a); // 이전에 받았던 가수가 a보다 앞에서 공연을 해야한다
				indegree[a]++;
			}
		}

		topologicalSort(); // 위상정렬

	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();

		// 앞 순서가 없는 가수
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		// 앞 순서가 있는 가수
		while (!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);

			for (int i : list[node]) {
				indegree[i]--;

				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}

		// cycle인 경우 -> 순서가 정하는 것이 불가능할 경우 0 출력
		if (result.size() != N) {
			System.out.println(0);
			return;
		}

		StringBuilder sb = new StringBuilder();
		while (!result.isEmpty()) {
			sb.append(result.poll()).append("\n");
		}
		System.out.println(sb);
	}

}
