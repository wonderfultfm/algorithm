package com.tfm.algorithm.leetcode;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.leetcode
 * @ClassName: MergeTwoLists
 * @Author: tangfengmin
 * @Description: 合并两个有序链表
 * @Date: 2021-7-28 15:54
 * @Version: 1.0
 */
public class MergeTwoLists {
    public static void main(String args[]){

    }
    public static ListNode MergeTwoList(ListNode l1,ListNode l2){
        // 特殊情况
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head=null,tail=null;
        // 数目相同时的对比
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                if(head==null){
                    head=tail=new ListNode(l1.val);
                }else{
                    tail.next=new ListNode(l1.val);
                    tail=tail.next;
                }
                l1=l1.next;
            }else{
                if(head==null){
                    head=tail=new ListNode(l2.val);
                }else{
                    tail.next=new ListNode(l2.val);
                    tail=tail.next;
                }
                l2=l2.next;
            }
        }
        // 如果有剩余，累进
        while(l1!=null){
            tail.next = new ListNode(l1.val);
            tail = tail.next;
            l1=l1.next;
        }
        while(l2!=null){
            tail.next = new ListNode(l2.val);
            tail = tail.next;
            l2=l2.next;
        }
        return head;
    }
}
