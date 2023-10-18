public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = buildGraph(prerequisites, numCourses);
    int[] inDegree = new int[numCourses];
    // init inDegree
    for (int[] courses : prerequisites) {
        inDegree[courses[0]]++;
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
        // 把入度为 0 的节点加入队列中
        if (inDegree[i] == 0) q.offer(i);
    }
    int count = 0;
    int[] res = new int[numCourses];
    while (!q.isEmpty()) {
        int node = q.poll();
        // 区别 1
        res[count++] = node;
        for (int v : graph[node]) {
            inDegree[v]--;
            if (inDegree[v] == 0) q.offer(v);
        }
    }
    // 区别 2
    if (count != numCourses) return new int[]{};
    return res;
}