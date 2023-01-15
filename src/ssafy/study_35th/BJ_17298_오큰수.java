package ssafy.study_35th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 G4 ( https://www.acmicpc.net/problem/17298 )
 */
public class BJ_17298_오큰수 {

	static int N, arr[];
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer> answer = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = N - 1; i >= 0; i--) {
			// 현재 수보다 작거나 같은 수들은 pop, 큰 수를 만나면 오큰수이므로 멈춘다
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				answer.push(-1); // 스택이 비었으면 오큰 수는 없다
			} else {
				answer.push(stack.peek()); // 스택 비어 있지 않으면 오큰수
			}

			// 스택에 현재 값 넣어주기
			stack.push(arr[i]);
		}

		while (!answer.isEmpty()) {
			sb.append(answer.pop()).append(" ");
		}

		System.out.println(sb);
	}

}
