package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1021 )
 */
public class BJ_01021_회전하는큐 {

	static int N, K, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (true) {
				int index = 0; // 몇번쨰 인덱스인지 찾기
				Iterator<Integer> it = dq.iterator();
				while (it.hasNext()) {
					if (it.next() == num) break;
					index++;
				}

				if (index == 0) {
					dq.pollFirst();
					break;
				}

				else if (index > dq.size() / 2) {
					dq.addFirst(dq.removeLast());
					cnt++;
				}

				else {
					dq.addLast(dq.removeFirst());
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}

}
