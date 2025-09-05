import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder(); // 출력 모아두는 곳

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        visited = new boolean[N + 1]; // 인덱스 1~N 사용

        dfs(0);

        // 최종 출력
        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        // base case: 수열 길이가 M이 되었을 때
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]);
                if (i < M - 1) sb.append(" "); // 마지막엔 공백 X
            }
            sb.append("\n"); // 한 수열 끝나면 줄바꿈
            return;
        }

        // 1부터 N까지 탐색
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 안 쓴 숫자라면
                visited[i] = true;     // 사용 체크
                arr[depth] = i;        // 현재 자리 채우기
                dfs(depth + 1);        // 다음 깊이 탐색
                visited[i] = false;    // 원상복구 (백트래킹)
            }
        }
    }
}
