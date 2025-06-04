class Solution {
	public int solution(int n) {
		int answer = 0;
		String [] arr = String.valueOf(n).split("");
		
		for(String a : arr) {
			answer += Integer.parseInt(a);
		}
		return answer;
	}
}