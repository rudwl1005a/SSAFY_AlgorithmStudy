package study_01st;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 B3 ( https://www.acmicpc.net/problem/2455 )
 */
public class BJ_02455_지능형기차 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int people = 0;
		int max = -1;
		
		for(int i=0; i<4; i++) {
			String s = br.readLine();
			String[] str = s.split(" ");
			people = people + (Integer.parseInt(str[1]) - Integer.parseInt(str[0]));
			if(max < people) max = people;
		}
		
		System.out.println(max);
		
	}
}
