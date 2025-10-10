import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int time[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		int result = 0;
		int endTime = 0;

		for (int[] t : time) {
			if (t[0] >= endTime) {
				endTime = t[1];
				result++;
			}
		}

		System.out.println(result);
	}

}
