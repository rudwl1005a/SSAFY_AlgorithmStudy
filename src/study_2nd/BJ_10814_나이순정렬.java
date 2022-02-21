package study_2nd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 실버5 ( https://www.acmicpc.net/problem/10814 )
 */

// 메모리: 56,184KB, 시간: 1676ms
public class BJ_10814_나이순정렬 {
	
	static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		
	}
	
	static int N, AGE;
	static String NAME;
	static Person[] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		people = new Person[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			AGE = Integer.parseInt(st.nextToken());
			NAME = st.nextToken();
			Person p = new Person(AGE, NAME);
			people[i] = p;
		}
		
		// 로직
		Arrays.sort(people, (it1, it2) -> it1.age - it2.age);
		
		// 출력
		for(Person p : people) {
			System.out.println(p.age + " " + p.name);
		}
	}

}
