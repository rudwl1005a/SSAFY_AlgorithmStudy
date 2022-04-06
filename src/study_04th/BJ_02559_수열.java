package study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2559 )
 */
public class BJ_02559_수열 {
	
	static int N, K, max;
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 날짜 수
		K = Integer.parseInt(st.nextToken()); // 연속으로 측정할 날짜 수
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 초기 합
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += num[i];
		}
		max = sum;
		
		for (int i = K; i < N; i++) {
			sum += num[i] - num[i-K]; // 맨앞의 수는 빼고 다음수를 더한다.
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}

}
