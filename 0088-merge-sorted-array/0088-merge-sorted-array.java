class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return; 
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] newarray = new int[m + n];
        int newarraypointer = 0;
        int num1pointer = 0; 
        int num2pointer = 0;

        while (num1pointer < m && num2pointer < n) {

            if (nums1[num1pointer] > nums2[num2pointer]) {
                newarray[newarraypointer] = nums2[num2pointer];
                num2pointer++;
            }

            else {
                newarray[newarraypointer] = nums1[num1pointer];
                num1pointer++;
            }

            newarraypointer++;
        }

        while (num1pointer < m) {
            newarray[newarraypointer] = nums1[num1pointer];
            num1pointer++;
            newarraypointer++;
        }

        while (num2pointer < n) {
            newarray[newarraypointer] = nums2[num2pointer];
            num2pointer++;
            newarraypointer++;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = newarray[i];
        }
    }
}