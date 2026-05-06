public class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        
        while (binary.length() < 32) {
            binary = "0" + binary;
        }

        String revBinary = "";
        int binarylen = binary.length();
        
        for (int i = binarylen - 1; i >= 0; i--) {
            char temp = binary.charAt(i); 
            revBinary += temp;
        }

        return Integer.parseUnsignedInt(revBinary, 2);
    }
}