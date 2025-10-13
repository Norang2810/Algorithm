import java.util.*;
class Solution {
    public int[] solution(int n) {
        List <Integer> oddList = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(i % 2 != 0){
                oddList.add(i);
            }
        }
        
        return oddList.stream().mapToInt(i->i).toArray();
    }
}