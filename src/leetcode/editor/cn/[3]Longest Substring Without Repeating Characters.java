//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5472 👎 0


package leetcode.editor.cn;

import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        assert solution.lengthOfLongestSubstring("pwwkew") == 3;
        assert solution.lengthOfLongestSubstring("") == 0;
        assert solution.lengthOfLongestSubstring(" ") == 1;
        assert  solution.lengthOfLongestSubstring("dvdf") == 3;
        assert  solution.lengthOfLongestSubstring("pwwkew") == 3;
        assert  solution.lengthOfLongestSubstring("abcabcbb") == 3;
        assert  solution.lengthOfLongestSubstring("aab") == 2;
        assert  solution.lengthOfLongestSubstring("aabaab!bb") == 3;

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            String subString = "";
            int length = 0;
            for (int i = 0; i < chars.length; i++) {
                char current = chars[i];
                if (subString.indexOf(current) > -1) {
                    if (subString.length() > length) {
                        length = subString.length();
                    }
                    subString = subString.indexOf(current) == subString.length() -1 ? ("" + current):
                            subString.substring(subString.lastIndexOf(current) + 1) + current;
                } else {
                    subString = subString + current;
                }
            }
            return Math.max(length, subString.length());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}