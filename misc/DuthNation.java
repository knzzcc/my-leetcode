class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, idx = 0;
        while (idx <= r) {
            if (nums[idx] == 0) swap(nums, l++, idx++);
            else if (nums[idx] == 1) idx++;
            else swap(nums, idx, r--);
        }
    }
    void swap(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}


// https://leetcode.cn/problems/sort-colors/solutions/1868577/by-ac_oier-7lwk/
