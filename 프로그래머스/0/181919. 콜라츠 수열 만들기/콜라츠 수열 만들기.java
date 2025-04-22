import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> answer = new ArrayList<Integer>();
    
        answer.add(n);
        
        while(n != 1){
            if(n%2 ==0){
                n /= 2;
            }
            else{
             n = n*3+1;   
            }
            answer.add(n);
        }
        return answer;
    }
}