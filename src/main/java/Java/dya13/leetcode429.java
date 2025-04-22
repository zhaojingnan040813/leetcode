package Java.dya13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 这个题的不同点是在于这是一个N叉树而不是二叉树
 * // 遍历所有子节点并入队 ， 之前是左右两个子节点入队，现在是遍历所有子节点入队
 * if (node.children != null) {
 * for (Node child : node.children) {
 * queue.offer(child);
 * }
 */
public class leetcode429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {//现在就是遍历每一层了
                Node currentNode=queue.poll(); //只是出队列了，但是这个多叉树没有变
                if (currentNode != null) {
                    list.add(currentNode.val);
                }

                if (currentNode.children!=null){//children的类型是 List<Node>
                    for (Node child: currentNode.children){
                        queue.offer(child);
                    }
                }

            }
            result.add(list);

        }
        return result;

    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
