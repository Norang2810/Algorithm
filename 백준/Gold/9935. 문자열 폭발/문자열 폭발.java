
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
			
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String Bs = br.readLine();
		
		br.close();
		
		int n = S.length();
		int BsLen = Bs.length();
		char[] result = new char[n];
		int idx = 0;
		
		for(int i= 0; i<n ; i++) {
			result[idx++] = S.charAt(i);
			
			
			if(idx >= BsLen) {
				boolean isBomb = true;
				for(int j=0;j<BsLen;j++) {
					if(result[idx-BsLen+j] != Bs.charAt(j)) {
						isBomb = false;
						break;
					}
				}
				
				if(isBomb) {
					idx -= BsLen;      
				}
			}
			
		}
			
		
			
			
			if(idx == 0) {
				System.out.println("FRULA");
			}else {
				System.out.println(new String(result,0,idx));
			}
		
	}
}
