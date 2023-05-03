package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2503 )
 */
public class BJ_02503_숫자야구 {

	static int N;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		check = new boolean[1000];

		// 가능한 정답의 경우 check 배열을 true로, 가능하지 않은 경우 false로 설정
		for (int i = 123; i < 1000; i++) {
			String str = Integer.toString(i);

			// 문제에 따르면 숫자 내부에 0이 있을 경우는 정답으로 가능하지 않으므로 제외
			if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0')
				continue;

			// 문제에 따르면 모든 자릿수의 숫자가 달라야 하기 때문에 같은 숫자가 있을 경우 제외
			if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
				continue;
			check[i] = true;
		}

		for (int i = 0; i < N; i++) {
			// 입력받은 값과 정답과의 스트라이크와 볼 값
			st = new StringTokenizer(br.readLine());
			int req = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 예상 가능한 모든 정답을 탐색
			for (int ans = 123; ans < 1000; ans++) {
				// 만약 정답 가능성이 있는 수라면
				if (check[ans]) {
					int ns = 0;
					int nb = 0;

					// 정답 가능성이 있는 수와 입력받은 수와 스트라이크와 볼 비교
					// 이 때 입력받은 수, 정답 가능성이 있는 수 각각을 반복문을 돌려 각 자리수와 값을 비교
					for (int first = 0; first < 3; first++) {
						char req_split = Integer.toString(req).charAt(first);

						for (int second = 0; second < 3; second++) {
							char ans_split = Integer.toString(ans).charAt(second);

							// 자리수도 같고 값도 같다면 스트라이크
							// 자리수는 다른데 값은 같다면 볼
							if (req_split == ans_split && first == second)
								ns++;
							else if (req_split == ans_split && first != second)
								nb++;
						}
					}

					// 입력받은 스트라이크, 볼 값과 계산한 값이 같다면 정답 가능성이 있는 수
					if (ns == s && nb == b) {
						check[ans] = true;
					}
					// 아니라면 제외
					else {
						check[ans] = false;
					}
				}
			}
		}

		// 정답 가능성이 있는 수를 세서 카운트 및 출력
		int ans = 0;
		for (int i = 123; i < 1000; i++) {
			if (check[i])
				ans++;
		}

		System.out.println(ans);
	}
}
