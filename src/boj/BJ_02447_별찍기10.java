package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2447 )
 */
public class BJ_02447_별찍기10 {

	static int N;
	static String map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new String[N][N];

		star(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// null이면 빈칸, 아니면 * 출력
				sb.append(map[i][j] == null ? " " : map[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	private static void star(int y, int x, int n) {
		// 기저조건(최소단위)
		if (n == 1) {
			map[y][x] = "*";
			return;
		}

		// 3*3 크기로 쪼개기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) { // 가운데만 null 상태로 비워놓기
					star(y + i * n / 3, x + j * n / 3, n / 3);
				}
			}
		}

	}

}
