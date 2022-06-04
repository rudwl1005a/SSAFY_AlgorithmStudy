package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2166 )
 */
public class BJ_02166_다각형의면적 {

	static int N;
	static long sum1, sum2;
	static long[] x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		x = new long[N + 1];
		y = new long[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		x[N] = x[0];
		y[N] = y[0];

		for (int i = 0; i < N; i++) {
			sum1 += x[i] * y[i + 1];
			sum2 += y[i] * x[i + 1];
		}
		
		System.out.printf("%.1f", (Math.abs(sum1 - sum2) / 2.0));
	}

}
