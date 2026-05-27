class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        int[] temp = nums;
        for(int i=0; i<nums.length; i++){
            if(temp[i] != val){
                count++;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] == val){
                nums[i] = 999;
            }
        }


        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return count;
    }
}