class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        
        
        if(a==b) return a;
        int start =Math.min(a,b);
        int end = Math.max(a,b);
        for(int i=start;i<=end;i++){
        answer += i;
        }
    return answer;
}
}