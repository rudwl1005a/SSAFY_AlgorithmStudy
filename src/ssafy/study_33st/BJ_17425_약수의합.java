package ssafy.study_33st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17425 )
 */
public class BJ_17425_약수의합 {

	static int T;
	static final int MAX = 1000001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] sum = new long[MAX]; // 자기보다 작거나 같은 자연수의 f의 총합

		Arrays.fill(sum, 1); // 모든 수는 1을 약수로 가진다
		for (int i = 2; i < MAX; i++) {
			sum[i] += sum[i - 1]; // 이전 수의 총합을 더하고
			// i를 약수로 가지는 수에 +i
			for (int j = 1; j * i < MAX; j++) {
				sum[j * i] += i;
			}
		}

		T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(sum[N]).append("\n");
		}
		System.out.println(sb);
	}

}
