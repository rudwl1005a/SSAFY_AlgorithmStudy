package ssafy.study_32nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 S1 ( https://www.acmicpc.net/problem/2841 )
 */
public class BJ_02841_외계인의기타연주 {

	static int N, P, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 멜로디 음의 수
		P = Integer.parseInt(st.nextToken()); // 한줄의 프렛 수

		// 스택 선언 및 초기화
		Stack<Integer>[] stack = new Stack[7];
		for (int x = 0; x < 7; x++) {
			stack[x] = new Stack<Integer>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int line = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());

			// 1. 누를 라인에 현재 프렛보다 큰 수가 없을 때나 빌때까지 pop
			while (!stack[line].isEmpty() && stack[line].peek() > fret) {
				stack[line].pop();
				ans++;
			}

			// 2. 누를 라인에 프렛이 잡혀있지 않거나 현재 프렛보다 작다면 push
			if (stack[line].isEmpty() || stack[line].peek() < fret) {
				stack[line].push(fret);
				ans++;
			}

			// 3. 누를 라인에 프렛이 잡혀있지만 현재 프렛과 같다면 아무것도 안함
		}

		System.out.println(ans);
	}

}
