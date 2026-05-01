import java.math.BigInteger; 

class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        
        BigInteger number = BigInteger.ZERO; 

        if(digits[size-1] != 9){
            digits[size-1] = digits[size-1] + 1;
            return digits;
        }

        int sum = 0;
        for(int i = 0; i < size; i++){
            sum += digits[i];
        }

        for(int i = 0; i < size; i++){
            number = number.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(digits[i]));
        }
        number = number.add(BigInteger.ONE);

        if(sum != (size * 9)) {
            for(int i = size - 1; i >= 0; i--){
                digits[i] = number.remainder(BigInteger.TEN).intValue();
                number = number.divide(BigInteger.TEN);
            }
            return digits;
        }
        else {
            int newdigits[] = new int[size + 1];
            for(int i = size; i >= 0; i--){
                newdigits[i] = number.remainder(BigInteger.TEN).intValue();
                number = number.divide(BigInteger.TEN);
            }
            return newdigits;
        }
    }
}