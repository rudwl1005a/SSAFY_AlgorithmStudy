package ssafy.study_30th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17208 )
 */
public class BJ_17208_카우버거알바생 {

	static int N, M, K, dp[][][];
	static Order[] order;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 주문의 수
		M = Integer.parseInt(st.nextToken()); // 치즈버거
		K = Integer.parseInt(st.nextToken()); // 감자튀김

		// dp[남은 치즈버거 수][남은 감자튀김 수][주문번호]
		dp = new int[M + 1][K + 1][N + 1];
		order = new Order[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int burger = Integer.parseInt(st.nextToken());
			int fries = Integer.parseInt(st.nextToken());

			order[i] = new Order(burger, fries);
		}

		// -1로 초기화
		for (int i = 0; i < M + 1; i++) {
			for (int j = 0; j < K + 1; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		System.out.println(solve(M, K, 0));

	}

	private static int solve(int b, int f, int cnt) {
		if (cnt == N) return 0; // 주문번호 끝났으면 리턴
		if (dp[b][f][cnt] > -1) return dp[b][f][cnt]; // 이미 확인한 것이였으면 리턴

		int result = 0;
		// cnt+1번째 주문 받음
		if (order[cnt + 1].burger <= b && order[cnt + 1].fries <= f) {
			result = solve(b - order[cnt + 1].burger, f - order[cnt + 1].fries, cnt + 1) + 1;
		}

		// cnt+1번째 주문 받은것과 안받은것의 max값 저장
		dp[b][f][cnt] = Math.max(result, solve(b, f, cnt + 1));

		return dp[b][f][cnt];
	}

	public static class Order {
		int burger, fries;

		public Order(int burger, int fries) {
			super();
			this.burger = burger;
			this.fries = fries;
		}

	}

}
