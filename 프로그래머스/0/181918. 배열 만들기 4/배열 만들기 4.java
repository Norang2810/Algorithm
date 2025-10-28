import java.util.*;

class Solution {
    public List solution(int[] arr) {
        int i = 0;
        List<Integer> stk = new ArrayList<>();
        
        while (i < arr.length) {
            if (stk.isEmpty()) {
                stk.add(arr[i]);
                i++;
            } else if (stk.get(stk.size() - 1) < arr[i]) {
                stk.add(arr[i]);
                i++;
            } else {
                stk.remove(stk.size() - 1);
            }
        }
        
        return stk;
    }
}