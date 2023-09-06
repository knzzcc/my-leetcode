public class Prim{
    private final Queue<int[]> pq;
    private boolean[] inMST;
    private Integer weightSum = 0;
    private final List<int[]>[] graph;

    public Prim(List<int[]>[] graph){
        this.graph=graph;
        this.pq = new ProirityQueue<>()
    }
}