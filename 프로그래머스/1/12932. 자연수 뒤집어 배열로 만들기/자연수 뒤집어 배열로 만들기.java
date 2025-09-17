import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] solution(long n) {

		List<Integer> list = new ArrayList<>();

		while (n > 0) {
			int digit = (int) (n % 10);
			list.add(digit);
			n /= 10;
		}
		// 리스트를 배열로 변환
		int answer[] = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
