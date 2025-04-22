package Java.day10;

import java.util.Stack;

/**
 * 力扣232
 */
class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);  // inStack: [1], outStack: []
        q.push(2);  // inStack: [1,2], outStack: []
        System.out.println(q.peek()); // 输出 1（倒栈后 outStack: [2,1]）
        System.out.println(q.pop());  // 输出 1 → outStack: [2]
        System.out.println(q.empty()); // 输出 false
    }

    public void push(int x) {
        inStack.push(x);//放到栈顶，入栈, 刚放进去是一个黑盒，你也不用管它在内部的位置
    }

    /**
     * 举个例子，假设outStack已经有元素，此时push新元素到inStack。此时，队列中的正确顺序
     * 应该是先处理完outStack中的旧元素，然后再处理inStack中的新元素。因为当outStack不为空时，
     * pop和peek不会触发转移操作，所以inStack中的新元素暂时不会被处理，直到outStack被清空后再次调用pop或peek时才会转移。
     * 这样，无论何时，队列的操作顺序都是正确的，不会出现新元素插在旧元素之前的情况
     *
     * @return
     */

    public int pop() { //栈的pop方法是 出栈
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public int peek() { //查看此堆栈顶部的对象，而不将其从堆栈中删除。返回值:
        if (outStack.isEmpty()) { // 难道就不会出现 outStack 不为空，inStack 刚刚才加入了新值的情况吗？
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();

    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
