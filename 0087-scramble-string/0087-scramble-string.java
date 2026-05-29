class Solution {
    private Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        int n = s1.length();
        memo = new Boolean[n][n][n + 1];
        
        return checkScramble(s1, 0, s2, 0, n);
    }

    private boolean checkScramble(String s1, int i1, String s2, int i2, int len) {
        if (s1.substring(i1, i1 + len).equals(s2.substring(i2, i2 + len))) {
            return true;
        }
        if (!hasSameCharacters(s1, i1, s2, i2, len)) {
            return false;
        }
        if (memo[i1][i2][len] != null) {
            return memo[i1][i2][len];
        }
        for (int i = 1; i < len; i++) {
            if (checkScramble(s1, i1, s2, i2, i) && 
                checkScramble(s1, i1 + i, s2, i2 + i, len - i)) {
                return memo[i1][i2][len] = true;
            }
            if (checkScramble(s1, i1, s2, i2 + len - i, i) && 
                checkScramble(s1, i1 + i, s2, i2, len - i)) {
                return memo[i1][i2][len] = true;
            }
        }

        return memo[i1][i2][len] = false;
    }
    
    private boolean hasSameCharacters(String s1, int i1, String s2, int i2, int len) {
        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i1 + i) - 'a']++;
            count[s2.charAt(i2 + i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}