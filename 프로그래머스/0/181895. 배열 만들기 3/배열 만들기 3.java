import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        
        for(int []range : intervals){
            int start = range[0];
            int end = range[1];
            
            for(int i=start;i<=end;i++){
                list.add(arr[i]);
            }            
        }
        
        int []result = new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        
        
        
        
        return result;
    }
}