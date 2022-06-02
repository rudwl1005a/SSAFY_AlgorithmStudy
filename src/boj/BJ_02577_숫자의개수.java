package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B2 ( https://www.acmicpc.net/problem/2577 )
 */
public class BJ_02577_숫자의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int n3 = Integer.parseInt(br.readLine());
		
		int num = n1 * n2 * n3;
		
		int[] numArray = new int[10];
		
		while(true) {
			if(num <= 0) {
				break;
			}
			int n = num % 10;
			
			numArray[n]++;
			
			num /= 10;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(numArray[i]);
		}
	}

}
