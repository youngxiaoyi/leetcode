package com.example.leetcode.leetcodeSolution;

/**
 * 两数相加
 */
public class AddTwoNumbers两数相加 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //预节点 和 当前节点指针
        ListNode current = new ListNode(0);
        ListNode result = current;
        //进位
        int carry = 0;

        while (l1!=null || l2!=null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;

            //处理当前值和进位
            carry = sum / 10;
            sum = sum  % 10;

            //生成新节点 current指针后移
            current.next = new ListNode(sum);
            current = current.next;

            //指针后移
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        //多生成以为
        if (carry > 0) {
            current.next  = new ListNode(carry);
        }
        return result.next;
    }
    public static void main(String[] args) {
        ListNode l3 = new ListNode(3, null);
        ListNode l4 = new ListNode(4, l3);
        ListNode l1 = new ListNode(2, l4);

        ListNode l7 = new ListNode(4, null);
        ListNode l6 = new ListNode(6, l7);
        ListNode l2 = new ListNode(5, l6);
        //342+465 = 807
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("---");

    }
    /**
     * 链表节点
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}




