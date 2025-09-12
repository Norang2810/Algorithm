import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int count = 0;
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}

	/*
	  check 배열은 "이 알파벳을 이전에 본 적 있는가?"를 기록하는 용도.	  
	  prev는 "바로 직전 문자와 지금 문자가 연속인지 확인"하는 용도.
	*/
	public static boolean check() throws Exception {
		boolean[] check = new boolean[26];

		int prev = 0;
		String str = br.readLine(); 

		// 입력받은 문자열의 길이만큼 문자열을 돌면서 charAt으로 i번째 문자 를 now변수로 선언후 그 값을 prev와 비교
		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);

			if (prev != now) {
				if (check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				} else {
					return false;
				}
			}
			// now와 prev가 같다면 (연속된 문자이면)
			continue;
		}
		return true;
	}
}
