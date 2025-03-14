package com.day03;

public class leetcode206 {
    public ListNode reverseList(ListNode head) {
        //前驱指针和哑结点有什么区别
        ListNode prev=null;
        ListNode curr = head;

        // 反转链表不是数组(反转指针方向)，循环怎么写呢？
        while (curr != null) {  // 遍历每个节点
//            ListNode temp=curr.next;// 1. 保存下个节点（防止断链）
            curr.next=prev; //2. 反转指针方向 关键是这里有点难理解
            prev=curr;  // 3. 前驱指针前进
            curr=curr.next;// 4. 当前指针前进
        }
        return prev;

    }
}
