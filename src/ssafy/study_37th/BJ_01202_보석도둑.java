package ssafy.study_37th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G2 ( https://www.acmicpc.net/problem/1202 )
 */
public class BJ_01202_보석도둑 {

	static int N, K, W[];
	static long ans;
	static Jewel[] jewels;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 보석 개수
		K = Integer.parseInt(st.nextToken()); // 가방 개수

		jewels = new Jewel[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(M, V);
		}
		Arrays.sort(jewels);

		W = new int[K];
		for (int i = 0; i < K; i++) {
			W[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(W);

		int idx = 0;
		for (int i = 0; i < K; i++) {
			while (idx < N && W[i] >= jewels[idx].m) {
				pq.offer(jewels[idx++].v);
			}
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);

	}

	static class Jewel implements Comparable<Jewel> {
		int m, v;

		Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			return this.m == o.m ? o.v - this.v : this.m - o.m;
		}
	}
}
