package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/19637 )
 */
public class BJ_19637_IF문좀대신써줘 {

	static int N, M, power[];
	static String title[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		M = Integer.parseInt(st.nextToken()); // 캐릭터의 개수

		power = new int[N]; // 전투력
		title = new String[N]; // 칭호

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int p = Integer.parseInt(br.readLine()); // 캐릭터의 전투력

			// 이분 탐색
			int left = 0;
			int right = N - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (p > power[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			
			sb.append(title[right + 1]).append("\n");
		}

		System.out.println(sb);
	}

}
