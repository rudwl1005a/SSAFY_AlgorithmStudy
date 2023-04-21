package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 백준 S3 ( https://www.acmicpc.net/problem/1935 )
 */
public class BJ_01945_후위표기식2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Double> operand = new Stack<>();
		int len = input.length();
		for (int i = 0; i < len; i++) {
			char ch = input.charAt(i);
			if ('A' <= ch && ch <= 'Z') { // operand
				double d = arr[ch - 'A'];
				operand.push(d);
			} else { // operator
				double d1 = operand.pop();
				double d2 = operand.pop();
				double d3 = 0.0;
				switch (ch) {
				case '+':
					d3 = d2 + d1;
					break;
				case '-':
					d3 = d2 - d1;
					break;
				case '*':
					d3 = d2 * d1;
					break;
				case '/':
					d3 = d2 / d1;
					break;
				}
				operand.push(d3);
			}
		}
		System.out.printf("%.2f", operand.pop());
	}

}
