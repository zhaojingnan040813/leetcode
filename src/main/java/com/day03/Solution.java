package com.day03;


//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode n1=null;
        ListNode p=head;
        while(p!=null){
//            。头插法不需要维护尾指针，只需更新头节点，而尾插法则需要同时维护头尾指针，或者在遍历时找到末尾，这样会增加时间复杂度。
//            n1=new ListNode(p.val,n1);
            ListNode newNode = new ListNode(p.val);//现在用尾差法,它与p的区别就是它没有指向，p有指向
            newNode.next=n1;//接下来让它有一个指向


            n1=newNode;//有值，有指向了以后，就可以赋值给要输出的链表了

            p=p.next;

        }
        return n1;

    }
}

