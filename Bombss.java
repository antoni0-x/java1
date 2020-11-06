package javaVvod.lesson8;

import javax.swing.*;
import java.awt.*;

public class Bombss extends JFrame {
    protected boolean isAlive = true;

    public Bombss(final int SIZE) {
        setTitle("Bombs and Deaths");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);


        boolean[][] bombs = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bombs[i][j] = Math.random() <= 0.25;
            }
        }

        JButton[][] buttons = new JButton[SIZE][SIZE];

        setLayout(new GridLayout(SIZE, SIZE));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                button.setText("???");
                int ii = i;
                int jj = j;
                button.addActionListener(actionEvent -> {
                    if (!isAlive) return;
                    if (bombs[ii][jj]) {
                        for (int iii = 0; iii < SIZE; iii++) {
                            for (int jjj = 0; jjj < SIZE; jjj++) {
                                if (bombs[iii][jjj]) {
                                    buttons[iii][jjj].setText("\u2620");
                                    buttons[iii][jjj].setFont(button.getFont().deriveFont(30.F));
                                    buttons[iii][jjj].setBackground(Color.YELLOW);
                                    buttons[iii][jjj].setForeground(Color.GREEN);
                                }
                            }
                        }
                        button.setText("\u2620");
                        button.setFont(button.getFont().deriveFont(30.F));
                        button.setBackground(Color.RED);
                        button.setForeground(Color.WHITE);
                        isAlive = false;
                    } else {
                        int sumBombs = 0;
                        if (ii != 0 && ii != (SIZE - 1) && jj != 0 && jj != (SIZE - 1)) {//проверяем центр
                            for (int iii = (ii - 1); iii <= (ii + 1); iii++) {
                                for (int jjj = (jj - 1); jjj <= (jj + 1); jjj++) {
                                    if (bombs[iii][jjj]) sumBombs++;
                                }
                            }
                        } else if (jj == 0) {//проверяем левую вертикаль
                            if (ii == 0) {//лев вер угловую ячейку)
                                for (int iii = ii; iii <= (ii + 1); iii++) {
                                    for (int jjj = jj; jjj <= (jj + 1); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            }else if (ii == (SIZE-1)) {//лев ниж угловую ячейку)
                                for (int iii = (ii-1); iii <= (ii); iii++) {
                                    for (int jjj = jj; jjj <= (jj + 1); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            }else {
                                for (int iii = (ii - 1); iii <= (ii + 1); iii++) {
                                    for (int jjj = jj; jjj <= (jj + 1); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            }

                        } else if (jj == (SIZE - 1)) {//проверяем правую вертикаль
                            if (ii == 0) {//правую вер угловую ячейку)
                                for (int iii = (ii); iii <= (ii+1); iii++) {
                                    for (int jjj = (jj - 1); jjj <= (jj); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            } else if (ii == (SIZE - 1)) {//правую ниж угловую ячейку)
                                for (int iii = (ii-1); iii <= (ii); iii++) {
                                    for (int jjj = (jj-1); jjj <= (jj); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            } else {
                                for (int iii = (ii - 1); iii <= (ii + 1); iii++) {
                                    for (int jjj = (jj - 1); jjj <= (jj); jjj++) {
                                        if (bombs[iii][jjj]) sumBombs++;
                                    }
                                }
                            }
                        } else if (ii == 0) {//проверяем верхнюю горизонталь (кроме угловых ячеек)
                            for (int iii = (ii); iii <= (ii + 1); iii++) {
                                for (int jjj = (jj - 1); jjj <= (jj + 1); jjj++) {
                                    if (bombs[iii][jjj]) sumBombs++;
                                }
                            }
                        } else if (ii == (SIZE - 1)) {//проверяем нижнюю горизонталь (кроме угловых ячеек)
                            for (int iii = (ii - 1); iii <= (ii); iii++) {
                                for (int jjj = (jj - 1); jjj <= (jj + 1); jjj++) {
                                    if (bombs[iii][jjj]) sumBombs++;
                                }
                            }


                        }
                        button.setText(Integer.toString(sumBombs));
                        button.setBackground(Color.GREEN);
                    }

                });
                add(button);

//
//
//
            }

        }

        setVisible(true);
    }


}
