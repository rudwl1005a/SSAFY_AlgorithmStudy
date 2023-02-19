package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1002 )
 */
public class BJ_01002_터렛 {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double dist = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

			if (dist == 0 && r1 == r2) { // 무한히 교차
				sb.append(-1).append("\n");
			} else if (dist > Math.abs(r2 - r1) && dist < r1 + r2) { // 두점에서 교차
				sb.append(2).append("\n");
			} else if (Math.abs(r2 - r1) == dist || r1 + r2 == dist) { // 한점에서 접할 경우
				sb.append(1).append("\n");
			} else if (r1 + r2 < dist || Math.abs(r2 - r1) > dist || dist == 0) { // 교차하지 않을 경우
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}

}
