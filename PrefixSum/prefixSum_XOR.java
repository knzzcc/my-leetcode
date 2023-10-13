public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i < preSum.length; i++)
            preSum[i] = preSum[i - 1] ^ arr[i - 1];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            ans[i] = preSum[query[1] + 1] ^ preSum[query[0]];
        }
        return ans;
    }

    // LeetCode 1371
    public int findTheLongestSubstring(String s) {
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int[] preSum = new int[s.length() + 1];
        for (int i = 1; i < preSum.length; i++) {
            if (vowel.contains(s.charAt(i - 1))) {
                // 如果是元音，就做「异或」操作
                preSum[i] = preSum[i - 1] ^ (int) s.charAt(i - 1);
                // 如果不是元音，直接继承前一个结果
            } else
                preSum[i] = preSum[i - 1];
        }
        int ans = 0;
        // 结尾从最后一个元素开始搜索 [......i]
        for (int i = s.length() - 1; i >= 0; i--) {
            // 开头从第一个元素开始搜索 [j......]
            // 注意：一定要 j <= i，因为存在 "d" 这样的情况
            for (int j = 0; j <= i; j++) {
                // 如果找到含有偶数个元音的子数组，直接开始上一个元素结尾的搜索
                // 以 i 为结尾的子数组不可能有更长满足条件的情况
                if ((preSum[i + 1] ^ preSum[j]) == 0) {
                    ans = Math.max(ans, i - j + 1);
                    break;
                }
            }
        }
        return ans;
    }
}

// https://lfool.github.io/LFool-Notes/algorithm/%E5%89%8D%E7%BC%80%E5%92%8C%E4%B9%8B%E5%BC%82%E6%88%96%E7%AF%87.html