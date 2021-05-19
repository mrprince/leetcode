//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics 递归 链表 数学 
// 👍 6201 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(9, null);
        ListNode listNode2 = new ListNode(1, new ListNode(9, new ListNode(9, null)));
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        assert listNode.val == 0;
        assert listNode.next.val == 0;
        assert listNode.next.next.val == 0;
        assert listNode.next.next.next.val == 1;
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<Integer> l1List = new ArrayList<>();
            List<Integer> l2List = new ArrayList<>();
            ListNode result = null;

            ListNode current1 = l1;
            ListNode current2 = l2;

            while (current1 != null) {
                l1List.add(current1.val);
                current1 = current1.next;
            }

            while (current2 != null) {
                l2List.add(current2.val);
                current2 = current2.next;
            }

            List<Integer> list = new ArrayList<>();
            int size = Math.max(l1List.size(), l2List.size());
            boolean addOne = false;
            for (int i = 0; i < size; i++) {
                int total =
                        (i >= l1List.size() ? 0 : l1List.get(i)) + (i >= l2List.size() ? 0 : l2List.get(i)) + (addOne
                                ? 1 : 0);
                addOne = total >= 10;
                list.add(total % 10);
            }

            if (addOne) {
                list.add(1);
            }


            for (int i = list.size() - 1; i >= 0; i--) {
                ListNode currentListNode = new ListNode();
                currentListNode.val = list.get(i);
                currentListNode.next = result;
                result = currentListNode;
            }


            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}