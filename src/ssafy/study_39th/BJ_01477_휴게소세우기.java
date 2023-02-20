package ssafy.study_39th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1477 )
 */
public class BJ_01477_휴게소세우기 {

	static int N, M, L, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 기존 휴게소의 개수
		M = Integer.parseInt(st.nextToken()); // 추가할 휴게소의 개수
		L = Integer.parseInt(st.nextToken()); // 고속도로 길이

		arr = new int[N + 2]; // 기존 휴게소의 위치
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 고속도로의 시작과 끝 저장
		arr[0] = 0;
		arr[N + 1] = L;
		Arrays.sort(arr);

		int left = 1;
		int right = L - 1;
		while (left <= right) {
			int mid = (left + right) / 2; // 새로 만들 휴게소의 거리

			// 휴게소 사이에 mid거리만큼 몇개를 세울 수 있는지 확인
			int sum = 0;
			for (int i = 1; i < N + 2; i++) {
				sum += (arr[i] - arr[i - 1] - 1) / mid;
			}

			if (sum > M) { // M개 보다 더 많이 세웠으면 거리를 좀더 크게
				left = mid + 1;
			} else { // M개 세울 수 없으면 거리를 좀더 작게
				right = mid - 1;
			}
		}

		System.out.println(left); // 최소값 출력
	}

}
