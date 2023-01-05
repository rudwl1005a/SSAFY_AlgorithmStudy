package ssafy.study_33th;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2023 )
 */
public class BJ_02023_신기한소수 {

	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		solve(0, 0);
		System.out.println(sb);
	}

	// 한 자리수씩 늘려가면서 소수인지 판별
	private static void solve(int n, int cnt) {
		if (cnt == N) { // 자리수가 N이라면 정답 중 하나
			sb.append(n).append("\n");
			return;
		}

		for (int i = 1; i < 10; i++) {
			int temp = n * 10 + i;
			if (isPrime(temp)) solve(temp, cnt + 1); // 소수라면 진행, 아니라면 진행x
		}
	}

	// 에라토스테네스의 체 소수판별
	private static boolean isPrime(int num) {
		if (num == 1) return false;

		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
