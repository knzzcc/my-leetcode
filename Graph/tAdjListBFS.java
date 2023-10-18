class Graph {

    private int numVertices;
    private List<List<Integer>> adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(u);
            for (int v : adjList.get(u)) {
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.bfs(0);
    }
}

/*
使用list表示visited集合的BFS算法與使用set表示visited集合的BFS算法的效率基本相同。
但是，使用list表示visited集合的BFS算法在某些情況下可能會更快，例如在BFS算法需要不斷地訪問隊列中的元素的情況下
 */
