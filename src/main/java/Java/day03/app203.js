

function ListNode(val,next){
    this.val=(val===undefined?0:val)
    this.next=(next===undefined?null:next)
}

/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    if (head==null){
        return head;
    }
    //递归处理后续节点
      head.next= removeElements(head.next,val)
    return head.val===val?head.next:head
};