package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_02407_조합 {

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		BigInteger sum = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;

		// nCm = n!m! / (n-m)!
		for (int i = 0; i < M; i++) {
			sum = sum.multiply(new BigInteger(String.valueOf(N - i)));
			div = div.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		System.out.println(sum.divide(div));
	}

}
