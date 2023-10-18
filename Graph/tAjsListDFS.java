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

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited);
    }

    private void dfs(int u, Set<Integer> visited) {
        visited.add(u);
        System.out.println(u);
        for (int v : adjList.get(u)) {
            if (!visited.contains(v)) {
                dfs(v, visited);
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

        graph.dfs(0);
    }
}
