import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    //Настройки игры
    private static char[][] map; //Матрица игры
    private static int size = 3; //Размер поля
    private static boolean SILLY_MODE; // Режим "глупого" компьютера
    private static boolean LOW_MODE; // Режим компьютера, который ходит на основании соседних клеток
    private static boolean MEDIUM_MODE; // Режим компьютера, который ходит на основании подсчёта очков для каждой клетки

    //Символы игры
    private static final char Empty = '.'; //Пустое поле
    private static final char X = 'X'; //Крестик
    private static final char O = 'O'; //Нолик

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean firstTurn;

    public static void main(String[] args) {
        int mode;
        int k = 0;

        // Добавлен бесконечный цикл while для игры в разных режимах компьютера, с возможностью выхода из программы
        while (true) {
            SILLY_MODE = false;
            LOW_MODE = false;
            MEDIUM_MODE = false;
            System.out.println("Выберете режим компьютера: \nSILLY_MODE - 1; \nLOW_MODE - 2; \nMEDIUM_MODE - 3 \nВыход из программы - 4");
            do {
                mode = scanner.nextInt();
                switch (mode) {
                    case 1:
                        SILLY_MODE = true;
                        firstTurn = true;
                        k = 1;
                        break;
                    case 2:
                        LOW_MODE = true;
                        firstTurn = true;
                        k = 1;
                        break;
                    case 3:
                        MEDIUM_MODE = true;
                        firstTurn = true;
                        k = 1;
                        break;
                    case 4:
                        System.out.println("Программа завершила работу");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Введено не корректное значение");
                }
            } while (k != 1);

            initMap();
            printMap();

            while (true) {
                humanTurn(); //Ход человека

                if (isEndGame(X)) {
                    break;
                }

                computerTurn(); //Ход компьютера
                if (isEndGame(O)) {
                    break;
                }
            }
            System.out.println("Игра закончена!\n");
        }
    }

    /**
     * Метод подготавливающий поле
     */
    private static void initMap() {
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = Empty;
            }
        }
    }

    /**
     * Метод выводящий на экран поле
     */
    //Улучшил данное место объединив в один цикл все остальные
    private static void printMap() {
        for (int i = -1; i < size; i++) {
            if (i != -1) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < size; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();

            } else {
                for (int k = 0; k <= size; k++) {
                    System.out.print(k + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Ход человека
     */
    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты ячейки(через пробел)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!isCellValid(x, y));

        map[x][y] = X;
    }

    /**
     * Ход компьютера
     */
    private static void computerTurn() {
        int x = -1;
        int y = -1;
        int rating = 0;
        int n = 0;

        if (SILLY_MODE) {

            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            } while (!isCellValid(x, y));


        }

        else if (LOW_MODE) {

            if (firstTurn) {

                do {
                    x = random.nextInt(size);
                    y = random.nextInt(size);
                } while (!isCellValid(x, y));
                firstTurn = false;

            } else {
                for (int i = 0; i < size; i++) {

                    for (int j = 0; j < size; j++) {
                        n = 0;
                        //проверяем выгодность пустой клетки
                        if (map[i][j] == Empty) {
                            //проверка соседних клеток по вертикали и горизонтали
                            if (i != 0) if (map[i - 1][j] == O) n++;
                            if (i != 2) if (map[i + 1][j] == O) n++;
                            if (j != 0) if (map[i][j - 1] == O) n++;
                            if (j != 2) if (map[i][j + 1] == O) n++;

                            // Проверка соседних по диагонали клеток
                            if (i != 0 && j != 0) if (map[i - 1][j - 1] == O) n++;
                            if (i != 0 && j != 2) if (map[i - 1][j + 1] == O) n++;
                            if (i != 2 && j != 0) if (map[i + 1][j - 1] == O) n++;
                            if (i != 2 && j != 2) if (map[i + 1][j + 1] == O) n++;
                        }

                        //поиск самой выгодной клетки
                        if (rating < n) {
                            rating = n;
                            x = i;
                            y = j;
                        }
                    }
                }

            }

        }

        else if (MEDIUM_MODE) {
            if (firstTurn) {
                do {
                    x = random.nextInt(size);
                    y = random.nextInt(size);
                } while (!isCellValid(x, y));
                firstTurn = false;

            }
            else {
                int nX,  nO, vertical, horizontal, glavDiagonal, pobDiagonal, verticalX, horizontalX, glavDiagonalX, pobDiagonalX ;  //Переменные для подсчёта имеющихся символов для выигрышной комбинации

                for (int i = 0; i < size; i++) {

                    for (int j = 0; j < size; j++) {
                        nO = 0;
                        nX = 0;
                        vertical = 0; horizontal = 0; glavDiagonal = 0; pobDiagonal = 0;
                        verticalX = 0; horizontalX = 0; glavDiagonalX = 0; pobDiagonalX = 0;

                        //проверяем выгодность пустой клетки
                        if (map[i][j] == Empty) {

                            //В двух циклах порядок следующий, сначала работа с вертикалью, потом с побочной диагональю, потом с главной
                            for (int k = i; k >= 0; k--) {

                                if (map[k][j] == O && map[k][j] ==Empty) {
                                    vertical++;
                                    nO ++;
                                }
                                if (map[k][j] == X) {
                                    verticalX++;
                                    nX ++;
                                }

                                for (int g = j; g >= 0; g--) {
                                    if (map[k][g] == O && map[k][g] ==Empty) {
                                        pobDiagonal++;
                                        nO ++;
                                    }
                                    if (map[k][g] == X) {
                                        pobDiagonalX++;
                                        nX ++;
                                    }
                                }

                                for (int g = j; g < size; g++) {

                                    if (map[k][g] == O && map[k][g] ==Empty) {
                                        glavDiagonal++;
                                        nO ++;
                                    }
                                    if (map[k][g] == X) {
                                        glavDiagonalX++;
                                        nX ++;
                                    }
                                }
                            }

                            for (int k = i; k < size; k++) {

                                if (map[k][j] == O && map[k][j] ==Empty) {
                                    vertical++;
                                    nO ++;
                                }
                                if (map[k][j] == X) {
                                    verticalX++;
                                    nX ++;
                                }

                                for (int g = j; g >= 0; g--) {

                                    if (map[k][g] == O && map[k][g] ==Empty) {
                                        pobDiagonal++;
                                        nO ++;
                                    }
                                    if (map[k][g] == X) {
                                        pobDiagonalX++;
                                        nX ++;
                                    }
                                }

                                for (int g = j; g < size; g++) {

                                    if (map[k][g] == O && map[k][g] ==Empty) {
                                        glavDiagonal++;
                                        nO ++;
                                    }
                                    if (map[k][g] == X) {
                                        glavDiagonalX++;
                                        nX ++;
                                    }
                                }

                            }

                            //Работа с горизонтальными символами
                            for (int g = j; g >= 0; g--) {

                                if (map[i][g] == O && map[i][g] ==Empty) {
                                    horizontal++;
                                    nO ++;
                                }
                                if (map[i][g] == X) {
                                    horizontalX++;
                                    nX ++;
                                }
                            }

                            for (int g = j; g < size; g++) {

                                if (map[i][g] == O && map[i][g] ==Empty) {
                                    horizontal++;
                                    nO ++;
                                }
                                if (map[i][g] == X) {
                                    horizontalX++;
                                    nX ++;
                                }

                            }
                        }

                        //Проверка на выигрышную позицию
                        if (horizontal == 2 || vertical == 2 || glavDiagonal == 2 || pobDiagonal == 2) n += 30;
                        if (horizontalX == 2 || verticalX == 2 || glavDiagonalX == 2 || pobDiagonalX == 2) nX += 30;

                        //Поиск самой выгодной клетки
                        if (nX > n) {
                            if (rating < nX) {
                                rating = nX;
                                x = i;
                                y = j;
                            }
                        }

                        else{
                            if (rating < n) {
                                rating = n;
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Компьютер выбрал ячейку " + (x + 1) + " " + (y + 1));
        map[x][y] = O;

    }

    /**
     * Метод проверки корректности введенных данных
     *
     * @param x - координата по вертикали
     * @param y - координата по горизонтали
     * @return boolean - признак корректности
     */
    //Был изменен условный оператор if в else if, чтобы не возникало ошибок, когда пользователь вводит неккореткное число
    private static boolean isCellValid(int x, int y) {
        boolean result = true;

        //Проверка введенных координат
        if (x < 0 || x >= size || y < 0 || y >= size) {
            result = false;
        } else if (map[x][y] != Empty) result = false;

        return result;
    }

    /**
     * Проверка законченности игры
     *
     * @param symbol - символ игрока
     * @return boolean - признак завершения игры
     */
    //Был изменен условный оператор if в else if для того, чтобы не возникало ничьи при победе и заполненном поле
    private static boolean isEndGame(char symbol) {
        boolean result = false;
        int g = 0;
        printMap();

        //Проверка необходимости следующего хода
        if (checkWin(symbol)) {
            System.out.println("Победили " + symbol);
            result = true;
            g = 1;
        } else if (isMapFull()) {
            System.out.println("Ничья");
            result = true;
        }
        return result;
    }

    /**
     * Проверка на полную заполненность поля
     *
     * @return boolean признак оптимальности
     */
    private static boolean isMapFull() {
        boolean result = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == Empty) result = false;
            }
        }
        return result;
    }

    /**
     * Проверка победы
     *
     * @param symbol - введенный символ
     * @return boolean - результат проверки
     */
    private static boolean checkWin(char symbol) {
        boolean result = false;

        if ((map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol) ||
                (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol) ||
                (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol) ||
                (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol) ||
                (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol) ||
                (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol) ||
                (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) ||
                (map[2][0] == symbol && map[1][1] == symbol && map[0][2] == symbol)) {
            result = true;
        }

        return result;
    }

}
