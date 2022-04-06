package study_07th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/14233 )
 */
public class BJ_14233_악덕사장 {

	static int N;
	static long min;
	static long[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		min = Long.MAX_VALUE;
		N = Integer.parseInt(br.readLine());
		arr = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		for (int i = 1; i <= N; i++) {
			min = Math.min(arr[i]/i, min);
		}

		System.out.println(min);
	}

}
