package basis.graph;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/30
 * Time: 10:31
 */
public class MatrixGraph implements Graph {
    //边数
    private int eNum;
    //顶点数
    private int vNum;
    //邻接矩阵
    private int[][] matrix;
    //用来输入顶点对应的边
    private Scanner sc = new Scanner(System.in);

    @Override
    public void initialize(int v, int e) {
        this.vNum = v;
        this.eNum = e;
        matrix = new int[v][v];
        for (int i = 0; i < e; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            //考虑x->y
            matrix[x][y] = 1;
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < vNum; i++) {
            for (int j = 0; j < vNum; j++) {
                if (matrix[i][j] == 1) {
                    System.out.println((i + 1) + "->" + (j + 1));
                }
            }
        }
    }

    @Override
    public void dfs(int v) {
        boolean[] mark = new boolean[this.vNum];
        this.dfsMethod(v, mark);
    }

    private void dfsMethod(int v, boolean[] mark) {
        mark[v - 1] = true;
        for (int i = 0; i < this.vNum; i++) {
            if (isAdjacent(v, i + 1) && !mark[i]) {
                mark[i] = true;
                dfsMethod(i + 1, mark);
                System.out.print(i + 1 + " ");
            }
        }
    }

    @Override
    public void bfs(int v) {

    }

    @Override
    public int degree(int v) {
        int count = 0;
        for (int i = 0; i < this.vNum; i++) {//这里仅v点的出度
            if (matrix[v - 1][i] == 1) count++;
        }
        return count;
    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        //v1->v2
        if (matrix[v1 - 1][v2 - 1] == 1) return true;
        return false;
    }
}
