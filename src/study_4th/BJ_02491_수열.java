package study_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2491 )
 */
public class BJ_02491_수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 1;
		int cnt = 1;
		// 오름차순인것만 계산
		for (int i = 0; i < N - 1; i++) {
			if(arr[i] <= arr[i + 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			max = Math.max(max, cnt);
		}

		// 내림차순인것만 계산
		cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if(arr[i] >= arr[i + 1]) {
				cnt++;
			} else {
				max = Math.max(max, cnt);
				cnt = 1;
			}
			max = Math.max(max, cnt);
		}
		
		System.out.println(max);
	}

}
