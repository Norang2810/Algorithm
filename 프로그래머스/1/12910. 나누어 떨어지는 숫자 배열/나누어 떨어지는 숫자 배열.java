import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List <Integer>list = new ArrayList<>();
        
        for(int num :arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
        }
        
        Collections.sort(list);
        
        
        int [] answer = new int[list.size()];
        
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}