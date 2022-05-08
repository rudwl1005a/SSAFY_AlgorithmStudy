package study_14th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/1043 )
 */
public class BJ_01043_거짓말_fail {

	static int N, M, T, ans;
	static long truth;
	static long[] partyPeople;
	static boolean[] party;

	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(st.nextToken());
			truth |= 1 << n;
			q.offer(n);
		}

		partyPeople = new long[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int m = Integer.parseInt(st.nextToken());
				partyPeople[i] |= 1 << m;
			}
		}

		party = new boolean[M];
		ans = M;
		while (!q.isEmpty()) {
			int n = q.poll();
			for (int i = 0; i < M; i++) {
				if (party[i] || (partyPeople[i] & 1 << n) == 0) { // 파티가 이미 체크되었거나, 파티에 현재 사람이 없을 경우 continue
					continue;
				}
				for (int j = 1; j <= N; j++) {
					if ((truth & 1 << j) != 0 || (partyPeople[i] & 1 << j) == 0) { // 진실을 알고 있거나 파티에 없는 사람인 경우
						continue;
					}
					truth |= 1 << j;
					q.offer(j);
				}
				
				party[i] = true;
				ans--;
			}
		}
		
		System.out.println(ans);

	}

}
