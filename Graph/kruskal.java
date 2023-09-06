int minimumCost(int n, int[][] edges) {

    UF uf = new UF(n + 1);
    Arrays.sort(edges, (a, b) -> (a[2] - b[2]));
    int mst = 0;

    for (int[] edge : edges) {

        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];

        if (uf.connected(u, v)) {
            continue;
        }

        mst += weight;
        uf.union(u, v);
    }

    return uf.count() == 1 ? mst : -1;
    
}


class UF {

    // 见 并查集总结 的实现

}