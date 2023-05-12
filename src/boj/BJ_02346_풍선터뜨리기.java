package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/2346 )
 */
public class BJ_02346_풍선터뜨리기 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int move = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			deque.add(new int[] { i, Integer.parseInt(st.nextToken()) });
		}

		sb.append("1 ");
		while (!deque.isEmpty()) {
			if (move > 0) {
				for (int i = 1; i < move; i++) {
					deque.add(deque.pollFirst());
				}
				int[] next = deque.removeFirst();
				move = next[1];
				sb.append(next[0]).append(" ");
			} else {
				for (int i = move; i < -1; i++) {
					deque.addFirst(deque.pollLast());
				}
				int[] next = deque.removeLast();
				move = next[1];
				sb.append(next[0]).append(" ");
			}
		}

		System.out.println(sb);

	}

}
