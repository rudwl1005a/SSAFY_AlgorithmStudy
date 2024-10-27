package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 B1 ( https://www.acmicpc.net/problem/16495 )
 * 수학, 문자열
 */
public class BJ_16495_열순서 {

    static String str;
    static char[] arr;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        arr = new char[str.length()];

        long x = 1;
        for(int i = str.length() - 1; i >= 0; i--) {
            char now = str.charAt(i); // 맨 뒷자리 부터 계산

            ans += ((int)now - (int)('A') + 1) * x;
            x *= 26;
        }

        System.out.println(ans);
    }
}
