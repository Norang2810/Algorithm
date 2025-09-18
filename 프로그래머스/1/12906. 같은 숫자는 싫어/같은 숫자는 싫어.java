import java.util.Stack;

public class Solution {

	public int[] solution(int []arr) {
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i : arr) {
			if(stack.empty() || !stack.peek().equals(i) ) {
				stack.push(i);
			}
		}
		return stack.stream().mapToInt(Integer::intValue).toArray();
//		return stack.stream().mapToInt(i -> i).toArray();
	}

}
