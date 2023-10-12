public int[] secondGreaterElement(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    // s1 用来存储还没有遇到「比它大的下一个元素」的元素
    Deque<Integer> s1 = new ArrayDeque<>();
    // s2 用来存储遇到一个「比它大的下一个元素」的元素
    Deque<Integer> s2 = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
        // 如果 s2 中有比 nums[i] 小的元素，说明 nums[i] 就是该元素的下下个更大的元素
        while (!s2.isEmpty() && nums[i] > nums[s2.peek()]) ans[s2.poll()] = nums[i];
        Deque<Integer> t = new ArrayDeque<>();
        // 如果 s1 中有比 nums[i] 小的元素，说明该元素遇到了一个「比它大的下一个元素」的元素，移到 s2 中
        // 注意：需要按顺序移动！！比如在 s1 中的顺序是 a1 a2 a3，那么移到 s2 中的存储顺序也应该 a1 a2 a3
        // 所以这里借助另外一个栈来中转一下，不然顺序会反转
        while (!s1.isEmpty() && nums[i] > nums[s1.peek()]) t.push(s1.poll());
        s1.push(i);
        while (!t.isEmpty()) s2.push(t.poll());
    }
    return ans;
}

public int[] secondGreaterElement(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    // 小根堆
    Queue<Integer> q1 = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
    Queue<Integer> q2 = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
    for (int i = 0; i < n; i++) {
        int x = nums[i];
        while (!q2.isEmpty() && nums[q2.peek()] < x) ans[q2.poll()] = x;
        while (!q1.isEmpty() && nums[q1.peek()] < x) q2.offer(q1.poll());
        q1.offer(i); 
    }
    return ans;
}