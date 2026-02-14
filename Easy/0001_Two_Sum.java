import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;
            
            if (map.containsKey(complement)) {
                int index = map.get(complement);
                
                int[] result = new int[2];
                
                result[0] = index;
                result[1] = i;
                
                return result;
            }
            
            map.put(currentNum, i);
        }
        return new int[0];
    }
}
