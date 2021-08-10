package com.tfm.algorithm.leetcode;

import lombok.Data;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: ListNode
 * @Author: tangfengmin
 * @Description: 链表节点
 * @Date: 2021-7-12 13:50
 * @Version: 1.0
 */
@Data
public class ListNode {
    int val = -1;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = -1; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    void put(ListNode next){
        this.next = next;
    }
}
