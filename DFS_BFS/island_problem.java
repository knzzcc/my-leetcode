// 递归：「当前节点」「该做什么」「什么时候做」
// FloodFill：如果当前位置是岛屿，则填充为海水
//   - 充当了 visited[] 的作用
private void dfs(int[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    // 越界检查
    if (i < 0 || i >= m || j < 0 || j >= n) return ;
    // 如果是海水
    if (grid[i][j] == 0) return ;
    // 否则：1 -> 0
    grid[i][j] = 0;
    // 递归处理上下左右
    dfs(grid, i - 1, j); // 上
    dfs(grid, i + 1, j); // 下
    dfs(grid, i, j - 1); // 左
    dfs(grid, i, j + 1); // 右
}

//https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
//https://leetcode.cn/problems/number-of-islands/solutions/12299/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/

//DFS檢查可以在內也可以在外，通常寫在裡面
//二分圖的時候visited[]才會寫在外面，因為會採取不同的行動

//或者參考宮水 DFS/BFS/UnionFind
//https://leetcode.cn/problems/pacific-atlantic-water-flow/solutions/1452108/by-ac_oier-do7d/