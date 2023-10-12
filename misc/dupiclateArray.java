// Leetcode 448

// 由于范围是 [1, n]，所以需要向左偏移一位
public List<Integer> findDisappearedNumbers(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] - 1 != i) {
            if (nums[i] == nums[nums[i] - 1]) break;
            int t = nums[i];
            nums[i] = nums[t - 1];
            nums[t - 1] = t;
        }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] - 1 != i) ans.add(i + 1);
    }
    return ans;
}

// 负数标记法
public List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (nums[Math.abs(nums[i]) - 1] > 0) {
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
    }
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) res.add(i + 1);
    }
    return res;
}