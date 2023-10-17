class Solution {
    int N = 200 * 200 + 10;
    int[] p1 = new int[N], p2 = new int[N];
    int n, m, tot, S, T;
    int[][] g;
    void union(int[] p, int a, int b) {
        p[find(p, a)] = p[find(p, b)];
    }
    int find(int[] p, int x) {
        if (p[x] != x) p[x] = find(p, p[x]);
        return p[x];
    }
    boolean query(int[] p, int a, int b) {
        return find(p, a) == find(p, b);
    }
    int getIdx(int x, int y) {
        return x * n + y;
    }
    public List<List<Integer>> pacificAtlantic(int[][] _g) {
        g = _g;
        m = g.length; n = g[0].length; tot = m * n; S = tot + 1; T = tot + 2;
        for (int i = 0; i <= T; i++) p1[i] = p2[i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getIdx(i, j);
                if (i == 0 || j == 0) {
                    if (!query(p1, S, idx)) dfs(p1, S, i, j);
                }
                if (i == m - 1 || j == n - 1) {
                    if (!query(p2, T, idx)) dfs(p2, T, i, j);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getIdx(i, j);
                if (query(p1, S, idx) && query(p2, T, idx)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i); list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    void dfs(int[] p, int ori, int x, int y) {
        union(p, ori, getIdx(x, y));
        for (int[] di : dirs) {
            int nx = x + di[0], ny = y + di[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if (query(p, ori, getIdx(nx, ny)) || g[nx][ny] < g[x][y]) continue;
            dfs(p, ori, nx, ny);
        }
    }
}

作者：宫水三叶
链接：https://leetcode.cn/problems/pacific-atlantic-water-flow/solutions/1452108/by-ac_oier-do7d/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。