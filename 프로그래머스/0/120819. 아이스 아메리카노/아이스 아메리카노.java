class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        
        int imericano = 5500;
        
        answer[0] = money / imericano;
        answer[1] = money % imericano;
        
        return answer;
    }
}