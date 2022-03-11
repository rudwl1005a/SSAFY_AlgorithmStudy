package study_6th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/17835 )
 */
public class BJ_17835_면접보는승범이네 {

	static int N, M, K, maxCity;
	static long maxDis;
	static ArrayList<ArrayList<Node>> map = new ArrayList<>();
	static long[] dist; // 면접장 까지의 거리
	static boolean[] visit;

	static PriorityQueue<City> pq = new PriorityQueue<City>((c1, c2) -> Long.compare(c1.dis, c2.dis));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 수
		M = Integer.parseInt(st.nextToken()); // 도로의 수
		K = Integer.parseInt(st.nextToken()); // 면접장의 수

		visit = new boolean[N + 1];
		dist = new long[N + 1];

		for (int i = 0; i < N + 1; i++) {
			map.add(new ArrayList<>());
		}

		// 도로 정보 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			map.get(to).add(new Node(from, distance));
		}

		// dijkstra
		Arrays.fill(dist, Long.MAX_VALUE);

		// 면접장 정보 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			dist[n] = 0;
			pq.offer(new City(n, dist[n])); // 각 면접장에서 출발
		}

		while (!pq.isEmpty()) {
			City city = pq.poll();

			if (visit[city.n]) {
				continue;
			}

			visit[city.n] = true;

			for (int i = 0; i < map.get(city.n).size(); i++) {
				Node node = map.get(city.n).get(i);
				if (!visit[node.from] && dist[city.n] + (long) node.dis < dist[node.from]) {
					dist[node.from] = dist[city.n] + (long) node.dis;
					pq.offer(new City(node.from, dist[node.from]));
				}
			}
		}

		maxDis = Long.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			if (visit[i] && dist[i] > maxDis) {
				maxDis = dist[i];
				maxCity = i;
			}
		}

		System.out.println(maxCity);
		System.out.println(maxDis);
	}

	static class City {
		int n; // 도시 번호
		long dis; // 면접장까지의 거리

		public City(int n, long dis) {
			this.n = n;
			this.dis = dis;
		}
	}

	static class Node {
		int from;
		int dis;

		public Node(int from, int dis) {
			this.from = from;
			this.dis = dis;
		}
	}
}
