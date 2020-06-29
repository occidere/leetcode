/**
 * @author occidere
 * @Blog: https://occidere.blog.me
 * @Github: https://github.com/occidere
 * @since 2020-06-29
 */
public class TicTacToe {

    private final int n;
    private final int[] rows, cols;
    private int slash = 0, backSlash = 0;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row The row of the board.
     * @param col The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1: Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        final int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;

        if (row == col) {
            slash += val;
        }
        if (col == (n - row - 1)) {
            backSlash += val;
        }

        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(slash) == n ||
                Math.abs(backSlash) == n) {
            return player;
        }
        return 0;
    }
}