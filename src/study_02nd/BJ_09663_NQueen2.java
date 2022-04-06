package study_02nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 골드5 ( https://www.acmicpc.net/problem/9663 )
 * 민철님 코드
 * 메모리 : 14716KB, 시간: 2648ms
 */
public class BJ_09663_NQueen2 {
	static boolean[] 열, 대각1, 대각2;
	static int[] 행;
	static int N, count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		행 = new int[N];
		열 = new boolean[N];
		대각1 = new boolean[2 * N - 1];
		대각2 = new boolean[2 * N - 1];
		count = 0;

		for (int i = 0; i < N; i++)
			열[i] = true;
		for (int i = 0; i < (N * 2 - 1); i++) {
			대각1[i] = 대각2[i] = true;
		}
		set(0, N);
		System.out.println(count);

	}

	static void set(int i, int N) {

		for (int j = 0; j < N; j++) {
			if (열[j] && 대각1[i + j] && 대각2[i - j + (N - 1)]) { // 대각선 체크하면서 알아서 행이 체크 o
//				행[i] = j;
				if (i == N - 1)
					count++;
				else {
					열[j] = 대각1[i + j] = 대각2[i - j + (N - 1)] = false;
					set(i + 1, N);
					열[j] = 대각1[i + j] = 대각2[i - j + (N - 1)] = true;
				}
			}
		}
	}
}