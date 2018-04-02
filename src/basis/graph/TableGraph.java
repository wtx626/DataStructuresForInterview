package basis.graph;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/30
 * Time: 15:36
 */
class Node {
    //顶点编号
    private int vertex;
    private int weight;

    public Node(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }
}

public class TableGraph implements Graph {

    private int vNum;
    private int eNum;
    private ArrayList<ArrayList<Node>> adj;

    @Override
    public void initialize(int v, int e) {
        this.vNum = v;
        this.eNum = e;
        for (int i = 0; i < vNum; i++) {
            ArrayList<Node> line = new ArrayList<>();
            adj.add(line);
        }
    }

    @Override
    public void print() {

    }

    @Override
    public void dfs(int v) {

    }

    @Override
    public void bfs(int v) {

    }

    @Override
    public int degree(int v) {
        return 0;
    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        return false;
    }
}
