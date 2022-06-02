package study_boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 S5 ( https://www.acmicpc.net/problem/11651 )
 */
public class BJ_11651_좌표정렬하기2 {

	static int N;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.offer(new Node(y, x));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Node node = pq.poll();
			sb.append(node.x).append(" ").append(node.y).append("\n");
		}
		System.out.println(sb);
	}

	static class Node implements Comparable<Node> {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Node o) {
			return this.y == o.y ? this.x - o.x : this.y - o.y;
		}
	}
}
