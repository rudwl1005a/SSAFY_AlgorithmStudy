package ssafy.study_20th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1414 )
 */
public class BJ_01414_불우이웃돕기 {

	static int N;
	static ArrayList<ArrayList<ArrayList<Integer>>> graph;
	static boolean[] visited;
	static int total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int j = 0; j < N; j++) {
			String s = br.readLine();

			// 문자 판단해서 저장
			for (int i = 0; i < N; ++i) {
				int n = (int) s.charAt(i);
				ArrayList<Integer> list = new ArrayList<>();
				if (n >= 97 && n <= 122) {
					n = n - 96;
				} else if (n >= 65 && n <= 90) {
					n = n - 38;
				} else if (n == 48) {
					n = Integer.MAX_VALUE;
				}

				list.add(i);
				list.add(n);
				graph.get(j).add(list);
				if (n != Integer.MAX_VALUE) {
					total += n;
				}

			}
		}

		int ans = -1;
		for (int i = 0; i < N; ++i) {
			ans = Math.max(MST(i), ans);
		}

		System.out.println(ans);

	}

	public static int MST(int index) {
		PriorityQueue<Edge> q = new PriorityQueue<>();

		int count = -1;
		int result = 0;
		visited = new boolean[N];
		q.offer(new Edge(index, 0));

		while (!q.isEmpty()) {
			if (count == N - 1) {
				break;
			}

			Edge now = q.poll();

			if (visited[now.to]) {
				continue;
			}
			visited[now.to] = true;

			if (now.weight != Integer.MAX_VALUE) {
				result += now.weight;
				count++;
			}

			for (ArrayList<Integer> arr : graph.get(now.to)) {
				int nextTo = arr.get(0);
				int weight1 = arr.get(1);
				int weight2 = 0;

				for (ArrayList<Integer> a : graph.get(nextTo)) {
					if (a.get(0) == now.to) {
						weight2 = a.get(1);
					}
				}
				if (weight1 == Integer.MAX_VALUE && weight2 == Integer.MAX_VALUE) {
					continue;
				}
				int weight = Math.min(weight1, weight2);

				if (visited[nextTo]) {
					continue;
				}
				q.offer(new Edge(nextTo, weight));
			}

		}

		return count < N - 1 ? -1 : total - result;
	}

	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}
