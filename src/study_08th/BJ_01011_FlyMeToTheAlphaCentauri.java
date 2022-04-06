package study_08th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/1011 )
 */
public class BJ_01011_FlyMeToTheAlphaCentauri {

	static int T, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int dis = (y - x);
			int move = (int) Math.sqrt(dis);

			if (dis == move * move) {
				System.out.println(move * 2 - 1);
			} else if (dis - (move * move) <= move) {
				System.out.println(move * 2);
			} else if (dis - (move * move) > move) {
				System.out.println(move * 2 + 1);
			}
		}
	}

}
