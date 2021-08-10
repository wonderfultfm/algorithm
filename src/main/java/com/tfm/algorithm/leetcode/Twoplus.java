package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: Twoplus
 * @Author: tangfengmin
 * @Description: 两数相加
 * @Date: 2021-7-12 13:49
 * @Version: 1.0
 */
public class Twoplus {
    /**
     *
     * @param args
     * @param listNode
     * @return
     */
    public static ListNode makeListNode(int args, ListNode listNode) {
        if (listNode.getVal() == -1) {
            listNode.setVal(args);
        } else {
            if (listNode.getNext() == null) {
                ListNode l1nextnode = new ListNode();
                l1nextnode.setVal(args);
                listNode.setNext(l1nextnode);
            } else {
                makeListNode(args, listNode.getNext());
            }
        }
        return listNode;
    }

    public static void main(String args[]) {
        ListNode l1node = new ListNode();
        ListNode l2node = new ListNode();
        int[] l1 = {0};
        int[] l2 = {7,3};
        for (int nums : l1) {
            makeListNode(nums, l1node);
        }
        for (int nums : l2) {
            makeListNode(nums, l2node);
        }
        ListNode result = solution(l1node, l2node);
        System.out.println(result.toString());
    }

    /**
     * 自己尝试的逻辑解法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode other = result;
        int nextmore = 0;
        while (l1 != null) {
            int value1 = l1.val;
            int value2 = 0;
            if (l2 != null) {
                value2 = l2.val;
            }
            if (value1 + value2 + nextmore >= 10) {
                other.val = value1 + value2 + nextmore - 10;
                nextmore = 1;
            } else {
                other.val = value1 + value2 + nextmore;
                nextmore = 0;
            }
            if (l1.next != null) {
                ListNode next = new ListNode();
                other.next = next;
                other = next;
            }
            l1 = l1.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (nextmore == 1 && l2 == null) {
            ListNode next = new ListNode();
            next.val = 1;
            other.next = next;
        }
        if (l2 != null) {
            ListNode next = new ListNode();
            other.next = next;
            other = next;
            while (l2 != null) {
                int value2 = l2.val;
                if (value2 + nextmore >= 10) {
                    other.val = value2 - 9;
                    nextmore = 1;
                } else {
                    other.val = value2 + nextmore;
                    nextmore = 0;
                }
                if (l2.next != null) {
                    ListNode next1 = new ListNode();
                    other.next = next1;
                    other = next1;
                }
                l2 = l2.next;
            }
            if (nextmore == 1) {
                ListNode next2 = new ListNode();
                next2.val = 1;
                other.next = next2;
            }
        }
        return result;
    }

    /**
     * 官方解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

}
