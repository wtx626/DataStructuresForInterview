package codeinterview.code04;

/**
 * Created with IntelliJ IDEA.
 * User: wutianxiong
 * Date: 2018/3/22
 * Time: 10:22
 */
public class FindInPartiallySortedMatrix {
    public boolean find(int target, int[][] array) {
        boolean found = false;
        int rows = array.length;
        int cols = array[0].length;
        if (array != null) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (array[row][col] == target) {
                    found = true;
                    break;
                } else if (array[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 10},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(new FindInPartiallySortedMatrix().find(7,arr));
    }
}
