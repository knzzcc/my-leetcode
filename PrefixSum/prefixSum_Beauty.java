public class Soltuion {
    public long wonderfulSubstrings(String word) {
        // 统计每种情况的个数
        int[] cnt = new int[1024];
        // 全 0 的情况
        cnt[0] = 1;
        // 记录字符串的奇偶性
        int sum = 0;
        long ans = 0L;
        for (int i = 0; i < word.length(); i++) {
            // 更新奇偶性
            sum ^= 1 << ((int) word.charAt(i) - 'a');
            // 累加第一种情况的数量
            ans += cnt[sum];
            // 累加第二种情况的数量
            for (int j = 1; j < 1024; j <<= 1) {
                ans += cnt[sum ^ j];
            }
            // 更新数量
            cnt[sum]++;
        }
        return ans;
    }
}

// https://lfool.github.io/LFool-Notes/algorithm/%E5%89%8D%E7%BC%80%E5%92%8C%E4%B9%8B%E5%A5%87%E5%81%B6%E7%AF%87.html