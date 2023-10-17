import java.util.ArrayList;
import java.util.List;


//長度等於n的二進制
//宮水也有一題一樣子集二
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        int n = 1 << size; //--> 1*2^size, 1>>size --> 1/2^sizes
        List<List<Integer>> res = new ArrayList<>();
        
        //0 -> 000 //1 -> 001 -> 002
        //1~size
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    cur.add(nums[j]);
                }
            }
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}