public class monoStack132 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int third = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true; // 找到first
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // 事实上，third 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                third = Math.max(third, d.pollLast()); 
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}
