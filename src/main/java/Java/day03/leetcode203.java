package Java.day03;

import java.util.ArrayList;

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
public class leetcode203 {
    /**
     * 暴力解法：遍历链表，将值不等于 val 的节点存入集合，再根据集合重建链表。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode curr = head;
        //1.收集所有不等于val的节点
//        while (curr.val!=val){  // 注意不能这样写，必须while循环里面套一个if
//        }
        while (curr != null) {
            if (curr.val != val) {
                listNodes.add(curr);
            }
            curr = curr.next;
        }//listNodes里面该有的元素都有了，但是还没有一个相互的指向
        //2. 重建链表
        if (listNodes.isEmpty())
            return null;
//        for (int i = 0; i < listNodes.size(); i++) {
//            listNodes.get(0).next=listNodes.get(i+1);// 但是这样会导致ArrayList的索引越界
//        }

        // 重建链表连接（关键修正）
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }
        // 断开最后一个节点的next
        listNodes.get(listNodes.size() - 1).next = null;


        return listNodes.get(0);


    }

    /**
     * 优化解法：优化解法（哑节点 + 双指针）
     */
    public ListNode removeElements1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;//让这个哑结点指向头结点
        ListNode prev = dummy; // 前驱指针
        ListNode curr = head;  // 当前指针
        while(curr!=null){//对于链表的判断值，一定要有一个while里面套if
            if(curr.val==val){
                prev.next=curr.next;//这是需要删除的节点
            }else{
                prev=curr;
            }
            curr=curr.next;

        }
        return dummy.next;
    }






}
