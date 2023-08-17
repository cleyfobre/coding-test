package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon2839 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int kg = Integer.parseInt(br.readLine());
        br.close();

        int cnt = -1; // 봉지 개수를 저장할 변수 (-1로 초기화)
        for (int i = 0; i <= kg/3; i++) { // 3킬로그램 봉지 개수를 0부터 kg/3까지 증가시키며 탐색
            int left = kg - i*3; // 3킬로그램 봉지를 i개 사용한 후 남은 설탕 무게
            int afterDivide5kg = left % 5;
            if (afterDivide5kg == 0) { // 5킬로그램 봉지로 남은 설탕 무게를 정확하게 나눌 수 있으면
                cnt = i + left/5; // 봉지 개수 합산
                break;
            }
        }
        System.out.println(cnt);
    }

}
