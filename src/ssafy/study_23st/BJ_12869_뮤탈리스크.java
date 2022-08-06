package ssafy.study_23st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/12869 )
 */
public class BJ_12869_뮤탈리스크 {

	static int N, hp[], dp[][][];
	static final int INF = 10000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		hp = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[61][61][61];
		for (int i = 0; i < 61; i++) {
			for (int j = 0; j < 61; j++) {
				Arrays.fill(dp[i][j], INF);
			}
		}

		System.out.println(attack(hp[0], hp[1], hp[2]));
	}

	private static int attack(int hp0, int hp1, int hp2) {

		// scv 모두 죽었으면
		if (hp0 <= 0 && hp1 <= 0 && hp2 <= 0) {
			return 0;
		}

		// 이미 저장되어있는 값이라면 리턴(무한루프 방지)
		if (dp[hp0][hp1][hp2] != INF) {
			return dp[hp0][hp1][hp2];
		}

		// 때리는 경우의 수 6가지 중 최소값 찾기
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 9), checkZero(hp1, 3), checkZero(hp2, 1)) + 1);
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 9), checkZero(hp1, 1), checkZero(hp2, 3)) + 1);
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 3), checkZero(hp1, 9), checkZero(hp2, 1)) + 1);
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 3), checkZero(hp1, 1), checkZero(hp2, 9)) + 1);
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 1), checkZero(hp1, 9), checkZero(hp2, 3)) + 1);
		dp[hp0][hp1][hp2] = Math.min(dp[hp0][hp1][hp2], attack(checkZero(hp0, 1), checkZero(hp1, 3), checkZero(hp2, 9)) + 1);

		return dp[hp0][hp1][hp2];
	}

	private static int checkZero(int hp, int dam) {
		return hp - dam < 0 ? 0 : hp - dam;
	}

}
