package ssafy.study_08th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/14719 )
 */
public class BJ_14719_빗물 {

	static int H, W, maxH, maxW, ans;
	static int[] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[W];

		st = new StringTokenizer(br.readLine());
		maxH = Integer.MIN_VALUE;
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if (maxH < map[i]) {
				maxH = map[i];
				maxW = i;
			}
		}

		// 왼쪽에서 제일 높은곳까지
		int prev = map[0];
		int rain = 0;
		for (int i = 1; i <= maxW; i++) {
			if (i >= W) {
				break;
			}
			if (prev <= map[i]) {
				ans += rain;
				rain = 0;
				prev = map[i];
			} else {
				rain += (prev - map[i]);
			}
		}

		// 오른쪽에서 제일 높은 곳 까지
		int next = map[W - 1];
		rain = 0;
		for (int i = W - 2; i >= maxW; i--) {
			if (i < 0) {
				break;
			}
			if (next <= map[i]) {
				ans += rain;
				rain = 0;
				next = map[i];
			} else {
				rain += (next - map[i]);
			}
		}

		System.out.println(ans);
	}

}
