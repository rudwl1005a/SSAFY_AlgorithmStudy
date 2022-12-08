package ssafy.study_19th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/2812 )
 */
public class BJ_02812_크게만들기 {

	static int N, K, len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		len = N - K;

		Stack<Character> stack = new Stack<>();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			if (!stack.empty()) {
				// stack.peek() 이 현재 값보다 작고 && K > 0 (아직 뺄 수 있다 ) 면 pop()
				while (!stack.empty() && K > 0 && stack.peek() < str.charAt(i)) {
					stack.pop();
					K--;
				}
			}

			stack.push(str.charAt(i));
		}

		while (true) {
			if (stack.size() == len) {
				break;
			}

			stack.pop();
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.reverse().toString());

	}

}
