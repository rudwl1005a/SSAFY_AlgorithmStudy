package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/10973 )
 */
public class BJ_10973_이전순열 {

	static int N, input[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		if (nextPermutation()) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i] + " ");
			}
		} else {
			System.out.println("-1");
		}
	}

	private static boolean nextPermutation() {
		int i = input.length - 1;
		while (i > 0 && input[i - 1] <= input[i]) {
			i--;
		}
		if (i <= 0) {
			return false;
		}

		int j = input.length - 1;
		while (input[j] >= input[i - 1]) {
			j--;
		}

		swap(i - 1, j);
		j = input.length - 1;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}
		return true;
	}

	private static void swap(int idx1, int idx2) {
		int temp = input[idx1];
		input[idx1] = input[idx2];
		input[idx2] = temp;
	}

}
