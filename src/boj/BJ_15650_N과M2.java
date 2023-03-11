package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/15650 )
 */
public class BJ_15650_N과M2 {

	static int N, M, tgt[];
	static boolean select[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tgt = new int[M];
		select = new boolean[N + 1];
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

		for (int i = srcIdx + 1; i <= N; i++) {
			if (select[i]) continue;
			tgt[tgtIdx] = i;
			select[i] = true;
			solve(tgtIdx + 1, i);
			select[i] = false;
		}
	}

}
