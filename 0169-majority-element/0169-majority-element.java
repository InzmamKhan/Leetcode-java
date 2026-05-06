import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        int max_element = 0;
        int max_freq = 0;

        for (int i = 0; i < nums.length; i++) {
            int current_num = nums[i];
            
            int current_freq = counts.getOrDefault(current_num, 0) + 1;
            counts.put(current_num, current_freq);

            if (current_freq > max_freq) {
                max_freq = current_freq;
                max_element = current_num;
            }
        }
        
        return max_element;
    }
}