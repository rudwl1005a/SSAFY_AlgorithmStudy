package sort.b10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/10814 )
 */

// 메모리: 204,368KB , 시간: 656ms
public class Main2 {
	
	static int N;
	static String age, name;
	static String[] people = new String[201];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Arrays.fill(people, "");
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			age = st.nextToken();
			name = st.nextToken();
			String save = age + " " + name + "\n";
			people[Integer.parseInt(age)] += save;
		}
		
		for(int i=0; i<201; i++) {
			if(people[i] != "") System.out.print(people[i]);
		}
	}

}
