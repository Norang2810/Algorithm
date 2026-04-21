class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        
        // e인덱스가 더크므로 왼쪽에서 오른쪽으로 안쪽으로 이동
        while(s<e){
            char tmp = sb.charAt(s);
            sb.setCharAt(s,sb.charAt(e));
            sb.setCharAt(e,tmp);
            s++;
            e--;
        }
        
        
        return sb.toString();
    }
}