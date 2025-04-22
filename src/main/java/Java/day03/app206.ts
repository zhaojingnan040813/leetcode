// 定义链表节点类型 ？ 代表可选，| 代表一种兜底方案
class ListNode {
    val: number
    next: ListNode | null;

    constructor(val?: number, next?: ListNode | null) {
        this.val= val===undefined?0:val;
        this.next= next===undefined?null:next;

    }
}

// 现在先不考虑泛型的问题
class LinkedList{
    head : ListNode;
    //调用构造函数时不传参，head 的默认值为 null。|null 表示允许传入空值
    constructor(head:ListNode|null   =null) {
        this.head=head
    }

    addFirst(node:ListNode):void{
        node.next=this.head
        this.head=node;
    }

    removeFirst():ListNode{
        const first =this.head;
        if (first){
            this.head=first.next;//head不需要动一下吗？
        }
        return first;
    }

    isEmpty():boolean{
        return this.head===null
    }
}

// 解决方案类（明确方法返回类型）
function reverseList(head: ListNode | null): ListNode | null {
    const list1=new LinkedList(head);
    const list2=new LinkedList(null);
    while(!list1.isEmpty()){
        const node =list1.removeFirst()
        if (node){
            list2.addFirst(node)
        }
    }
    return list2.head;
};