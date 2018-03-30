package basis.graph;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/30
 * Time: 9:53
 */
public interface Graph {

    /**
     * 初始化图
     */
    void initialize(int v, int e);

    /**
     * 打印图遍历结果
     */
    void print();

    /**
     * 深度优先搜索
     */
    void dfs(int v);

    /**
     * 广度优先搜索
     */
    void bfs(int v);

    /**
     * 求某个点的度
     */
    int degree(int v);

    /**
     * 判断v1和v2是否邻接
     */
    boolean isAdjacent(int v1, int v2);
}
