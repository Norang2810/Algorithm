class Solution {
    public int solution(int[] array, int n) {
        int result = 0;
        
        for(int num : array){
            if(num == n){
                result++;
            }
        }        
        return result;
    }
}