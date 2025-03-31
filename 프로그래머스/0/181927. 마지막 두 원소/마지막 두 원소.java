import java.util.*;

class Solution {
    public List solution(int[] num_list) {
        List<Integer> answer = new ArrayList<>();
        
        int last = num_list[num_list.length - 1];  // 마지막 원소
        int lastb = num_list[num_list.length - 2];  // 마지막 원소에서 그 전 원소
        
        for(int i = 0; i < num_list.length; i++){
            answer.add(num_list[i]);
        }
        if(last > lastb){
            answer.add(last - lastb);
        } else {
            answer.add(last * 2);
        }
        return answer;
    }
}