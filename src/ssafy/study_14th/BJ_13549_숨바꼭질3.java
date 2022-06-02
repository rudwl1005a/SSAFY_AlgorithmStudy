package ssafy.study_14th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/13549 )
 */
public class BJ_13549_숨바꼭질3 {

	static int N, K;
	static final int INF = 100001;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[100001];

		Arrays.fill(dist, INF);
		dist[N] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.offer(N);

		while (!q.isEmpty()) {
			int n = q.poll();

			if (n == K) {
				System.out.println(dist[n]);
				return;
			}

			// n-1로 이동
			if (n - 1 >= 0 && dist[n - 1] >= dist[n] + 1) {
				dist[n - 1] = dist[n] + 1;
				q.offer(n - 1);
			}

			// n+1로 이동
			if (n + 1 <= 100000 && dist[n + 1] >= dist[n] + 1) {
				dist[n + 1] = dist[n] + 1;
				q.offer(n + 1);
			}

			// 2*n으로 순간이동
			if (n * 2 <= 100000 && dist[2 * n] >= dist[n]) {
				dist[2 * n] = dist[n];
				q.offer(2 * n);
			}
		}
	}

}
