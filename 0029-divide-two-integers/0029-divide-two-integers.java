class Solution {
    public int divide(int dividend, int divisor) {
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        long result = lDividend / lDivisor;

        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) result;
    }
}