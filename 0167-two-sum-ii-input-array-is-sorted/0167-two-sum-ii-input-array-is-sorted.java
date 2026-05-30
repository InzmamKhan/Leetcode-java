class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int currentRes = 0;

        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                currentRes = numbers[i] + numbers[j];

                if(currentRes == target){
                    result[0] = i+1;
                    result[1] = j+1;

                    return result;
                }
            }
        }
        return result;
    }
}