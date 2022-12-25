package ssafy.study_20th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2174 )
 */
public class BJ_02174_로봇시뮬레이션 {

	static int A, B, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[B + 1][A + 1];

		Robot[] arr = new Robot[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			arr[i] = new Robot(r, c, dir.charAt(0));
			map[r][c] = i + 1;

		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			String com = st.nextToken();
			int re = Integer.parseInt(st.nextToken());

			// 앞으로 이동
			if (com.charAt(0) == 'F') {
				int nowR = arr[idx - 1].r;
				int nowC = arr[idx - 1].c;
				char nowDir = arr[idx - 1].dir;
				map[nowR][nowC] = 0;

				for (int j = 0; j < re; j++) {
					// System.out.println(nowR+" "+nowC);
					if (nowDir == 'N') {
						nowR++;
					} else if (nowDir == 'W') {
						nowC--;
					} else if (nowDir == 'E') {
						nowC++;
					} else if (nowDir == 'S') {
						nowR--;
					}

					// 벽에 충돌!
					if (nowR <= 0 || nowR > B || nowC <= 0 || nowC > A) {
						System.out.println("Robot " + idx + " crashes into the wall");
						return;
					}
					// 다른 로봇과 충돌!
					else if (map[nowR][nowC] != 0) {
						System.out.println("Robot " + idx + " crashes into robot " + map[nowR][nowC]);
						return;
					}

				}
				map[nowR][nowC] = idx;
				arr[idx - 1].r = nowR;
				arr[idx - 1].c = nowC;
			}

			// 왼쪽 회전
			else if (com.charAt(0) == 'L') {
				int change = re % 4;
				for (int j = 0; j < re; j++) {
					char nowDir = arr[idx - 1].dir;
					if (nowDir == 'N') {
						arr[idx - 1].dir = 'W';
					} else if (nowDir == 'W') {
						arr[idx - 1].dir = 'S';
					} else if (nowDir == 'E') {
						arr[idx - 1].dir = 'N';
					} else if (nowDir == 'S') {
						arr[idx - 1].dir = 'E';
					}
				}
			}
			// 오른쪽 회전
			else if (com.charAt(0) == 'R') {
				int change = re % 4;
				for (int j = 0; j < change; j++) {
					char nowDir = arr[idx - 1].dir;
					if (nowDir == 'N') {
						arr[idx - 1].dir = 'E';
					} else if (nowDir == 'W') {
						arr[idx - 1].dir = 'N';
					} else if (nowDir == 'E') {
						arr[idx - 1].dir = 'S';
					} else if (nowDir == 'S') {
						arr[idx - 1].dir = 'W';
					}
				}
			}
		}

		System.out.println("OK");

	}

	public static class Robot {
		int r, c;
		char dir;

		Robot(int r, int c, char dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;

		}
	}
}
