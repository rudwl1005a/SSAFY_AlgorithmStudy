package study_8th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1644 )
 */
public class BJ_01644_소수의연속합 {

	static int N, ans, sum;
	static ArrayList<Integer> prime = new ArrayList<>();
	static boolean[] pCheck;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		primeCheck();
		sumCount();

		System.out.println(ans);
	}

	private static void sumCount() {
		int start = 0;
		int end = 0;
		while (true) {
			if (sum >= N) {
				sum -= prime.get(start++);
			} else if (end == prime.size()) {
				break;
			} else {
				sum += prime.get(end++);
			}

			if (sum == N) {
				ans++;
			}

		}
	}

	private static void primeCheck() {
		pCheck = new boolean[N + 1];
		
		// 에라토스테네스의 체
		for (int i = 2; i * i < N + 1; i++) {
			if (!pCheck[i]) {
				for (int j = i * i; j < N + 1; j += i) {
					pCheck[j] = true;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (!pCheck[i]) {
				prime.add(i);
			}
		}
	}

}
