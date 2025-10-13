class Solution {
    public int solution(int price) {
        int paymoney = 0;
        
        if(price >= 500000){
            paymoney = price  * 80 /100;
        }else if(price >= 300000){
            paymoney = price  * 90 /100;
        }else if(price >= 100000){
            paymoney = price  * 95 /100;
        }else{
            return price;
        }
        
        
        return paymoney;
    }
}