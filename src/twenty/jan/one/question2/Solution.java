package twenty.jan.one.question2;

/**
 * @author Godric
 * @date 2019/12/31 16:26
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode(0);
        ListNode next = null;
        ListNode now = ln;

        int digit = 0;

        while (l1 != null && l2 != null) {
            next = new ListNode((l1.val + l2.val + digit) % 10);
            now.next = next;
            if ((l1.val + l2.val + digit) >= 10) {
                digit = 1;
            } else {
                digit = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
            now = now.next;
        }

        while (l1 != null) {
            next = new ListNode((l1.val + digit) % 10);
            now.next = next;
            if ((l1.val + digit) >= 10) {
                digit = 1;
            } else {
                digit = 0;
            }
            l1 = l1.next;
            now = now.next;
        }

        while (l2 != null) {
            next = new ListNode((l2.val + digit) % 10);
            now.next = next;
            if ((l2.val + digit) >= 10) {
                digit = 1;
            } else {
                digit = 0;
            }
            l2 = l2.next;
            now = now.next;
        }

        if (digit > 0) {
            now.next = new ListNode(1);
        }

        return ln.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = s.initNode1();
        ListNode l2 = s.initNode2();

        s.printListNode(s.addTwoNumbers(l1, l2));

    }

    ListNode initNode1() {

        //  ListNode1   2 -> 4 -> 3

        ListNode l1 = new ListNode(0);
//        ListNode l1n = new ListNode(4);
//
//        l1n.next = new ListNode(3);
//        l1.next = l1n;

        return l1;
    }

    ListNode initNode2() {
        // ListNode2    5 -> 6 -> 4
        ListNode l2 = new ListNode(0);
//        ListNode l2n = new ListNode(6);
//
////        l2n.next = new ListNode(4);
//        l2.next = l2n;

        return l2;
    }

    void printListNode(ListNode ln) {
        do {
            System.out.println(ln.val);
            ln = ln.next;
        } while (ln != null);
    }

}
