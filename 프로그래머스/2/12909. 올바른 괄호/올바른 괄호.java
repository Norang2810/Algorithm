import java.util.Stack;

public class Solution {
	boolean solution(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length();i++) {
			char c = s.charAt(i);
			
			
			if(c == '(') {
				stack.push(c); //여는 괄호는 스택에 추가
			}else if(c == ')'){
				if(stack.isEmpty()) {  //스택이 비어있으면 짝이 맞지않음
					return false; 
				}
				stack.pop();  //가장 최근의 여는괄호 제거
			}
		}
		
		return stack.isEmpty();
	}
	
	
}
