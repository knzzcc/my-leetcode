Collections
Arrays
Compator

PriorityQueue


Math
Rand
https://lfool.github.io/LFool-Notes/java/Random.html

String


---
Lambda

Arrays.stream(candies).max().getAsInt() 



List to int
https://lfool.github.io/LFool-Notes/java/Java-%E5%B0%8F%E6%8A%80%E5%B7%A7%E6%80%BB%E7%BB%93.html

byte <-> int
String <-> Char
String <-> Int


---

https://lfool.github.io/LFool-Notes/java/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6.html

Collections
    ArrayDeque
    List
    Stack
    HashMap
    TreeMap
    HashSet

    LinkList
    ArrayList

https://leetcode.cn/circle/discuss/748W6G/

Stack API
push/pop/peek/empty/size


ArrayDeque -> Stack
addLast
pollLast


ArrayList
add/get
add(idx,e)/set(idx, e)
remove(idx)
indexOf(obj) obj第一次出現
lastIndexOf(obj) obj最後一次出現
size

Queue

        // 使用迭代器遍歷佇列
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 使用流對佇列中的元素進行操作
        queue = queue.stream().sorted().collect(Collectors.toList());
        System.out.println(queue); // [1, 2, 3]
add(E e)：將元素 e 添加到佇列的尾部。
offer(E e)：將元素 e 添加到佇列的尾部，如果佇列已滿，則返回 false。
peek()：返回佇列的頭部元素，但不將其刪除。
poll()：返回佇列的頭部元素，並將其從佇列中刪除。
element()：返回佇列的頭部元素，但不將其刪除。
remove()：返回佇列的頭部元素，並將其從佇列中刪除。
isEmpty()：如果佇列為空，則返回 true。
size()：返回佇列中的元素數量。

import java.util.ArrayDeque;

public class ArrayDequeQueue<T> implements Queue<T> {

    private ArrayDeque<T> deque = new ArrayDeque<>();

    @Override
    public void add(T element) {
        deque.addLast(element);
    }

    @Override
    public boolean offer(T element) {
        return deque.offerLast(element);
    }

    @Override
    public T peek() {
        return deque.peekFirst();
    }

    @Override
    public T poll() {
        return deque.pollFirst();
    }

    @Override
    public T element() {
        return deque.elementFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public int size() {
        return deque.size();
    }
}

import java.util.ArrayDeque;

public class ArrayDequeStack<T> implements Stack<T> {

    private ArrayDeque<T> deque = new ArrayDeque<>();

    @Override
    public void push(T element) {
        deque.addFirst(element);
    }

    @Override
    public T pop() {
        return deque.removeFirst();
    }

    @Override
    public T peek() {
        return deque.peekFirst();
    }

    @Override
    public boolean empty() {
        return deque.isEmpty();
    }

    @Override
    public int size() {
        return deque.size();
    }
}
