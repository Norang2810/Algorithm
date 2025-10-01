
class Solution {
    public int solution(int[] sides) {
     
        int sum = 0;
        int max = 0;
        
        for(int side : sides){
            sum += side;
            if(side > max){
                max = side;
            }
        }
        
        if(max < sum-max){
            return 1;
        }else{
            return 2;
        }
    }     
}