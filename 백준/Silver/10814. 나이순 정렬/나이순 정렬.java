import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Member{
	int age;
	String name;
	int order; //순서
	
	public Member(int age,String name,int order) {
		this.age = age;
		this.name = name;
		this.order =order; // 순서
	}
}



public class Main {
	public static void main(String[] args) throws Exception {
		 
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Member> members = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age =Integer.parseInt(st.nextToken());
			String name =st.nextToken();
			members.add(new Member(age,name,i)); //i는 0~N 까지 반복이라
		}
		
		members.sort((m1,m2) -> {
			if(m1.age == m2.age) {
				return Integer.compare(m1.order,m2.order);
			}
			return Integer.compare(m1.age, m2.age);
		});
		
		
		StringBuilder sb = new StringBuilder();
		for(Member m : members) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.println(sb);
	}

}
