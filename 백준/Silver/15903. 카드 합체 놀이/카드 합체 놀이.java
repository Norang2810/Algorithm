import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken()); // M이 크므로 long 사용

        PriorityQueue<Long> pq = new PriorityQueue<>(); // 최소 힙

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(st.nextToken());
            pq.add(x);
        }

        // M번 카드 합체 수행
        for (long i = 0; i < M; i++) {
            long a = pq.poll(); // 가장 작은 카드
            long b = pq.poll(); // 두 번째로 작은 카드

            long sum = a + b;

            // 합쳐진 값 두 장을 다시 넣기
            pq.add(sum);
            pq.add(sum);
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.println(result);
    }
}
