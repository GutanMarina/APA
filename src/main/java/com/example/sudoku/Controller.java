package com.example.sudoku;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller implements Initializable {

    @FXML
    Button button_one;
    @FXML
    Button button_two;
    @FXML Button button_three;
    @FXML Button button_four;
    @FXML Button button_five;
    @FXML Button button_six;
    @FXML Button button_seven;
    @FXML Button button_eight;
    @FXML Button button_nine;
    @FXML Canvas canvas;
    GameBoard gameboard;
    int player_selected_row = -1;
    int player_selected_col = -1;
    Color line_color = Color.WHITE;

    public void solve() {
        System.out.println("Solve");
        gameboard.solvePuzzle(); // Apelăm metoda de soluționare din GameBoard
        drawOnCanvas(canvas.getGraphicsContext2D()); // Redibăim tabla de joc
    }

    // Metoda pentru a da un indiciu
    public void hint() {
        System.out.println("Hint");
        gameboard.provideHint(); // Apelăm metoda de hint din GameBoard
        drawOnCanvas(canvas.getGraphicsContext2D()); // Redibăim tabla de joc
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("Start");
        gameboard = new GameBoard(9, 30);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawOnCanvas(context);
    }
    public void newGame() {
        System.out.println("New Game");
        gameboard.newValues();
        player_selected_row = player_selected_col = -1;
        drawOnCanvas(canvas.getGraphicsContext2D());
    }


    public void check(){
        System.out.println("Check");
        if (gameboard.check()) {
            System.out.println("True");
            line_color = Color.GREEN;
        } else {
            System.out.println("False");
            line_color = Color.RED;
        }
        player_selected_row = player_selected_col = -1;
        drawOnCanvas(canvas.getGraphicsContext2D());
        line_color = Color.WHITE;
    }
    private void drawOnCanvas(GraphicsContext context) {

        int initial[][] = gameboard.getInitial();
        int[][] player = gameboard.getPlayer();
        context.clearRect(0, 0, 450, 450);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int position_y = row * 50 + 2;
                int position_x = col * 50 + 2;
                int width = 46;
                if (initial[row][col] != 0) {
                    context.setFill(Color.rgb(175, 175, 175));
                } else if (player[row][col] != 0) {
                    context.setFill(Color.rgb(225, 225, 125));
                } else {
                    context.setFill(Color.rgb(225, 225, 225));
                }
                context.fillRoundRect(position_x, position_y, width, width, 10, 10);
            }
        }

        context.setStroke(Color.rgb(193, 87, 87));
        context.setLineWidth(3);
        if (player_selected_col > -1) {
            context.strokeRoundRect(player_selected_col * 50 + 2, player_selected_row * 50 + 2, 46, 46, 10, 10);
        }

        // for loop is the same as before
        for(int row = 0; row<9; row++) {
            for(int col = 0; col<9; col++) {

                int position_y = row * 50 + 35;
                int position_x = col * 50 + 15;

                context.setFill(Color.BLACK);
                context.setFont(new Font(30));

                if(player[row][col]!=0) {
                    String txt = Integer.toString(player[row][col]);
                    context.fillText(txt, position_x, position_y);
                }
            }
        }
        context.setStroke(line_color);
        for (int i = 1; i <= 2; i++) {
            context.strokeLine(i * 150, 0, i * 150, 450);
            context.strokeLine(0, i * 150, 450, i * 150);
        }
    }

    public void canvasMouseClicked() {
        canvas.setOnMouseClicked(e->{
            int mouse_x = (int) e.getX();
            int mouse_y = (int) e.getY();
            player_selected_row = (int) (mouse_y / 50); // update player selected row
            player_selected_col = (int) (mouse_x / 50); // update player selected column
            drawOnCanvas(canvas.getGraphicsContext2D());
        });
    }

    public void reset() {
        System.out.println("Reset");
        gameboard.resetPlayer();
        player_selected_row = player_selected_col = -1;
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonOnePressed() {
        System.out.println(1);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(1, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(1, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 1 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonTwoPressed() {
        System.out.println(2);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(2, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(2, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 2 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonThreePressed() {
        System.out.println(3);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(3, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(3, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 3 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonFourPressed() {
        System.out.println(4);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(4, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(4, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 4 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonFivePressed() {
        System.out.println(5);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(5, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(5, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 5 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonSixPressed() {
        System.out.println(6);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(6, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(6, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 6 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonSevenPressed() {
        System.out.println(7);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(7, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(7, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 7 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonEightPressed() {
        System.out.println(8);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(8, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(8, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 8 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }

    public void buttonNinePressed() {
        System.out.println(9);
        if (gameboard.getInitial()[player_selected_row][player_selected_col] != 0) {
            return;
        }
        if (checkValidity(9, player_selected_row, player_selected_col)) {
            gameboard.modifyPlayer(9, player_selected_row, player_selected_col);
        } else {
            showAlert("Invalid move", "The number 9 cannot be placed here.");
        }
        drawOnCanvas(canvas.getGraphicsContext2D());
    }
    public boolean checkValidity(int num, int row, int col) {
        // Verifică rândul
        for (int i = 0; i < 9; i++) {
            if (gameboard.getPlayer()[row][i] == num) {
                System.out.println("Numărul " + num + " există deja în rândul " + row); // Debugging
                return false; // numărul există deja în rând
            }
        }

        // Verifică coloana
        for (int i = 0; i < 9; i++) {
            if (gameboard.getPlayer()[i][col] == num) {
                System.out.println("Numărul " + num + " există deja în coloana " + col); // Debugging
                return false; // numărul există deja în coloană
            }
        }

        // Verifică zona 3x3
        int boxStartRow = row - row % 3;
        int boxStartCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameboard.getPlayer()[boxStartRow + i][boxStartCol + j] == num) {
                    System.out.println("Numărul " + num + " există deja în zona 3x3"); // Debugging
                    return false; // numărul există deja în zona 3x3
                }
            }
        }

        return true; // numărul este valid
    }

    // Metodă pentru alertă
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public class GameBoard {
        int N;
        int SRN;
        int K;
        private int[][] solution;
        private int[][] initial;
        private int[][] player;

        public GameBoard(int N, int K) {
            this.N = N;
            this.K = K;
            this.SRN = (int) Math.sqrt(N);
            solution = new int[N][N];
            initial = new int[N][N];
            player = new int[N][N];
            resetPlayer();
        }



        public void solvePuzzle() {
            // Apelăm funcția fillRemaining pentru a umple toate celulele goale cu soluția corectă
            fillRemaining(0, 0);
            resetPlayer(); // Resetăm tabla de joc
            // Copiem soluția în matricea player
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    player[row][col] = solution[row][col];
                }
            }
        }

        // Metoda pentru a da un hint aleatoriu
        public void provideHint() {
            // Căutăm o celulă goală aleatorie
            List<int[]> emptyCells = new ArrayList<>();
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (player[row][col] == 0) {
                        emptyCells.add(new int[]{row, col});
                    }
                }
            }

            // Dacă există celule goale, completăm aleatoriu una
            if (!emptyCells.isEmpty()) {
                int[] randomCell = emptyCells.get((int) (Math.random() * emptyCells.size()));
                int row = randomCell[0];
                int col = randomCell[1];
                player[row][col] = solution[row][col]; // Completează cu soluția corectă
            }
        }

        public void resetPlayer() {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    player[row][col] = initial[row][col];
                }
            }
        }

        public int[][] getPlayer() {
            return player;
        }
        public int[][] getInitial() {
            return initial;
        }
        public void modifyPlayer(int val, int row, int col) {
            if (val >= 0 && val <= 9)
                player[row][col] = val;
            else
                System.out.println("Value passed to player falls out of range");
        }

        Boolean check() {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (player[row][col] != solution[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void newValues() {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    solution[row][col] = 0;
                    initial[row][col] = 0;
                    player[row][col] = 0;
                }
            }
            fillDiagonal();
            fillRemaining(0, SRN);
            removeKDigits();
            resetPlayer();
        }

        // Fill the diagonal SRN number of SRN x SRN matrices
        void fillDiagonal() {
            for (int i = 0; i < N; i = i + SRN) {
                fillBox(i, i);
            }
        }

        // Returns false if given 3 x 3 block contains num.
        boolean unUsedInBox(int rowStart, int colStart, int num) {
            for (int i = 0; i < SRN; i++)
                for (int j = 0; j < SRN; j++)
                    if (solution[rowStart + i][colStart + j] == num)
                        return false;

            return true;
        }

        // Fill a 3 x 3 matrix.
        void fillBox(int row, int col) {
            int num;
            for (int i = 0; i < SRN; i++) {
                for (int j = 0; j < SRN; j++) {
                    do {
                        num = randomGenerator(N);
                    }
                    while (!unUsedInBox(row, col, num));
                    solution[row + i][col + j] = num;
                }
            }
        }

        // Random generator
        int randomGenerator(int num) {
            return (int) Math.floor((Math.random() * num + 1));
        }

        // Check if safe to put in cell
        boolean CheckIfSafe(int i, int j, int num) {
            return (unUsedInRow(i, num) &&
                    unUsedInCol(j, num) &&
                    unUsedInBox(i - i % SRN, j - j % SRN, num));
        }

        // check in the row for existence
        boolean unUsedInRow(int i, int num) {
            for (int j = 0; j < N; j++)
                if (solution[i][j] == num)
                    return false;
            return true;
        }

        // check in the row for existence
        boolean unUsedInCol(int j, int num) {
            for (int i = 0; i < N; i++)
                if (solution[i][j] == num)
                    return false;
            return true;
        }

        // A recursive function to fill remaining
        // matrix
        boolean fillRemaining(int i, int j) {
            if (j >= N && i < N - 1) {
                i = i + 1;
                j = 0;
            }
            if (i >= N && j >= N)
                return true;

            if (i < SRN) {
                if (j < SRN)
                    j = SRN;
            } else if (i < N - SRN) {
                if (j == (int) (i / SRN) * SRN)
                    j = j + SRN;
            } else {
                if (j == N - SRN) {
                    i = i + 1;
                    j = 0;
                    if (i >= N)
                        return true;
                }
            }

            for (int num = 1; num <= N; num++) {
                if (CheckIfSafe(i, j, num)) {
                    solution[i][j] = num;
                    if (fillRemaining(i, j + 1))
                        return true;

                    solution[i][j] = 0;
                }
            }
            return false;
        }

        // Remove the K no. of digits to
        // complete game
        public void removeKDigits() {
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    initial[row][col] = solution[row][col];
                }
            }
            int count = K;
            while (count != 0) {
                int cellId = randomGenerator(N * N) - 1;
                int i = (cellId / N);
                int j = cellId % N;
                if (j != 0)
                    j = j - 1;
                Boolean can = (initial[i][j] != 0);
                for (int k = 0, c1 = 0, c2 = 0; k < N; k++) {
                    if (initial[i][k] == 0) c1++;
                    if (initial[k][j] == 0) c2++;
                    if (c1 >= 7 || c2 >= 7) {
                        can = false;
                    }
                }

                if (can) {
                    count--;
                    initial[i][j] = 0;
                } else if (initial[i][N - 1] != 0) {
                    count--;
                    initial[i][N - 1] = 0;
                }
            }
        }

    }

}
