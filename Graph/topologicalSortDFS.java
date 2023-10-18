// 记录后序遍历的顺序
private List<Integer> postOrder;
private boolean[] visited;
private boolean[] onPath;
private boolean hasCycle = false;
public int[] findOrder(int numCourses, int[][] prerequisites) {
    postOrder = new ArrayList<>();
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    List<Integer>[] graph = buildGraph(prerequisites, numCourses);
    for (int i = 0; i < numCourses; i++) dfs(graph, i);
    // 存在环，无拓扑排序
    if (hasCycle) return new int[]{};
    // 反转顺序
    Collections.reverse(postOrder);
    int[] res = new int[postOrder.size()];
    for (int i = 0; i < postOrder.size(); i++) {
        res[i] = postOrder.get(i);
    }
    return res;
}
private void dfs(List<Integer>[] graph, int s) {
    if (onPath[s]) {
        hasCycle = true;
    }
    if (visited[s] || hasCycle) return;
    visited[s] = true;
    onPath[s] = true;
    for (int v : graph[s]) {
        dfs(graph, v);
    }
    // 后序阶段：加入 List 中
    postOrder.add(s);
    onPath[s] = false;
}