import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static int visited[] = new int[100001];

    // 이동 규칙: X-1, X+1, 2*X
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); //->1번째 줄 입력을 공백으로 받기때문에 가능
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(node);
        visited[node] = 1; // 시작 지점 = 1 (나중에 -1 해서 0칸 처리)

        while (!queue.isEmpty()) {
            int n = queue.remove();
            
						//종료조건	
            if (n == K) {
                return visited[n] - 1; // 시작값 보정
            }

            // X - 1
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }

            // X + 1
            if (n + 1 <= 100000 && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }

            // 2 * X
            if (2 * n <= 100000 && visited[2 * n] == 0) {
                visited[2 * n] = visited[n] + 1;
                queue.add(2 * n);
            }
        }
        return -1;
    }
}