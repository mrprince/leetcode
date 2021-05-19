//Given two sorted arrays nums1 and nums2 of size m and n respectively, return t
//he median of the two sorted arrays.
//
// The overall run time complexity should be O(log (m+n)).
//
//
// Example 1:
//
//
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
//
//
// Example 2:
//
//
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
//
// Example 3:
//
//
//Input: nums1 = [0,0], nums2 = [0,0]
//Output: 0.00000
//
//
// Example 4:
//
//
//Input: nums1 = [], nums2 = [1]
//Output: 1.00000
//
//
// Example 5:
//
//
//Input: nums1 = [2], nums2 = []
//Output: 2.00000
//
//
//
// Constraints:
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
// Related Topics 数组 二分查找 分治算法
// 👍 4101 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        assert 2.5 == solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        assert 2 == solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        assert 0 == solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0,0});
        assert 1 == solution.findMedianSortedArrays(new int[]{}, new int[]{1});
        assert 2 == solution.findMedianSortedArrays(new int[]{2}, new int[]{});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
            collect.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
            List<Integer> sorted = collect.stream().sorted().collect(Collectors.toList());
            int num = sorted.size();
            if (num == 0) {
                return 0d;
            }
            if (num % 2 == 0) {
                return (double) (sorted.get(num / 2 - 1) + sorted.get(num / 2)) / 2;
            } else {
                return sorted.get(num / 2);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
