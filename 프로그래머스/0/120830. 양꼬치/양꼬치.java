class Solution {
    public int solution(int n, int k) {
            
        int serviceDrinks = n / 10 ;
        int paidDrinks = k - serviceDrinks;
                    
        return (n*12000) + (paidDrinks * 2000);
    }
}