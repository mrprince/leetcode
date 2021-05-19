//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
// Related Topics 数组 哈希表 
// 👍 11079 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        int[] nums = {3, 3};
        int target = 6;
        int[] ints = solution.twoSum(nums, target);
        assert Arrays.equals(ints, new int[]{0, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
//            for (int i = 0; i < nums.length; i++) {
//                int firstNumber = nums[i];
//                int secondNumber = target - firstNumber;
//                for (int j = i +1 ; j < nums.length; j++) {
//                    if (nums[j] == secondNumber) {
//                        return new int[]{i, j};
//                    }
//                }
//            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    result = new int[] {map.get(nums[i]), i};
                }
                map.put(target - nums[i], i);

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}