package ssafy.study_21st;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/20055 )
 */
public class BJ_20055_컨베이어벨트위의로봇 {

	static int N, K, ans, zero;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 벨트 길이
		K = Integer.parseInt(st.nextToken()); // 종료 조건

		belt = new int[2 * N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		robot = new boolean[N];
		while (true) {
			// 0. 단계 증가
			ans++;

			// 1. 벨트 이동
			int tmp = belt[2 * N - 1];
			for (int i = 2 * N - 2; i >= 0; i--) {
				belt[i + 1] = belt[i];
			}
			belt[0] = tmp;

			for (int i = N - 2; i >= 0; i--) { // 로봇도 같이 이동
				robot[i + 1] = robot[i];
			}
			robot[0] = false;

			if (robot[N - 1]) { // 내리는 위치에 로봇 있으면 내림
				robot[N - 1] = false;
			}

			// 2. 로봇 이동
			for (int i = N - 2; i >= 0; i--) {
				if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) { // i번째 칸에 로봇이 있고, 다음칸에 로봇이 없으며 내구도가 0이상일때만 움직임 가능
					robot[i + 1] = true;
					robot[i] = false;
					belt[i + 1]--; // 내구도 감소
					if (belt[i + 1] == 0) {
						zero++;
					}
				}
			}

			if (robot[N - 1]) { // 내리는 위치에 로봇 있으면 내림
				robot[N - 1] = false;
			}

			// 3. 올리는 위치에 로봇 올리기
			if (!robot[0] && belt[0] > 0) { // 올리는 위치에 로봇이 없고 내구도가 0이상이면 로봇 올리기
				robot[0] = true;
				belt[0]--; // 내구도 감소
				if (belt[0] == 0) {
					zero++;
				}
			}

			// 4. 내구도 0인 칸이 K개 이상이면 종료
			if (zero >= K) {
				break;
			}
		}

		System.out.println(ans);

	}

}
