import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;          // N: 물건 개수, K: 배낭 최대 무게
    static int[] W, V;        // 각 물건의 무게(W)와 가치(V)
    static int[][] dp;        // dp[i][w] : i번째 물건까지 고려했을 때, 무게 w로 만들 수 있는 최대 가치

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 물건 개수
        K = Integer.parseInt(st.nextToken()); // 최대 무게

        W = new int[N + 1];
        V = new int[N + 1];
        dp = new int[N + 1][K + 1]; // 0번은 더미 (편의상 인덱스 1부터 사용)

        // 각 물건의 무게와 가치 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken()); // i번째 물건의 무게
            V[i] = Integer.parseInt(st.nextToken()); // i번째 물건의 가치
        }

        // Bottom-Up 방식 DP
        for (int i = 1; i <= N; i++) {            // i: 현재 고려 중인 물건
            for (int weight = 1; weight <= K; weight++) { // weight: 현재 배낭 무게 제한
                if (W[i] <= weight) {
                    // 현재 물건을 넣을 수 있는 경우
                    dp[i][weight] = Math.max(
                        dp[i - 1][weight],                // 안 넣었을 때
                        dp[i - 1][weight - W[i]] + V[i]  // 넣었을 때
                    );
                } else {
                    // 현재 물건을 넣을 수 없는 경우
                    dp[i][weight] = dp[i - 1][weight];
                }
            }
        }

        System.out.println(dp[N][K]); // N개 물건 고려, 최대 무게 K일 때의 최대 가치
    }
}
