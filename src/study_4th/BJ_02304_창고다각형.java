package study_4th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 백준 S2 ( https://www.acmicpc.net/problem/2304 )
 */
public class BJ_02304_창고다각형 {

	static int N, maxH, maxL, ans;
	static int[][] pil;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		pil = new int[N][2];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pil[i][0] = Integer.parseInt(st.nextToken()); // 왼쪽 위치 L
			pil[i][1] = Integer.parseInt(st.nextToken()); // 높이 H
		}

		Arrays.sort(pil, new Comparator<int[]>() {
			// 왼쪽 위치를 기준으로 오름차순 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		maxH = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if (maxH < pil[i][1]) { // 높이 제일 높은 곳 index 저장
				maxH = pil[i][1];
				maxL = i;
			}
		}

		// 높이 제일 높은곳 왼쪽부터 제일 높은곳 까지 계산
		for (int i = 0; i < maxL; i++) {
			if (visit[i]) {
				continue;
			}
			for (int j = i + 1; j <= maxL; j++) {
				visit[j - 1] = true;
				if (pil[i][1] <= pil[j][1]) { // 자기보다 높거나 같은 기둥을 만났을 때
					ans += pil[i][1] * (pil[j][0] - pil[i][0]);
					break;
				}
			}
		}

		// 높이 제일 높은곳 계산
		visit[maxL] = true;
		ans += pil[maxL][1];

		// 높이 제일 높은곳 오른쪽부터 제일 높은곳 까지 계산
		for (int i = N - 1; i > maxL; i--) {
			if (visit[i]) {
				continue;
			}
			for (int j = i - 1; j >= maxL; j--) {
				visit[j + 1] = true;
				if (pil[i][1] <= pil[j][1]) { // 자기보다 높거나 같은 기둥을 만났을 때
					ans += pil[i][1] * (pil[i][0] - pil[j][0]);
					break;
				}
			}
		}

		System.out.println(ans);
	}

}
