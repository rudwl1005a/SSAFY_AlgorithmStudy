package ssafy.study_27th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1111 )
 */
public class BJ_01111_IQTest {

	static int N, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 1 || (N == 2 && arr[0] != arr[1])) {
			sb.append("A");
		} else if (N == 2) {
			sb.append(arr[0] + "");
		} else {
			int a, b;
			if (arr[1] == arr[0]) {
				a = 1;
				b = 0;
			} else {
				a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
				b = arr[1] - (arr[0] * a);
			}

			// 유효성 체크
			int i = 1;
			for (; i < N; i++) {
				if (arr[i] != (arr[i - 1] * a + b)) {
					break;
				}
			}
			if (i != N) {
				sb.append("B");
			} else {
				sb.append((arr[N - 1] * a + b) + "");
			}
		}

		System.out.println(sb);
	}
}
