//答案的視角，可行解會在各層子節點，當path/size相同的時候把答案加入answer，回溯的時候path也要-1
//樹的每一層深度，對應可行解的長度 (path/size有點端餘，基本上path/size同進退)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size + 1; i++) {
            dfs(nums, 0, i, stack, res);
        }
        return res;
    }

    private void dfs(int[] nums, int start, int depth, Stack<Integer> path, List<List<Integer>> res) {
        if (depth == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, depth, path, res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}

//可能有的同学之前只会子集模板二的写法，那你一定要掌握模板一的思路，后面在讲动态规划的时候，会频繁地用到这个思路，例如打家劫舍、01背包等。

//方法二：答案的视角（选哪个数）
class Solution {
    private final List<List<Integer>> ans = new ArrayList<>();
    private final List<Integer> path = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        ans.add(new ArrayList<>(path)); // 固定答案
        if (i == nums.length) return;
        for (int j = i; j < nums.length; ++j) { // 枚举选择的数字
            path.add(nums[j]);
            dfs(j + 1);
            path.remove(path.size() - 1); // 恢复现场
        }
    }
}