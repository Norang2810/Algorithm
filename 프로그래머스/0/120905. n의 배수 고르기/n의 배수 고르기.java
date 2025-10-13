import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] numlist) {
        ArrayList <Integer> resultList = new ArrayList<>();
        
        for(int i=0;i<numlist.length;i++){
            if(numlist[i] % n == 0){
                resultList.add(numlist[i]);
            }            
        } 
        
        // int answer [] = new int [resultList.size()];
        // for(int i=0; i<resultList.size();i++){
        //     answer[i] = resultList.get(i);
        // }
        
        return resultList.stream().mapToInt(i->i).toArray();
    }
}