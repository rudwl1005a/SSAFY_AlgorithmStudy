package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1051 )
 */
public class BJ_01051_숫자정사각형 {

	static int N, M, arr[][], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		int MIN = Math.min(N, M);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < MIN; k++) {
					if (i + k < N && j + k < M) { // 배열 범위 이내
						// 4개의 꼭짓점이 정사각형이 되는 조건
						if (arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i + k][j + k]) {
							max = Math.max(max, (k + 1) * (k + 1));
						}
					}
				}
			}
		}

		System.out.println(max);
	}

}
