import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
            
        List<Integer> list = new ArrayList<>();

        for(int i=1;i<n+1;i++){
            if(i%k==0){
                list.add(i); 
            }
        }
        
        int [] answer = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);  
        }
        
        return answer;
    }
}