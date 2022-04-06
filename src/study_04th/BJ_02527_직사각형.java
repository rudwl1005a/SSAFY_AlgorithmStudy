package study_04th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2527 )
 */
public class BJ_02527_직사각형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			if (x2 > p1 || y2 > q1 || p2 < x1 || q2 < y1) {
				System.out.println("d");
			} else {
				if(x1 == p2) { // 면 하나 겹치면 선분이거나 점
					if(y1 == q2 || q1 == y2) { // 점
						System.out.println("c");
					} else { // 면
						System.out.println("b");
					}
				} else if(y1 == q2) {
					if(x1 == p2 || p1 == x2) {
						System.out.println("c");
					} else {
						System.out.println("b");
					}
				} else if(p1 == x2) {
					if(q1 == y2 || y1 == q2) {
						System.out.println("c");
					} else {
						System.out.println("b");
					}
				} else if(q1 == y2) {
					if(x1 == p2 || p1 == x2) {
						System.out.println("c");
					} else {
						System.out.println("b");
					}
				} else { // 여기 까지 오면 겹친 부분 직사각형
					System.out.println("a");
				}
			}

		}
	}
}