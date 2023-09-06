//Adjacency List
List<Integer>[] graph;

for(Integer v : graph[x]){
    traversal(graph, v, ...);
}

//Adjacency Matrix
//matrix[][] == 1表示有連通
//matrix[x][y] x->y
boolean[][] matrix;
for(int i=0; i<matirx[x].length; i++){
    if(matrix[x][i]==1) traversal(matrix, i, ...);
}

//Build Graph
//不必然n+1
private List<Integer>[] buildGraph (int[][] edges, int n){
    List<Integer>[] graph = new ArrayList[n+1];
    for(int i=1; i<=n; i++) graph[i] = new ArrayList<Integer>();
    for(int[] edge : edges){
        int from = edge[0];
        int to = edge[1];
        graph[from].add(to);
    }
    return graph;
}