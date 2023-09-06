public class Prim {

  private final Queue<int[]> pq;
  private boolean[] inMST;
  private Integer weightSum = 0;
  private final List<int[]>[] graph;

  public Prim(List<int[]>[] graph) {

    this.graph = graph;
    this.pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    int n = graph.length;
    this.inMST = new boolean[n];
    inMST[0] = true;

    cut(0);

    while (!pq.isEmpty()) {
      
      int[] edge = pq.poll();
      int to = edge[1];
      int weight = edge[2];
      
      if (inMST[to]) {
        continue;
      }

      weightSum += weight;
      inMST[to] = true;
      cut(to);

    }

  }

  private void cut(int x) {
    for (int[] edge: graph[x]) {
      int to = edge[1];
      if (inMST[to]) {
        continue;
      }
      pq.offer(edge);
    }

  }

  public int weightSum() {
    return this.weightSum;
  }

  public boolean allConnected() {
    for (int i = 0; i < graph.length; i++) {
      if (!inMST[i]) {
        return false;
      }
    }
    return true;
  }
}