package ssafy.study_13th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1238 )
 */
public class BJ_01238_파티 {

	static final int INF = Integer.MAX_VALUE;
	static int N, M, X;
	static List<ArrayList<Node>> list = new ArrayList<>();
	static List<ArrayList<Node>> backlist = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //
		X = Integer.parseInt(st.nextToken()); // 이동 시간

		list = new ArrayList<>();
		backlist = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			backlist.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list.get(n).add(new Node(m, t));
			backlist.get(m).add(new Node(n, t));
		}

		int max = Integer.MIN_VALUE;

		int goResult[] = dijkstra(list);
		int backResult[] = dijkstra(backlist);

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, goResult[i] + backResult[i]);
		}

		System.out.println(max);
	}

	static int[] dijkstra(List<ArrayList<Node>> list) {
		PriorityQueue<Node> que = new PriorityQueue<>();

		boolean visit[] = new boolean[N + 1];
		int dist[] = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[X] = 0;

		que.offer(new Node(X, 0));

		while (!que.isEmpty()) {
			Node queNode = que.poll();
			int num = queNode.roadNum;

			if (visit[num])
				continue;

			visit[num] = true;
			for (Node node : list.get(num)) {
				if (!visit[node.roadNum] && dist[node.roadNum] > (dist[num] + node.time)) {
					dist[node.roadNum] = dist[num] + node.time;
					que.offer(new Node(node.roadNum, dist[node.roadNum]));
				}
			}

		}

		return dist;
	}

	static class Node implements Comparable<Node> {
		int roadNum; // 도로 번호
		int time; // 시간

		public Node(int roadNum, int time) {
			this.roadNum = roadNum;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return time - o.time;
		}

	}
}
