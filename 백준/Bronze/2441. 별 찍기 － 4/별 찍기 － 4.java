import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i-1; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= N-i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
