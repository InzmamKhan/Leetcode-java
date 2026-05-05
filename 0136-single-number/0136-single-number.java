class Solution {
    public int singleNumber(int[] nums) {
        int count =0;
        for(int i=0; i<nums.length; i++){
            int number = nums[i];

            for(int j=0; j<nums.length; j++){
                if(nums[j] == number){
                    count++;
                }
            }
            if(count!=2){
                return nums[i];
            }
            else{
                count=0;
            }
        }
        return 0;
    }
}