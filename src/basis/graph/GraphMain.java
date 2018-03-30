package basis.graph;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/30
 * Time: 11:10
 */
public class GraphMain {
    public static void main(String[] args) {
        MatrixGraph matrixGraph = new MatrixGraph();
        Scanner sc = new Scanner(System.in);
        int vNum = sc.nextInt();
        int eNum = sc.nextInt();
        matrixGraph.initialize(vNum, eNum);
        matrixGraph.print();
        matrixGraph.dfs(1);
        matrixGraph.bfs(1);
    }
}
