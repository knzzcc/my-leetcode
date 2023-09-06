太長就分段記

從任一點開始割都可以，那就從第一點開始，判斷inMST把周邊的加入pq(遞增)
pq取出如果不在inMST裡面的話繼續割 weightSum持續疊加

pq min->max
inMST
weightSum
graph

a[2] -> weight

#
iterator
  pq.poll
  check "to" if is in inMST
  weightSum+=weight
  set Flag
  cut(to) 
#
cut
  iterator all neighbor
  check "to" if is in inMST
  add to pq (pq min->max)
#
allConnected
  check if all node is true in inMST

```java
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
