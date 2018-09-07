package codeinterview.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * <p>
 * 小广附近有家盒马店，该店提供配送服务，配送范围是系统根据各项指标决策出的一个多边形，假设小广现在的位置为（x,y），请问小广是否在该盒马店的配送范围内，如果不在配送范围内请问他要最少要走多少距离才能到盒马店配送范围内。假设坐标点在二维平面上，不考虑地球曲率等因素。
 * <p>
 * <p>
 * <p>
 * 输入：
 * <p>
 * x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)
 * <p>
 * x1,y1,x2,y2,x3,y3....xn,yn(代表该盒马店的配送范围多边形，其中x表示横坐标，y表示纵坐标，xi和yi代表多边形一个点，点与点按顺序相连形成边，并且最后一个点(xn,yn)与第一个点(x1,y1)相连）
 * <p>
 * 输出：
 * <p>
 * 请问小广是否在盒马店的配送范围内，如果不在配送范围内请问他要最少走多少距离才能到盒马店配送范围内，输出结果为整数（四舍五入）
 * <p>
 * <p>
 * <p>
 * 举例说明：
 * <p>
 * 输入：
 * <p>
 * 1,1
 * 0,0,0,2,2,2,2,0
 * <p>
 * 输出：
 * <p>
 * yes,0
 * <p>
 * <p>
 * <p>
 * 输入：
 * <p>
 * 2,2
 * 0,0,0,2,2,2,2,0
 * <p>
 * 输出：
 * <p>
 * yes,0
 * <p>
 * <p>
 * <p>
 * 输入：
 * <p>
 * 3,0
 * 0,0,0,2,2,2,2,0
 * <p>
 * 输出：
 * <p>
 * no,1
 * <p>
 * <p>
 * <p>
 * 输入：
 * <p>
 * 3,4
 * 0,0,0,2,2,2,2,0
 * <p>
 * 输出：
 * <p>
 * no,2
 */
class Point {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {

    /**
     * 返回一个点是否在一个多边形区域内
     *
     * @param mPoints 多边形坐标点列表
     * @param point   待判断点
     * @return true 多边形包含这个点,false 多边形未包含这个点。
     */
    public static boolean isPolygonContainsPoint(List<Point> mPoints, Point point) {
        int nCross = 0;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数
            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y)
                continue;
            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            // 求解 point点水平线与当前p1p2边的交点的 X 坐标
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x) // 当x=point.x时,说明point在p1p2线段上
                nCross++; // 只统计单边交点
        }
        // 单边交点为偶数，点在多边形之外 ---
        return (nCross % 2 == 1);
    }

    /**
     * 返回一个点是否在一个多边形边界上
     *
     * @param mPoints 多边形坐标点列表
     * @param point   待判断点
     * @return true 点在多边形边上,false 点不在多边形边上。
     */
    public static boolean isPointInPolygonBoundary(List<Point> mPoints, Point point) {
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数

            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y > Math.max(p1.y, p2.y))
                continue;

            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y) {
                double minX = Math.min(p1.x, p2.x);
                double maxX = Math.max(p1.x, p2.x);
                // point在水平线段p1p2上,直接return true
                if ((point.y == p1.y) && (point.x >= minX && point.x <= maxX)) {
                    return true;
                }
            } else { // 求解交点
                double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
                if (x == point.x) // 当x=point.x时,说明point在p1p2线段上
                    return true;
            }
        }
        return false;
    }

    public static double getDist(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Point xiaoming = new Point();
        String[] str = sc.nextLine().split(",");
        xiaoming.setX(Integer.valueOf(str[0]));
        xiaoming.setY(Integer.valueOf(str[1]));
        List<Point> hema = new ArrayList<>();
        String[] hemaStr = sc.nextLine().split(",");
        for (int i = 0; i < hemaStr.length / 2; i++) {
            Point tmp = new Point();
            tmp.setX(Integer.valueOf(hemaStr[i]));
            tmp.setY(Integer.valueOf(hemaStr[i + 1]));
            hema.add(tmp);
        }

        if (isPointInPolygonBoundary(hema, xiaoming) || isPolygonContainsPoint(hema, xiaoming)) {
            System.out.println("yes,0");
        } else {
            double min = getDist(hema.get(0), xiaoming);
            for (Point p : hema) {
                min = Math.min(min, getDist(p, xiaoming));
            }
            System.out.println("no," + (int) min);
        }

    }
}
