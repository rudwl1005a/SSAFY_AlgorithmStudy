package math.b02997;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		
		int[] arr = new int[3];
		for(int i = 0; i<3; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		Arrays.sort(arr);
		
		int cha1 = arr[1] - arr[0];
		int cha2 = arr[2] - arr[1];
		if(cha1 > cha2) {
			if(cha1 == cha2*2) System.out.println(arr[0] + cha2);
		} else if(cha1 < cha2) {
			if(cha2 == cha1*2) System.out.println(arr[1] + cha1);
		} else {
			System.out.println(arr[2] + cha1);
		}
	}
}
