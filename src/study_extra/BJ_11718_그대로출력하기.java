package study_extra;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 브론즈3 ( https://www.acmicpc.net/problem/11718 )
 */
public class BJ_11718_그대로출력하기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = "";
		while((s = br.readLine()) != null) {
			System.out.println(s);
		}
		
	}

}
