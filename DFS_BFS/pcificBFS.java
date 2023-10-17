class Solution {
    int n, m;
    int[][] g;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        g = heights;
        m = g.length; n = g[0].length;
        Deque<int[]> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        boolean[][] res1 = new boolean[m][n], res2 = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    res1[i][j] = true;
                    d1.addLast(new int[]{i, j});
                }
                if (i == m - 1 || j == n - 1) {
                    res2[i][j] = true;
                    d2.addLast(new int[]{i, j});
                }
            }
        }
        bfs(d1, res1); bfs(d2, res2);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res1[i][j] && res2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    void bfs(Deque<int[]> d, boolean[][] res) {
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1], t = g[x][y];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (res[nx][ny] || g[nx][ny] < t) continue;
                d.addLast(new int[]{nx, ny});
                res[nx][ny] = true;
            }
        }
    }
}

作者：宫水三叶
链接：https://leetcode.cn/problems/pacific-atlantic-water-flow/solutions/1452108/by-ac_oier-do7d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。