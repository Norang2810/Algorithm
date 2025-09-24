import java.util.*;
class Solution {
    public long solution(long n) {
        
        String str = String.valueOf(n);
        
        char[] arr = str.toCharArray();
        
        Arrays.sort(arr);
        
        StringBuilder sb =new StringBuilder(new String(arr));
        sb.reverse();
        
        return Long.parseLong(sb.toString());
        
    }
}