class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, 0, p, 0);
    }

    private boolean solve(String text, int tIdx, String pattern, int pIdx) {
        if (pIdx == pattern.length()) {
            return tIdx == text.length();
        }

        boolean currentCharsMatch = false;
        if (tIdx < text.length()) {
            char textChar = text.charAt(tIdx);
            char patternChar = pattern.charAt(pIdx);

            if (patternChar == textChar || patternChar == '.') {
                currentCharsMatch = true;
            }
        }

        if (pIdx + 1 < pattern.length() && pattern.charAt(pIdx + 1) == '*') {
            boolean matchZero = solve(text, tIdx, pattern, pIdx + 2);
            if (matchZero) return true;
            if (currentCharsMatch) {
                boolean matchOneOrMore = solve(text, tIdx + 1, pattern, pIdx);
                if (matchOneOrMore) return true;
            }
            
            return false;
        } 
        
        else {
            if (currentCharsMatch) {
                return solve(text, tIdx + 1, pattern, pIdx + 1);
            } else {
                return false;
            }
        }
    }
}
