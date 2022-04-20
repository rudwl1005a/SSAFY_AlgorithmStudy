package study_12th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 백준 G3 ( https://www.acmicpc.net/problem/1918 )
 */
public class BJ_01918_후위표기식 {

	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ('A' <= c && c <= 'Z') { // 알파벳이면 바로 출력
				sb.append(c);
			} else if (c == '*' || c == '/') { // 스택에 있는 '(', '+', '-' 찾을때까지 pop하여 출력하고 스택에 넣기
				while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-') {
					sb.append(stack.pop());
				}
				stack.push(c);
			} else if (c == '+' || c == '-') { // 스택에 있는 '(' 찾을때 까지 pop하여 출력하고 스택에 넣기
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.push(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') { // '(' 찾을때 까지 pop하여 출력
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop(); // '('꺼내기
			}
		}

		// 나머지 스택 출력하기
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb);

	}

}
