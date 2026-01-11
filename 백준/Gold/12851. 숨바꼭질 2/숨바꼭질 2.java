import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;
    static int N, K;
    static int[] dist = new int[MAX + 1];
    static int[] count = new int[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(dist[K]);
        System.out.println(count[K]);
    }

    static void bfs() {
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);

        dist[N] = 0;
        count[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int nextTime = dist[cur] + 1;

            int next;

            // x - 1
            next = cur - 1;
            if (next >= 0) {
                if (dist[next] == -1) {
                    dist[next] = nextTime;
                    count[next] = count[cur];
                    q.offer(next);
                } else if (dist[next] == nextTime) {
                    count[next] += count[cur];
                }
            }

            // x + 1
            next = cur + 1;
            if (next <= MAX) {
                if (dist[next] == -1) {
                    dist[next] = nextTime;
                    count[next] = count[cur];
                    q.offer(next);
                } else if (dist[next] == nextTime) {
                    count[next] += count[cur];
                }
            }

            // x * 2
            next = cur * 2;
            if (next <= MAX) {
                if (dist[next] == -1) {
                    dist[next] = nextTime;
                    count[next] = count[cur];
                    q.offer(next);
                } else if (dist[next] == nextTime) {
                    count[next] += count[cur];
                }
            }
        }
    }
}
