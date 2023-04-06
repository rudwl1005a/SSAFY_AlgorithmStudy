package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/15657 )
 */
public class BJ_15657_N과M8 {

	static int N, M, tgt[], src[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tgt = new int[M];
		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);
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

		for (int i = srcIdx; i < N; i++) {
			tgt[tgtIdx] = src[i];
			solve(tgtIdx + 1, i);
		}
	}

}
