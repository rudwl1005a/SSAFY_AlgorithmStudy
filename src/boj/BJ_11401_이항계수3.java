package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G1 ( https://www.acmicpc.net/problem/11401 )
 */
public class BJ_11401_이항계수3 {

	static int T, N, R;
	static final int P = 1000000007;
	static long[] fac;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		System.out.println(nCr(N, R, P));
	}

	private static long nCr(int n, int r, int p) {
		if (r == 0) {
			return 1L;
		}

		fac = new long[n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++) {
			fac[i] = fac[i - 1] * i % p;
		}

		return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
	}

	private static long power(long x, int y, int p) {
		long res = 1L;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1) {
				res = (res * x) % p;
			}
			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}
}
