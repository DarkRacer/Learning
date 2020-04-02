package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;
    public static boolean firstTurn = true;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;  // Передаем номер ряда, номер столбца и ссылку на кнопку, к которой привязыаем наш GameActionListener
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {

            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья");
                board.emptyField();
            } else if (board.checkVoid()){   // Добавлена функция проверки пустоты поля, в случае, если пользователь выйграет и очистится поле
                updateByAiData(board);
                //Добавлена проверка на ничью после хода компьютера
                if (board.isFull()) {
                    board.getGame().showMessage("Ничья");
                    board.emptyField();
                }
            }
        }
        else {
            board.getGame().showMessage("Некорректный ход");
        }

    }

    /**
     * Ход человека
     *
     * @param board GameBoard() - ссылка на игровое поле
     */
    private void updateByPlayersData(GameBoard board) {
        // Обновляем матрицу игры
        board.updateGameField(row, cell);
        // Обновляем содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        // После хода проверим состояние победы
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    /**
     * Ход комппьютера
     *
     * @param board GameBoard() - ссылка на игровое поле
     */
    private void updateByAiData(GameBoard board) {
        // Генерация координат хода компьютера

        //Первый ход рандомный
        if (firstTurn) {
            randomTurn(board);
            firstTurn = false;
        } else {
                aiTurn(board);
        }

        // Проверить победу
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    /**
     * Рандомный ход компьютера
     */
    private void randomTurn(GameBoard board) {
        int x, y;
        Random rnd = new Random();

        do {
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        } while (!board.isTurnable(x, y));
        updateTurnAI(board, x, y);
    }

    /**
     * Умный ход компьютера
     */
    private void aiTurn(GameBoard board) {
        int g = 0;


            for (int i = 0; i < GameBoard.dimension; i++){

                for (int j = 0; j < GameBoard.dimension; j++) {
                    if (g != 1)
                    if (board.isTurnable(i, j)) {
                        if (bestTurn(board, i, j)) {
                            updateTurnAI(board, i, j);
                             g = 1;
                    }
                }
            }
        }
    }

    /**
     * Обновление выбранной компьютером клетки
     */
    private void updateTurnAI (GameBoard board, int x, int y) {
        // Обновим матрицу игры
        board.updateGameField(x, y);

        // Обновим содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
    }

    /**
     * Выбор компьютером лучшей позиции
     */
    private boolean bestTurn (GameBoard board, int i, int j){
        int verticalH = 0, horizontalH = 0, glavDiagonalH = 0, pobDiagonalH = 0;
        int verticalAI = 0, horizontalAI = 0, glavDiagonalAI = 0, pobDiagonalAI = 0;

        // проходим по вертикалям и горизонталям и подсчитываем колличесто своих знаков и знаков противника
        for (int k = 0; k < GameBoard.dimension; k++) {
            if (GameBoard.gameField[k][j] == board.getGame().gamePlayers[0].getPlayerSign()) {
                verticalH++;
            }
            if (GameBoard.gameField[k][j] == board.getGame().gamePlayers[1].getPlayerSign()) {
               verticalAI++;
            }
            if (GameBoard.gameField[i][k] == board.getGame().gamePlayers[0].getPlayerSign()) {
                horizontalH++;
            }
            if (GameBoard.gameField[i][k] == board.getGame().gamePlayers[1].getPlayerSign()) {
                horizontalAI++;
            }
        }

        if (verticalH == GameBoard.dimension - 1 || horizontalH == GameBoard.dimension - 1) {
            return true;
        }
        else if (verticalAI == GameBoard.dimension - 1 || horizontalAI == GameBoard.dimension - 1) return true;

        // проверяем диагонали
        if (i == j) {
            for (int k = 0; k < GameBoard.dimension; k++) {
                if (GameBoard.gameField[k][k] == board.getGame().gamePlayers[1].getPlayerSign()) {
                    glavDiagonalAI++;
                }
                if (GameBoard.gameField[k][k] == board.getGame().gamePlayers[0].getPlayerSign()) {
                    glavDiagonalH++;
                }
            }
            if (glavDiagonalH == GameBoard.dimension - 1) {
                return true;
            }
            else if (glavDiagonalAI == GameBoard.dimension - 1) return true;

        }

        if (i == (GameBoard.dimension - j - 1) || j == (GameBoard.dimension - i - 1)) {
            for (int k = 0; k < GameBoard.dimension; k++) {
                if (GameBoard.gameField[GameBoard.dimension - k - 1][k] == board.getGame().gamePlayers[0].getPlayerSign()) {
                    pobDiagonalH++;
                }
                if (GameBoard.gameField[GameBoard.dimension - k - 1][k] == board.getGame().gamePlayers[1].getPlayerSign()) {
                    pobDiagonalAI++;
                }
            }
            if (pobDiagonalH== GameBoard.dimension - 1) {
                return true;
            }

            else if (pobDiagonalAI == GameBoard.dimension - 1) {
                return true;
            }
        }

        return false;
    }
}
