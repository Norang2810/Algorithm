import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {			
			for (int j = 1; j <= N-i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}
