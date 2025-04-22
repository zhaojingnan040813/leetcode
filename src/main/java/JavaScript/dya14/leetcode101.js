/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
// 一个递归法，一个迭代法(使用队列，深度优先遍历)
// JS中的数据结构就4个，没有栈和队列，只能用数组来模拟(数组的方法多)
//  push()	将元素添加到数组末尾（入队，入栈）
// shift()	移除数组第一个元素（出队）无参数
// pop()	移除并返回数组最后一个元素（出栈）
// 判断数组是否为空，调用数组的length属性
var isSymmetric = function (root) {
    if (root == null) return true;
    const queue = [];
    queue.push(root.left)
    queue.push(root.right)
    while (queue.length !== 0) {
        const node1 = queue.shift();
        const node2 = queue.shift();
        if (node1 === null && node2 === null) continue;
        if (node1 == null || node2 === null) return false;
        if (node1.val !== node2.val) return false;
        // 继续判断他们的孩子是否对称
        queue.push(node1.left);
        queue.push(node2.right);
        queue.push(node1.right);
        queue.push(node2.left);
    }
    return true;
};