class 7_Reverse_Integer {
    public int reverse(int x) {
        long rev = 0;
        int temp1 = Math.abs(x);
        long tempLong = Math.abs((long)x);

        while (tempLong > 0) {
            rev = (rev * 10) + (tempLong % 10);
            tempLong = tempLong / 10;
        }

        if (x < 0) {
            rev = -rev;
        }

        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) rev;
    }
}