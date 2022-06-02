package ssafy.study_14th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1647 )
 */
public class BJ_01647_도시분할계획 {

	static int N, M, result, max;
	static ArrayList<Node>[] nodes;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			nodes[a].add(new Node(b, c));
			nodes[b].add(new Node(a, c));
		}

		prim(0);

		System.out.println(result - max);
	}

	private static void prim(int cnt) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();

		q.add(new Node(1, 0));

		while (true) {
			Node n = q.poll();

			if (visit[n.idx]) {
				continue;
			}

			visit[n.idx] = true;
			result += n.weight;
			max = Math.max(max, n.weight);
			cnt++;

			if (cnt == N) {
				break;
			}

			for (Node v : nodes[n.idx]) {
				if (!visit[v.idx]) {
					q.add(new Node(v.idx, v.weight));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int idx;
		int weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node e) {
			return this.weight - e.weight;
		}
	}
}
