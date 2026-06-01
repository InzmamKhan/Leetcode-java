class Solution {
    public boolean isPowerOfTwo(int n) {
        double currentValue = 0;
        int i=0;
        while(currentValue < n){
            currentValue = Math.pow(2,i);
            if(currentValue == n){
                return true;
            }

            i++;
        }
        return false;
    }
}