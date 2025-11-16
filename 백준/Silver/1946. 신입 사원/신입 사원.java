import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb= new StringBuilder();
		
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] applicants = new int[N][2];
			
			
			for(int i=0;i<N;i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				
				applicants[i][0] = Integer.parseInt(st.nextToken()); // 서류 등수
                applicants[i][1] = Integer.parseInt(st.nextToken()); // 면접 등수
                
			}
			
			Arrays.sort(applicants,(a,b) -> a[0]-b[0]);
			
			int passCount = 1;
            int bestInterview = applicants[0][1];
			
            
            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < bestInterview) {
                    passCount++;
                    bestInterview = applicants[i][1];
                }
            }
            
            sb.append(passCount).append('\n');
		}
		
		 System.out.println(sb.toString());
	}
}
