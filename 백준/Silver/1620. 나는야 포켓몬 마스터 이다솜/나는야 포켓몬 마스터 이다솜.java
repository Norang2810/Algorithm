import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		HashMap<Integer, String> numToName = new HashMap<>();
		HashMap<String, Integer> nameToNum = new HashMap<>();
		
		for(int i=1;i<=n;i++) {
			String s = br.readLine();
			numToName.put(i, s);
			nameToNum.put(s, i);
		}
		
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			
			if(49<= s.charAt(0) && s.charAt(0)<= 57) {
				sb.append(numToName.get(Integer.parseInt(s))).append("\n");
			}else {
				sb.append(nameToNum.get(s)).append("\n");
			}
		}
		System.out.print(sb);
	}

}
