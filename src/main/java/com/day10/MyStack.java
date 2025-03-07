package com.day10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 力扣225 用队列来实现栈
 */
class MyStack {
    private Queue<Integer> mainQueue; // 主队列，存储栈元素
    private Queue<Integer> helperQueue; // 辅助队列，用于反转顺序

    public MyStack() {
        //接口不能创建对象，我们必须用实现类来创建对象
        mainQueue = new LinkedList<>();
        helperQueue = new LinkedList<>();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);    // 主队列: [1]
        stack.push(2);    // 主队列: [1,2]
        stack.push(3);    // 主队列: [1,2,3]
        System.out.println(stack.pop());   // 输出 3 → 主队列变为 [1,2]
        System.out.println(stack.top());   // 输出 2 → 主队列保持 [1,2]
        System.out.println(stack.empty()); // 输出 false
    }

    // 时间复杂度：O(1)
    public void push(int x) {
//此时主队列的顺序即为元素插入顺序，但栈需要最后插入的元素在最前
        mainQueue.offer(x);
    }

    // 时间复杂度：O(n)
    public int pop() {//出栈并删除
        // 将主队列前n-1个元素移到辅助队列
        while (mainQueue.size() > 1) {
//  offer 是将元素插入队列尾部，它相比于add更加的安全，poll 移除并返回队列头部元素
//  将主队列的 前 n-1 个元素转移到辅助队列。 这个过程中队列的顺序不变，1先进来，2再进来，到辅助队列里面还是1先进来，2再进来
            helperQueue.offer(mainQueue.poll());
        }
        int top = mainQueue.poll(); // 获取栈顶元素
        swapQueues(); // 交换队列引用，保持主队列始终存储最新数据
        return top;
    }

    // 时间复杂度：O(n)
    public int top() {//出栈并不删除
        // 与pop逻辑类似，但需将栈顶元素重新放回队列
        while (mainQueue.size() > 1) {
            helperQueue.offer(mainQueue.poll());
        }
        int top = mainQueue.poll();
        helperQueue.offer(top); // 这样helpQueue就是完整的了
        swapQueues();
        return top;
    }

    // 时间复杂度：O(1)
    public boolean empty() {
        return mainQueue.isEmpty();
    }

    // 交换主队列和辅助队列的引用，避免数据复制
    private void swapQueues() {
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */