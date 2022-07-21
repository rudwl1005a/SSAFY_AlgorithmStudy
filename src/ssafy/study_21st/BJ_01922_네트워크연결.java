package ssafy.study_21st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1922 )
 */
public class BJ_01922_네트워크연결 {

	static int N, M, ans;
	static int[] parents;
	static PriorityQueue<Computer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (to == from) {
				continue;
			}
			pq.add(new Computer(to, from, cost));
		}

		makeSet();

		int cnt = 0;
		while (cnt < N && !pq.isEmpty()) {
			Computer c = pq.poll();
			if (union(c.to, c.from)) {
				ans += c.cost;
				cnt++;
			}
		}

		System.out.println(ans);

	}

	private static void makeSet() {
		parents = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	private static int findSet(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}
		parents[br] = ar;
		return true;
	}

	static class Computer implements Comparable<Computer> {
		int to, from, cost;

		public Computer(int to, int from, int cost) {
			super();
			this.to = to;
			this.from = from;
			this.cost = cost;
		}

		@Override
		public int compareTo(Computer o) {
			return this.cost - o.cost; // 오름차순으로 정렬
		}

	}

}
