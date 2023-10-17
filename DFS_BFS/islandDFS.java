public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] visited;
    private int rows;
    private int cols;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;

        this.grid = grid;
        visited = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过，就进行深度优先遍历
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 从坐标为 (i, j) 的点开始进行深度优先遍历
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newX = i + DIRECTIONS[k][0];
            int newY = j + DIRECTIONS[k][1];
            // 如果不越界、还是陆地、没有被访问过
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    /**
     * 封装成 inArea 方法语义更清晰
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

作者：liweiwei1419
链接：https://leetcode.cn/problems/number-of-islands/solutions/12299/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。