public class twoSum {
    
}


class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; ; i++) // 枚举 i
            for (int j = i + 1; j < nums.length; j++) // 枚举 i 右边的 j
                if (nums[i] + nums[j] == target) // 满足要求
                    return new int[]{i, j}; // 返回两个数的下标
        // 题目保证有解，循环中一定会 return
        // 所以这里无需 return，毕竟代码不会执行到这里
    }
}



// 0x3f
// https://leetcode.cn/problems/two-sum/solutions/2326193/dong-hua-cong-liang-shu-zhi-he-zhong-wo-0yvmj/

// 宮水有解釋，由右到左比較有效率
// https://leetcode.cn/problems/two-sum/solutions/572871/po-su-jie-fa-ha-xi-biao-jie-fa-by-ac_oie-yf7o/

// 還有雙指針法