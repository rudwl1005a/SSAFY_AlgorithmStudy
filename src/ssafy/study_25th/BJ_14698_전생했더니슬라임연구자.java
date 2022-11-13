package ssafy.study_25th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/14698 )
 */
public class BJ_14698_전생했더니슬라임연구자 {

	static int T, N;
	static final long MOD = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순 기준으로 정렬.

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				long energy = Long.parseLong(st.nextToken());
				pq.offer(energy);
			}

			long ans = 1;

			// 오버플로우 발생하지 않도록 MOD 연산을 잘 해주어야 함.
			while (pq.size() > 1) {
				long p1 = pq.poll();
				long p2 = pq.poll();
				long temp = p1 * p2;

				ans *= temp % MOD;
				ans %= MOD;

				pq.offer(temp);
			}

			sb.append(ans + "\n");
		}

		System.out.println(sb);
	}
}
