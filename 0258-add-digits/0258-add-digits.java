class Solution {
    public int recAdd(int n){
        int newVal = 0;
        while(n > 0){
            newVal = newVal + (n % 10); 
            n /= 10;
        }
        return newVal;
    }
    
    public int addDigits(int num) {
        if(num < 10){
            return num;
        }
        
        int result = recAdd(num);
        while(true){
            if(result < 10){
                return result;
            }
            else{
                result = recAdd(result);
            }
        }
    }
}