// Leetcode 239

public class MonotonicQueue {
    // 双链表，支持头部和尾部增删元素
    private final LinkedList<Integer> q = new LinkedList<>();
    // 在队尾添加元素 n
    public void push(int n);
    // 队头元素如果是 n，删除它
    public void pop(int n);
    // 返回当前队列中最大值
    public int max();
}

// 在队尾添加元素 n
public void push(int n) {
    // 将小于 n 的元素全部删除
    while (!q.isEmpty() && q.getLast() < n) {
        q.pollLast();
    }
    // 然后将 n 加入尾部
    q.addLast(n);
}

// 返回当前队列中最大值
public int max() {
    return q.getFirst();
}

// 队头元素如果是 n，删除它
public void pop(int n) {
    if (n == q.getFirst()) {
        q.pollFirst();
    }
}