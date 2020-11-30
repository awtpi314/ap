package ap.week13;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int arraySize) {
        currentPlayer = 0;
    }

    public void setCurrentPlayer(int playerPosition) {
        currentPlayer = playerPosition;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void distributeCurrentPlayerTokens() {
        int numOfTokens = board[currentPlayer];
        board[currentPlayer] = 0;

        for (int i = 0, j = currentPlayer + 1; i < numOfTokens; i++, j = normalizeSize(++j, board.length)) {
            board[j]++;
        }
    }

    @Override
    public String toString() {
        return "";
    }

    private int normalizeSize(int position, int size) {
        if (position >= size) {
            return position % size;
        } else {
            return position;
        }
    }
}
