class Solution {
    public int solution(String t, String p) {
        //p의 최대 길이 18 -> int 범위 초과 long 타입 필요
        int len = p.length();
        Long pLong = Long.parseLong(p);
        int cnt = 0;
        
        for(int i=0; i<t.length() - len + 1; i++) {
            String str = t.substring(i, i+len);
            
            if(Long.parseLong(str) <= pLong) {
                cnt++;
            }
        }

        return cnt;
    }
}