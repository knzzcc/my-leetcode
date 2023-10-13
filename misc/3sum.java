public class threeSum {
    public int threeSumClosest(int[] nums, int t) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - t) < Math.abs(ans - t))
                    ans = sum;
                if (ans == t) {
                    return t;
                } else if (sum > t) {
                    k--;
                } else if (sum < t) {
                    j++;
                }
            }
        }
        return ans;
    }
}

// 宮水
// https://leetcode.cn/problems/3sum/solutions/572996/shua-chuan-lc-pai-xu-shuang-zhi-zhen-jie-cd8r/
// https://leetcode.cn/problems/3sum/solutions/555408/yi-miao-jiu-neng-kan-dong-de-dong-tu-jie-unfp/