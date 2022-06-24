package ssafy.study_18th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 백준 G5 ( https://www.acmicpc.net/problem/2056 )
 */
public class BJ_02056_작업 {

	static int N, max;
	static int[] indegree, time;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 작업 개수
		time = new int[N + 1];
		indegree = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken()); // 작업 시간 저장
			time[i] = t;
			
			int n = Integer.parseInt(st.nextToken()); // 선행 관계 작업 수
			indegree[i] = n;
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				list[num].add(i);
			}
		}
		max = Integer.MIN_VALUE;
		
		topologicalSort();
		
		System.out.println(max);
	}

	private static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N+1];
		
		// 선행 작업이 없는 작업
		for (int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				result[i] = time[i];
				q.offer(i);
				max = Math.max(max, result[i]);
			}
		}
		
		// 선행 작업이 있는 작업
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i : list[node]) {
				result[i] = Math.max(result[i], result[node] + time[i]);
				indegree[i]--;
				
				if(indegree[i] == 0) {
					q.offer(i);
					max = Math.max(max, result[i]);
				}
			}
		}
	}
}
