package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/13305 )
 */
public class BJ_13305_주유소 {

	static int N;
	static long length[], price[], sum, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		length = new long[N - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Long.parseLong(st.nextToken());
		}

		price = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Long.parseLong(st.nextToken());
		}

		min = price[0];
		for (int i = 0; i < N - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			}
			sum += (min * length[i]);
		}

		System.out.println(sum);
	}

}
