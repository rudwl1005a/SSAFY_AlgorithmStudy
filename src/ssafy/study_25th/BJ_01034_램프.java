package ssafy.study_25th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1034 )
 */
public class BJ_01034_램프 {

	static int N, M, K, ans;
	static String[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new String[N];
		for (int i = 0; i < N; i++) {
			line[i] = br.readLine();
		}
		K = Integer.parseInt(br.readLine()); // 스위치 누르는 횟수
		boolean isEven = K % 2 == 0 ? true : false;
		if (K > 50) K = 50; // 스위치는 최대 50번까지 누를 수 있다

		int idx = -1;
		for (int i = 0; i < N; i++) {
			// 0개수 확인
			int zeroNum = 0;
			for (int j = 0; j < M; j++) {
				if (line[i].charAt(j) == '0') zeroNum++;
			}
			// 짝수 홀수 확인
			if ((zeroNum % 2 == 0 && !isEven) || (zeroNum % 2 != 0 && isEven)) continue;
			// 같은 종류 확인
			int same = 1;
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (line[i].equals(line[j])) same++;
			}
			// 0개수는 K개 이하여야 한다
			if (zeroNum <= K && same > ans) {
				ans = same;
				idx = i;
			}
		}
		
		System.out.println(idx == -1 ? 0 : ans);

	}

}
