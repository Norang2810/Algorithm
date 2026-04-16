import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        Backtracking(num[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void Backtracking(int now, int index) {
        if (index == N) {
            MAX = Math.max(MAX, now);
            MIN = Math.min(MIN, now);
            return;
        }

        // + 선택
        if (operator[0] > 0) {
            operator[0]--;
            Backtracking(now + num[index], index + 1);
            operator[0]++;
        }
        // - 선택
        if (operator[1] > 0) {
            operator[1]--;
            Backtracking(now - num[index], index + 1);
            operator[1]++;
        }
        if (operator[2] > 0) {
            operator[2]--;
            Backtracking(now * num[index], index + 1);
            operator[2]++;
        }
        if (operator[3] > 0) {
            operator[3]--;
            Backtracking(now / num[index], index + 1);
            operator[3]++;
        }
    }
}
