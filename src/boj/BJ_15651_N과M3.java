package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/15651 )
 */
public class BJ_15651_N과M3 {

	static int N, M, tgt[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tgt = new int[M];
		solve(0, 0);

		System.out.println(sb);
	}

	private static void solve(int tgtIdx, int srcIdx) {
		if (tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(tgt[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			tgt[tgtIdx] = i;
			solve(tgtIdx + 1, i);
		}
	}

}
