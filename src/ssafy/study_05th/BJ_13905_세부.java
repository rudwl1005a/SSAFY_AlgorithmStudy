package ssafy.study_05th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/13905 )
 */
public class BJ_13905_세부 {

	static int N, M, s, e, ans;
	static int[] parent;
	// 가중치의 내림차순으로 정렬하는 PQ
	static PriorityQueue<Bridge> pq = new PriorityQueue<Bridge>((b1, b2) -> b2.weight - b1.weight);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 집의 수
		M = Integer.parseInt(st.nextToken()); // 다리의 수

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // 숭이 출발위치
		e = Integer.parseInt(st.nextToken()); // 혜빈이 위치

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.offer(new Bridge(from, to, weight));
		}

		// make-set
		parent = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}
		
		while(!pq.isEmpty()) {
			Bridge b = pq.poll();
			
			if(findSet(b.from) == findSet(b.to)) { // 이미 이어져 있다면 확인하지 않는다
				continue;
			}
			
			union(b.from, b.to);
			
			if(findSet(s) == findSet(e)) { // s, e가 처음으로 이어질 때 빼빼로의 최대 무게는 그 다리의 무게제한만큼 이다
				ans = b.weight;
				break;
			}
		}

		System.out.println(ans);
	}

	private static int findSet(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
	}

	private static boolean union(int a, int b) {
		int ar = findSet(a);
		int br = findSet(b);
		if (ar == br) {
			return false;
		}
		parent[br] = ar;
		return true;
	}

	static class Bridge {
		int from, to, weight;

		public Bridge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}
