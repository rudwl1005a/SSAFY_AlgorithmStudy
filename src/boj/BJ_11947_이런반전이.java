package boj;

import java.io.*;

/**
 * 백준 S3 ( https://www.acmicpc.net/problem/11947 )
 * 수학
 */
public class BJ_11947_이런반전이 {

    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            long len = String.valueOf(N).length(); // 자리수 구하기
            long max = (long)Math.pow(10, len);
            long standard = max / 2 - 1; // 499..9를 기준으로 커졌다가 작아짐

            if(N < standard) {
                bw.write(N * ((max - 1) - N) + "\n");
            } else {
                bw.write(standard * (standard + 1) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}
