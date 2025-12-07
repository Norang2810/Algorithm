import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] stack = new int[N];
		
		int top = -1;
		
		StringBuilder sb = new StringBuilder();
		
		
		
		while (N-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			switch(cmd) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				stack[++top] = x;
				break;
				
			case "pop":
				if(top == -1) {
					sb.append("-1\n");
				}else {
					sb.append(stack[top--]).append("\n");
				}
				break;
			
				
			case "size":
				sb.append(top + 1).append("\n");
				break;
				
			case "empty":
				if(top == -1) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
				
			case "top":
				if(top == -1){
					sb.append("-1\n");
				}
				else {
					sb.append(stack[top]).append("\n");
				}
				
				break;
			}
			
		}
		System.out.println(sb);
	}
	
	
}
