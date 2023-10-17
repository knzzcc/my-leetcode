//https://lfool.github.io/LFool-Notes/algorithm/%E5%8D%95%E8%B0%83%E6%A0%88-%E6%8B%93%E5%B1%95%E5%BA%94%E7%94%A8.html
//907. 子数组的最小值之和
//2104. 子数组范围和
// 一次循环同时把「下一个更小的元素，上一个小于等于的元素」求出来


// 某個數要找包含他的左右區間(left, right)

// 存储上一个小于等于的元素的下标
int[] left = new int[n];
// 存储下一个更小的元素的下标
int[] right = new int[n];
// 先把 right 初始化为 n
Arrays.fill(right, n);
// 双端队列
Deque<Integer> deque = new ArrayDeque<>();
for (int i = 0; i < n; i++) {
    // 严格小于等于左侧，严格小于右侧
    // 满足条件 arr[deque.peek()] > arr[i]，说明元素 deque.peek() 的下一个更小的元素就是 i (这里均由下标代替元素了，代码中转换一下即可)
    while (!deque.isEmpty() && arr[deque.peek()] > arr[i]) right[deque.pop()] = i;
    // 求上一个小于等于的元素逻辑不变
    left[i] = deque.isEmpty() ? -1 : deque.peek();
    deque.push(i);
}