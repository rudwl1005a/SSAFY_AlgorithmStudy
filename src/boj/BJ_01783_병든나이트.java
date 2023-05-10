package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1783 )
 */
public class BJ_01783_병든나이트 {

	static int N, M, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (N == 1) { // 세로 1칸 -> 이동x
			cnt = 1;
		} else if (N == 2) { // 세로 2칸 -> 2,3 가능
			cnt = Math.min((M + 1) / 2, 4);
		} else { // 세로 3칸 이상 -> 전부 이동가능
			if (M < 7) {
				cnt = Math.min(M, 4);
			} else {
				cnt = M - 2;
			}
		}
		System.out.println(cnt);
	}

}
