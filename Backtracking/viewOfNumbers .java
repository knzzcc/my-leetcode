//如果新看到的一个数选与不选，可以画出另一棵递归树，这样所有的组合就落在叶子结点处。

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack, res);
        return res;
    }

    private void dfs(int[] nums, int index, int len,
                     Stack<Integer> stack, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 当前数可选，也可以不选
        // 选了有，进入下一层
        stack.add(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        stack.pop();

        // 不选，直接进入下一层
        dfs(nums, index + 1, len, stack, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
// 選或不選順序可以交換
//靈茶山艾府
//输入的视角（选或不选）
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
        if (i == nums.length) {
            ans.add(new ArrayList<>(path)); // 固定答案
            return;
        }
        // 不选 nums[i]
        dfs(i + 1);
        // 选 nums[i]
        path.add(nums[i]);
        dfs(i + 1);
        path.remove(path.size() - 1); // 恢复现场
    }
}