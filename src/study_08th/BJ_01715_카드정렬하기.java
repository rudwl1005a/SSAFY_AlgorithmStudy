package study_08th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1715 )
 */
public class BJ_01715_카드정렬하기 {

	static int N, ans;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(Integer.parseInt(st.nextToken()));
		}

		while (!pq.isEmpty()) {
			int n1 = pq.poll();
			if (pq.isEmpty()) {
				break;
			}
			int n2 = pq.poll();
			pq.offer(n1 + n2);
			ans += n1 + n2;
		}

		System.out.println(ans);
	}

}