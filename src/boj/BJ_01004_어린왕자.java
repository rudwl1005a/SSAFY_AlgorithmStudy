package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1004 )
 */
public class BJ_01004_어린왕자 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 출발점
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()); // 도착점
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine()); // 행성계수

			int ans = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				// 시작점이 행성 안에 있는지 판별 (안에 있으면 false, 밖에 있으면 true)
				boolean flag1 = false;
				// 도착점이 행성 안에 있는지 판별
				boolean flag2 = false;

				// 피타고라스 생각했을 때 r이 빗변 -> 우변이 좌변보다 작은 경우에 행성 밖에 있는 경우
				if (Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2) > Math.pow(r, 2)) flag1 = true;
				if (Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2) > Math.pow(r, 2)) flag2 = true;

				// 시작점과 도착점이 다른 곳에 있는 경우에 시작점 -> 도착점으로 갈 때 경계선을 지나기 때문에 answer을 더해준다
				if (flag1 != flag2) ans++;
			}
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
	}

}
