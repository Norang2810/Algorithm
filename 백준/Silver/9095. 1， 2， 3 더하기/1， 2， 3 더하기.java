import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 미리 1~10까지 dp 계산 (문제 조건: n은 최대 11보다 작음)
        int[] dp = new int[12];

        // 기본값 정의 (점화식 시작점)
        dp[1] = 1; // 1 = 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        // dp 점화식: dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
