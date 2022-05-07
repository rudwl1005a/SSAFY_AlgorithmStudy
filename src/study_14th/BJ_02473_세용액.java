package study_14th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/2473 )
 */
public class BJ_02473_세용액 {

	static int N;
	static long[] fluid, result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		fluid = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fluid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fluid);
		result = new long[3];
		long cha = Long.MAX_VALUE;

		// 가장 왼쪽부터 시작해서 가장 오른쪽 끝까지
		for (int i = 0; i < N; i++) {
			int left = i + 1; // 가장 왼쪽을 제외하고 그 다음부터 순회
			int right = N - 1;

			while (left < right) {
				// 세 용액의 합 계산
				long sum = fluid[i] + fluid[left] + fluid[right];

				// 차이 계산
				long chaNow = Math.abs(sum);

				// 차이가 더 작다면 원소 저장
				if (chaNow < cha) {
					cha = chaNow;
					result[0] = fluid[i];
					result[1] = fluid[left];
					result[2] = fluid[right];
				}

				if (sum > 0) { // 차이가 0보다 크다. 오른쪽 원소를 한 칸 앞으로
					right--;
				} else { // 차이가 0보다 작다. 왼쪽 원소를 한 칸 앞으로
					left++;
				}
			}
		}
		
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}
}
