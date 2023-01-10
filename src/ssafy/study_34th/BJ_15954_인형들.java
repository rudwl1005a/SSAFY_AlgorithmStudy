package ssafy.study_34th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/15954 )
 */
public class BJ_15954_인형들 {

	static int N, K, arr[];
	static double min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값 계산
		min = solve(0, K);

		// 표준편차 계산하여 최소값 갱신
		for (int i = 0; i <= N - K; i++) {
			for (int j = K; i + j <= N; j++) { // K이상 N이하만큼 계산
				min = Math.min(min, solve(i, j));
			}
		}

		System.out.println(min);
	}

	private static double solve(int start, int count) {
		// 평균 구하기
		double sum = 0;
		for (int i = start; i < start + count; i++) {
			sum += arr[i];
		}
		double m = sum / count;
		
		// 분산 구하기
		sum = 0;
		for (int i = start; i < start + count; i++) {
			sum += (arr[i] - m) * (arr[i] - m);
		}
		return Math.sqrt(sum / count);
	}

}
