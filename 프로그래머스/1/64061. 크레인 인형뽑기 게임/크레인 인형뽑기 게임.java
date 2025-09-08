import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int solution(int[][] board, int[] moves) {
		
		//각 열별 스택
		Deque<Integer>[] lanes = new ArrayDeque[board.length];

		for (int i = 0; i < lanes.length; i++) {

			lanes[i] = new ArrayDeque<>();
		}
		
		// 스택에 시작 데이터를 넣는다.
		for (int i = board.length - 1; i >= 0; i--) { // 배열의 마지막 (맨 밑) 부터
			for (int j = 0; j < board[i].length; j++) { // 왼쪽 -> 오른쪽
				if (board[i][j] > 0) {
					lanes[j].push(board[i][j]);
				}
			}

		}
		//  바구니 스택
		
		Deque<Integer> bucket = new ArrayDeque<>();
		int answer = 0;
		
		for (int move : moves) {
			if ( ! lanes[move - 1].isEmpty()) {
				int doll = lanes[move - 1].pop(); //해당 lanes 의 스택에서 인형을 꺼낸다.
				
				if( ! bucket.isEmpty() && bucket.peek() == doll) {
					bucket.pop();
					answer += 2;
				}else {
					bucket.push(doll);
				}
			}
		}
		
		return answer;
	}

}
