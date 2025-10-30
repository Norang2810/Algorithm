class Solution {
    public int[] solution(int[] arr, int k) {
        
       
           if(k%2==1){
               for(int j=0;j<arr.length;j++){
                   arr[j]*=k;
               }
           }else{
               for(int j=0;j<arr.length;j++){
                   arr[j]+=k;
               }
           }
       
        return arr;
    }
}