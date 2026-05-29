class Solution {
    public int minElement(int[] nums) {
        int currentElement = 0;
        int min = Integer.MAX_VALUE; 

        for(int i = 0; i < nums.length; i++){
            currentElement = nums[i];
            int equiNum = 0; 

            while(currentElement > 0){
                equiNum += currentElement % 10;
                currentElement /= 10;
            }
            
            nums[i] = equiNum;
            if(min > equiNum){
                min = equiNum;
            }
        }
        return min;
    }
}