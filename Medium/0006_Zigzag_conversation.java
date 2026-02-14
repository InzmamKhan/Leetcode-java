class 6_Zigzag_Conversation {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        char[] result = new char[n];
        int count = 0;
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                result[count++] = s.charAt(j + i);
                
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    result[count++] = s.charAt(j + cycleLen - i);
                }
            }
        }
        
        return new String(result);
    }
}
