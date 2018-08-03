package cn.amos.algorithm.array;

/**
 * NOTE: 查看矩阵中是否有重复元素
 * PROJECT: chaos
 *
 * @author AMOS
 * @date 2018/8/3
 */
public class IsValidSudoku {

    private static int count = 0;

    public static void main(String[] args) {
        char[][] chars = new char[3][];
        chars[0] = new char[]{'1', '6', '.'};
        chars[1] = new char[]{'0', '4', '7'};
        chars[2] = new char[]{'.', '5', '5'};

        boolean validSudoku = isValidSudoku(chars);
        System.out.println("总比较次数: " + count + ", 矩阵不包含重复元素? " + validSudoku);
    }

    private static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                if (!baseData(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean baseData(char[][] board, int x, int y) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                if (i == x && j == y) {
                    continue;
                }
                count++;
                if (board[x][y] == board[i][j]) {
                    System.out.println("找到啦,啦啦啦!");
                    return false;
                }
            }
        }

        return true;
    }


}
