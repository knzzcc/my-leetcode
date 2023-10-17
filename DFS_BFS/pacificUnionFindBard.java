import java.util.ArrayList;
import java.util.List;

class pacificUnionFindBard {
    int N = 200 * 200 + 10; // 定義一個常數 N，表示最大矩陣大小
    int[] p1 = new int[N], p2 = new int[N]; // 定義兩個父陣列 p1 和 p2，用於存儲連通分量的根節點
    int n, m, tot, S, T; // 定義變量 n、m、tot、S、T，分別表示矩陣的行數、列數、總元素數、太平洋和西洋的標識符
    //然后 DFS/BFS，最后将既'和 S 联通'又'和 T 联通'的格子加入答案。
    int[][] g; // 定義二維整數陣列 g，表示矩陣

    void union(int[] p, int a, int b) { // 定義一個方法 union，用於合併兩個連通分量
        p[find(p, a)] = p[find(p, b)]; // 將兩個連通分量的根節點合併到其中一個根節點下
    }

    int find(int[] p, int x) { // 定義一個方法 find，用於尋找連通分量的根節點
        if (p[x] != x)
            p[x] = find(p, p[x]); // 如果節點 x 的父節點不為 x，則將節點 x 的父節點更新為連通分量的根節點
        return p[x]; // 返回連通分量的根節點
    }

    boolean query(int[] p, int a, int b) { // 定義一個方法 query，用於判斷兩個節點是否在同一個連通分量中
        return find(p, a) == find(p, b); // 如果兩個節點的根節點相同，則表示兩個節點在同一個連通分量中
    }

    int getIdx(int x, int y) { // 定義一個方法 getIdx，用於將二維座標轉換為一維索引
        return x * n + y; // 將二維座標轉換為一維索引
    }

    public List<List<Integer>> pacificAtlantic(int[][] _g) { // 定義一個方法 pacificAtlantic，用於尋找所有可以同時到達太平洋和西洋的格子
        g = _g; // 將矩陣 _g 賦值給 g
        m = g.length;
        n = g[0].length;
        tot = m * n;
        S = tot + 1;
        T = tot + 2; // 初始化變量 m、n、tot、S、T S/T不一定要+1/+2，weiwei的200題UF解法就是圖大小而已
        for (int i = 0; i <= T; i++)
            p1[i] = p2[i] = i; // 初始化父陣列 p1 和 p2
        for (int i = 0; i < m; i++) { // 遍歷矩陣所有格子
            for (int j = 0; j < n; j++) {
                int idx = getIdx(i, j); // 獲取當前格子的索引
                if (i == 0 || j == 0) { // 如果當前格子位於太平洋邊緣
                    if (!query(p1, S, idx))
                        dfs(p1, S, i, j); // 從當前格子開始進行深度優先搜索，並將當前格子加入到連通分量中
                }
                if (i == m - 1 || j == n - 1) { // 如果當前格子位於西洋邊緣
                    if (!query(p2, T, idx))
                        dfs(p2, T, i, j); // 從當前格子開始進行深度優先搜索，並將當前格子加入到連通分量中
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(); // 宣告一個動態數組 ans，用於存儲所有可以同時到達太平洋和西洋的格子
        for (int i = 0; i < m; i++) { // 遍歷矩陣所有格子
            for (int j = 0; j < n; j++) {
                int idx = getIdx(i, j); // 獲取當前格子的索引
                if (query(p1, S, idx) && query(p2, T, idx)) { // 如果當前格子可以同時到達太平洋和西洋
                    List<Integer> list = new ArrayList<>(); // 宣告一個動態數組 list，用於存儲當前格子
                    list.add(i);
                    list.add(j); // 將當前格子加入到動態數組 list 中
                    ans.add(list); // 將動態數組 list 添加到動態數組 ans 中
                }
            }
        }
        return ans; // 返回動態數組 ans
    }

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // 定義一個二維數組 dirs，表示四個方向

    void dfs(int[] p, int ori, int x, int y) { // 定義一個方法 dfs，用於深度優先搜索
        union(p, ori, getIdx(x, y)); // 將當前格子加入到連通分量中
        for (int[] di : dirs) { // 遍歷四個方向
            int nx = x + di[0], ny = y + di[1]; // 計算相鄰格子的坐標
            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue; // 如果相鄰格子超出矩陣範圍，則跳過
            if (query(p, ori, getIdx(nx, ny)) || g[nx][ny] < g[x][y])
                continue; // 如果相鄰格子已經在連通分量中，或者相鄰格子的高度小於當前格子的高度，則跳過
            dfs(p, ori, nx, ny); // 從相鄰格子開始進行深度優先搜索
        }
    }
}
