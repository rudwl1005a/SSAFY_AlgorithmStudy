package ssafy.study_33th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2293 )
 */
public class BJ_02293_동전1 {

	static int N, K, coin[], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coin = new int[N];
		dp = new int[K + 1];

		// 코인 종류 저장
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		// 저장된 코인 종류로 만들 수 있는 K이하의 경우의 수 저장
		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				dp[j] += dp[j - coin[i]];
			}
		}

		// 저장된 코인 종류로 만들 수 있는 K의 경우의 수 출력
		System.out.println(dp[K]);

	}

}
