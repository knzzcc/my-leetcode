public class State{
    public int id;
    public int distFromStart;
    public State(int id, int distFromStart){
        this.id=id;
        this.distFromStart = distFromStart;
    }
}

public class Dijkstra{
    public int[] dijkstra(List<Integer>[] graph, int start){


        for (int nextNodeId : adj(curNodeId)) {

            int distToNextNode = distTo[curNodeId] + weight(curNodeId, nextNodeId);

            if (distToNextNode < distTo[nextNodeId]) {
                distTo[nextNodeId] = distToNextNode;
                 pq.offer(new State(nextNodeId, distToNextNode));
            }
        }


        for(int nextNodeId:adj(curNodeId)){
            int distToNext
        }
    }

    public int weight(int from, int to){
        return 0;
    }
    
    private List<Integer> adj(int id){
        return new ArrayList<>();
    }
}