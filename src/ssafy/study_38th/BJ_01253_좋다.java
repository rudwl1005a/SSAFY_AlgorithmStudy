package ssafy.study_38th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1253 )
 */
public class BJ_01253_좋다 {

	static int N, ans, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr); // 오름차순으로 정렬

		// 투포인터
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			while (left <= right) {
				// 다른 두 수이기 때문에 left나 right가 i면 안된다
				if (left == i) left++;
				if (right == i) right--;
				if (left == right) break;

				if (arr[left] + arr[right] < arr[i]) { // 두 합이 현재 수보다 작으면 left++해서 합을 크게 만들어줌
					left++;
				} else if (arr[left] + arr[right] > arr[i]) { // 크면 right--해서 합을 작게 만들어줌
					right--;
				} else { // 같으면 좋은 수
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
