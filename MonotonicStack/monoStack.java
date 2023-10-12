// Leetcode 496

int[] nextGreaterElement(int[] nums) {
    int n = nums.length;
    // 存放答案的数组
    int[] res = new int[n];
    Stack<Integer> s = new Stack<>(); 
    // 倒着往栈里放
    for (int i = n - 1; i >= 0; i--) {
        // 判定个子高矮
        while (!s.isEmpty() && s.peek() <= nums[i]) {
            // 矮个起开，反正也被挡着了
            s.pop();
        }
        // nums[i] 身后的更大元素
        res[i] = s.isEmpty() ? -1 : s.peek();
        s.push(nums[i]);
    }
    return res;
}

//下一个大于等于的元素
// 注意：我们把 s.peek() == nums[i] 的元素留下了
while (!s.isEmpty() && s.peek() < nums[i]) {
    // 矮个起开，反正也被挡着了
    s.pop();
}
//下一个更小的元素
while (!s.isEmpty() && s.peek() >= nums[i]) {
    // 高个起开，太碍眼了
    s.pop();
}
//上一个更大的元素
// 正着往栈里放
for (int i = 0; i < n; i++) {
    // 其他逻辑不变
}