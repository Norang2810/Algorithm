class Solution {
    public int solution(int[] sides) {
        int a = sides[0];
        int b = sides[1];
        
        int min =Math.min(a,b);
        int max =Math.max(a,b);
        
        int case1 = (a + b - 1) - max; // (a+b-1) - (max+1) + 1
    
        int case2 = max - (max - min); // min ~ max 범위 → min 개수
        
        return case1+case2;
    }
}