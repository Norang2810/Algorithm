import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] data = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 1];

		if (n == 1) {
			dp[1] = data[1];
		} else if (n == 2) {
			dp[2] = data[1] + data[2];
		} else {
			dp[1] = data[1];
		    dp[2] = data[1] + data[2];
			dp[3] = Math.max(data[1] + data[3], data[2] + data[3]); // 계단 3에 도착하는순간 이므로 data[1]+data[2]는안됌.

			for (int i = 4; i < n + 1; i++) {
				dp[i] = Math.max(dp[i - 3] + data[i-1] + data[i], dp[i - 2] + data[i]);
			}

		}
		System.out.println(dp[n]);
	}
}
