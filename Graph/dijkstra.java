public class State {

    public int id;
    public int distFromStart;

    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}

public class Dijkstra {

    public int[] dijkstra(List<Integer>[] graph, int start) {

        int n = graph.length;
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);

        distTo[start] = 0;

        Queue<State> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distFromStart));

        pq.offer(new State(start, 0));

        while (!pq.isEmpty()) {

            State curState = pq.poll();
            int curNodeId = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeId]) {
                continue;
            }

            for (int nextNodeId : adj(curNodeId)) {

                int distToNextNode = distTo[curNodeId] + weight(curNodeId, nextNodeId);

                if (distToNextNode < distTo[nextNodeId]) {
                    distTo[nextNodeId] = distToNextNode;
                    pq.offer(new State(nextNodeId, distToNextNode));
                }
            }
        }
        return distTo;
    }

    private int weight(int from, int to) {
        return 0;
    }

    private List<Integer> adj(int id) {
        return new ArrayList<>();
    }

}

// Stat(id, distFromS)
// init distTo table, size n, value Integer.MAX_VALUE
// put start int PQ
// while pq
//      curDist > table => skip
//  for all curDist's adj(nextNode)
//      dist2Next =  curDist + nextNode by weight
//      dist2Next compare to table(nextNode)
//          update then add to pq