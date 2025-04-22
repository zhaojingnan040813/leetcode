package Java.dya13;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 */
public class leetcode637 {

    public static void main(String[] args) {


    }

    /**
     * 使用广度优先搜索（BFS）替代递归，逐层处理节点，边遍历边计算平均值
     * 在Java中，BFS通常用队列来实现 ， 处理树或图的层序遍历。
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();//这是一个队列，入队用offer 出队用 Poll
        if (root==null){
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {

          TreeNode node=queue.poll();
//                TreeNode left = queue.poll().left; //  TreeNode=null;是一种错误的写法，先判空，才可以入队列
//                TreeNode right = queue.poll().right;

                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(sum / size);//要知道这一行有几个元素
        }

        return result;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}



