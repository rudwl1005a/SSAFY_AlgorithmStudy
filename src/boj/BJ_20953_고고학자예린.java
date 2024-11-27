package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 B2 ( https://www.acmicpc.net/problem/20953 )
 * 수학
 */
public class BJ_20953_고고학자예린 {

    static int T, a, b;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = (long) (a + b) * (a+b) * (a+b - 1) / 2;
            sb.append(ans).append("\n");
        }

        bw.write(sb.substring(0, sb.toString().length() - 1));

        bw.flush();
        bw.close();
    }
}
