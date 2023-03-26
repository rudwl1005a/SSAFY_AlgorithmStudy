package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1966 )
 */
public class BJ_01966_프린터큐 {

	static int T, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 문서의 개수
			M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 번호

			// 큐에 저장
			Queue<Integer> q = new LinkedList<>(); // 중요도 저장
			Queue<Integer> iq = new LinkedList<>(); // 번호저장

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
				iq.offer(i);
			}

			int cnt = 1; // 출력 순서
			while (!q.isEmpty()) {
				int max = Collections.max(q); // 중요도가 가장 큰 문서 번호
				int cur = q.poll(); // 현재 문서
				int curIdx = iq.poll(); // 현재 번호

				if (cur == max) { // 현재 중요도가 가장 높은 문서라면
					if (curIdx == M) { // 궁금한 문서의 번호라면
						sb.append(cnt).append("\n");
						break;
					}
					cnt++;
				} else { // 중요도가 더 높은 문서가 있다면
					q.offer(cur);
					iq.offer(curIdx);
				}

			}
		}

		System.out.println(sb);
	}
}
