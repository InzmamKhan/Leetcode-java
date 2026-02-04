class Solution {
    public double D_Median_Of_Two_Sorted_Arrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        // 1. Merge the two sorted arrays into one
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // 2. If there are remaining elements in nums1
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // 3. If there are remaining elements in nums2
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // 4. Calculate the median
        int totalLength = merged.length;
        if (totalLength % 2 != 0) {
            // Odd length: return the middle element
            return (double) merged[totalLength / 2];
        } else {
            // Even length: average of the two middle elements
            int mid1 = merged[(totalLength / 2) - 1];
            int mid2 = merged[totalLength / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}
