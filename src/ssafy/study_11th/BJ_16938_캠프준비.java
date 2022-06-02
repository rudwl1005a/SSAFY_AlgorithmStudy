package ssafy.study_11th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/16938 )
 */
public class BJ_16938_캠프준비 {

	static int N, L, R, X, ans;
	static int[] diff;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		diff = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			diff[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int flag, int min, int max) {

		if (cnt >= 2) { // 문제 두문제 이상 풀었을 떄
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					sum += diff[i];
				}
			}

			if (L <= sum && sum <= R && max - min >= X) { // 문제 난이도 합이 L보다 크거나같고 R보다 작거나 같을 때, 난이도 차이 X보다 크거나 같을 때
				ans++;
			}
		}

		if (cnt == N) {
			return;
		}

		for (int i = start; i < N; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}

			comb(cnt + 1, i + 1, flag | 1 << i, Math.min(min, diff[i]), Math.max(max, diff[i]));
		}
	}

}
