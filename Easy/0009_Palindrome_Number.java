class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int palin = 0;
        while(temp > 0){
            palin = (palin*10) + (temp%10);
            temp = temp/10;
        }
        if(palin == x){
            return true;
        }
        else{
            return false;
        }
    }
}
