class Solution {
    public String solution(int num) {
        String Odd = "Odd";
        String Even = "Even";
        
        if(Math.abs(num) % 2 == 0){
            return Even;
        }else{
            return Odd;
        }
    }
}