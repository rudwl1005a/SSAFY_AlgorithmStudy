package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/4386 )
 */
public class BJ_04386_별자리만들기 {

	static int N;
	static double ans;
	static Star[] stars;
	static int[] parents;
	static ArrayList<Edge> edgeList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		stars = new Star[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			stars[i] = new Star(x, y);
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				edgeList.add(new Edge(i, j, distance(stars[i], stars[j])));
			}
		}

		Collections.sort(edgeList);
		makeSet();

		int cnt = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				ans += edge.dist;
				if (++cnt == N - 1) {
					break;
				}
			}
		}

		System.out.printf("%.2f", ans);

	}

	private static double distance(Star star, Star star2) {
		return Math.sqrt(Math.pow((star2.y - star.y), 2) + Math.pow((star2.x - star.x), 2));
	}

	static class Star {
		double x, y;

		public Star(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double dist;

		public Edge(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}

	}

	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}

		parents[br] = ar;
		return true;
	}

}
