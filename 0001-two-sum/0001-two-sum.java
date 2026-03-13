class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map =  new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int currentNum = nums[i];
            int compliment = target - currentNum;

            if(map.containsKey(compliment)){
                int index = map.get(compliment);
                int[] result = new int[2];

                result[0] = i;
                result[1] = index;

                return result;
            }
            map.put(currentNum, i);
        }
        return new int[0];
    }
}