package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2012 )
 */
public class BJ_02012_등수매기기 {

	static int N, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long ans = 0;
		Arrays.sort(arr);

		for (int i = 1; i <= N; i++) {
			ans += Math.abs(arr[i] - i);
		}

		System.out.println(ans);
	}

}
