package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/10974 )
 */
public class BJ_10974_모든순열 {

	static int N, arr[];
	static boolean selected[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		selected = new boolean[N];

		perm(0);

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i]) {
				continue;
			}
			arr[cnt] = i + 1;
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}
	}

}
