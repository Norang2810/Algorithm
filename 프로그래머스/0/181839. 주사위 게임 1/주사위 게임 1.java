/*
if문으로 
홀/짝 구분한이후
분기처리
*/
class Solution {
    public int solution(int a, int b) {
        int result = 0;
        
        if(a % 2 == 1 && b % 2 ==1 ){ //두수 모두 홀수 경우
            return a*a + b*b;
        }else if(a %  2 == 1 || b %  2 == 1){ // a와 b둘중 하나만 홀수
            return 2*(a+b);
        }else{
             return Math.abs(a-b); 
        }
    }
}