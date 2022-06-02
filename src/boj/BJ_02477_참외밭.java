package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S4 ( https://www.acmicpc.net/problem/2477 )
 */
public class BJ_02477_참외밭 {

	static int N, ans; // N : 단위면적 밭의 참외 개수
	static int[][] length;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		length = new int[13][2]; // 길이, 사방 저장 -> 두번 저장 0은 더미

		for (int i = 1; i < 7; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			length[i][0] = length[i + 6][0] = dir;
			length[i][1] = length[i + 6][1] = len;
		}

		// 배열에서 두번씩 나오는 방향이 나란히 4개가 있을 경우 중간 두개가 서로 곱해서 더하면 안되는 것들이다.
		// 서로 짝이 되어 곱해서 더하면 답이다.
		for (int i = 1; i < 10; i++) {
			if (length[i][0] == length[i + 2][0]) {
				if (length[i + 1][0] == length[i + 3][0]) {
					ans = (length[i][1] * length[i + 1][1]
							+ length[i + 2][1] * length[i + 3][1]
							+ length[i][1] * length[i + 3][1]) * N;
				}
			}
		}

		System.out.println(ans);
	}

}
